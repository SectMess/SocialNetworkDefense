package com.astute.groundtruth.feature_map.presentation.mission_map

import androidx.compose.animation.Crossfade
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.hilt.navigation.compose.hiltViewModel
import com.astute.groundtruth.R
import com.astute.groundtruth.core.domain.models.Mission
import com.astute.groundtruth.core.presentation.util.UiEvent
import com.astute.groundtruth.core.util.Screen
import com.astute.groundtruth.core.util.asString
import com.astute.groundtruth.feature_map.presentation.util.Constants.InitialZoom
import com.astute.groundtruth.feature_map.presentation.util.Constants.MaxZoom
import com.astute.groundtruth.feature_map.presentation.util.Constants.MinZoom
import com.astute.groundtruth.presentation.components.StandardToolbar
import com.google.android.libraries.maps.CameraUpdateFactory
import com.google.android.libraries.maps.MapView
import com.google.android.libraries.maps.model.LatLng
import com.google.maps.android.ktx.addMarker
import com.google.maps.android.ktx.awaitMap
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@Composable
fun MissionMapScreen(
    onNavigate: (String) -> Unit = {},
    onNavigateUp: () -> Unit = {},
    scaffoldState: ScaffoldState,
    viewModel: MissionMapViewModel = hiltViewModel()
) {
    val state = viewModel.state.value
    val context = LocalContext.current

    LaunchedEffect(key1 = true) {
        viewModel.eventFlow.collectLatest { event ->
            when (event) {
                is UiEvent.ShowSnackbar -> {
                    GlobalScope.launch {
                        scaffoldState.snackbarHostState.showSnackbar(
                            message = event.uiText.asString(context)
                        )
                    }
                }
                is UiEvent.NavigateUp -> {
                    onNavigateUp()
                }
            }
        }
    }


    Column(
        modifier = Modifier.fillMaxWidth()
    ) {
        StandardToolbar(
            onNavigateUp = onNavigateUp,
            title = {
                Text(
                    text = stringResource(id = R.string.map_view_feed),
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colors.onBackground
                )
            },
            modifier = Modifier.fillMaxWidth(),
            showBackArrow = false,
            navActions = {
                IconButton(onClick = {
                    onNavigate(Screen.SearchScreen.route)
                }) {
                    Icon(
                        imageVector = Icons.Default.Search,
                        contentDescription = "",
                        tint = MaterialTheme.colors.onBackground
                    )
                }
            }
        )

        Box(modifier = Modifier.fillMaxSize()) {
            println("STATES  $state")

            state.mission?.let { MissionMapContent(it, Modifier.fillMaxSize()) }
//            Crossfade(targetState = state, modifier = Modifier.fillMaxSize()) { currentUiState ->
//                when {
//                    currentUiState.mission != null -> {
//                        MissionMapContent(currentUiState.mission, Modifier.fillMaxSize())
//                    }
//                    currentUiState.isLoadingMission -> {
//                        Box(Modifier.fillMaxSize()) {
//                            CircularProgressIndicator(
//                                color = MaterialTheme.colors.onSurface,
//                                modifier = Modifier.align(Alignment.Center)
//                            )
//                        }
//                    }
//                    else -> {
//
//                    }
//                }
//            }
        }
    }
}

@Composable
fun MissionMapContent(
    mission: Mission,
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier, verticalArrangement = Arrangement.Center) {
//        Spacer(Modifier.height(32.dp))
//        Text(
//            modifier = Modifier.align(Alignment.CenterHorizontally),
//            text = mission.missionId,
//            style = MaterialTheme.typography.h4,
//            textAlign = TextAlign.Center
//        )
//        Text(
//            modifier = Modifier.align(Alignment.CenterHorizontally),
//            text = mission.description,
//            style = MaterialTheme.typography.h6,
//            textAlign = TextAlign.Center
//        )
//        Spacer(Modifier.height(16.dp))
        MissionMapView(mission.latitude, mission.longitude)
    }
}

@Composable
private fun MissionMapView(latitude: String, longitude: String) {
    // The MapView lifecycle is handled by this composable. As the MapView also needs to be updated
    // with input from Compose UI, those updates are encapsulated into the MapViewContainer
    // composable. In this way, when an update to the MapView happens, this composable won't
    // recompose and the MapView won't need to be recreated.
    val mapView = rememberMapViewWithLifecycle()
    MapViewContainer(mapView, latitude, longitude)
}

@Composable
private fun MapViewContainer(
    map: MapView,
    latitude: String,
    longitude: String
) {
    val cameraPosition = remember(latitude, longitude) {
        LatLng(latitude.toDouble(), longitude.toDouble())
    }

    LaunchedEffect(map) {
        val googleMap = map.awaitMap()
        googleMap.addMarker { position(cameraPosition) }
        googleMap.moveCamera(CameraUpdateFactory.newLatLng(cameraPosition))
    }

    var zoom by rememberSaveable(map) { mutableStateOf(InitialZoom) }


    val coroutineScope = rememberCoroutineScope()
    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {
        AndroidView({ map }) { mapView ->
            // Reading zoom so that AndroidView recomposes when it changes. The getMapAsync lambda
            // is stored for later, Compose doesn't recognize state reads
            val mapZoom = zoom
            coroutineScope.launch {
                val googleMap = mapView.awaitMap()
                googleMap.setZoom(mapZoom)
                // Move camera to the same place to trigger the zoom update
                googleMap.moveCamera(CameraUpdateFactory.newLatLng(cameraPosition))
            }
        }
        ZoomControls(zoom) {
            zoom = it.coerceIn(MinZoom, MaxZoom)
        }
    }


}

@Composable
private fun ZoomControls(
    zoom: Float,
    onZoomChanged: (Float) -> Unit
) {
    Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center) {
        ZoomButton("-", onClick = { onZoomChanged(zoom * 0.8f) })
        ZoomButton("+", onClick = { onZoomChanged(zoom * 1.2f) })
    }
}

@Composable
private fun ZoomButton(text: String, onClick: () -> Unit) {
    Button(
        modifier = Modifier.padding(8.dp),
        colors = ButtonDefaults.buttonColors(
            backgroundColor = MaterialTheme.colors.onPrimary,
            contentColor = MaterialTheme.colors.primary
        ),
        onClick = onClick
    ) {
        Text(text = text, style = MaterialTheme.typography.h5)
    }
}