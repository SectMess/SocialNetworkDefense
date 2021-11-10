package com.astute.socialnetworkdefense.feature_profile.presentation.search

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.PersonAdd
import androidx.compose.material.icons.filled.PersonRemove
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import coil.ImageLoader
import coil.annotation.ExperimentalCoilApi
import com.astute.socialnetworkdefense.R
import com.astute.socialnetworkdefense.core.domain.models.User
import com.astute.socialnetworkdefense.core.util.Screen
import com.astute.socialnetworkdefense.presentation.components.StandardTextField
import com.astute.socialnetworkdefense.presentation.components.StandardToolbar
import com.astute.socialnetworkdefense.presentation.components.UserProfileItem
import com.astute.socialnetworkdefense.presentation.ui.theme.IconSizeMedium
import com.astute.socialnetworkdefense.presentation.ui.theme.SpaceLarge
import com.astute.socialnetworkdefense.presentation.ui.theme.SpaceMedium
import com.astute.socialnetworkdefense.presentation.util.states.StandardTextFieldState

@ExperimentalCoilApi
@ExperimentalMaterialApi
@Composable
fun SearchScreen(
    imageLoader: ImageLoader,
    onNavigate: (String) -> Unit = {},
    onNavigateUp: () -> Unit = {},
    viewModel: SearchViewModel = hiltViewModel()
) {
    val state = viewModel.searchState.value
    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        Column(
            modifier = Modifier.fillMaxSize()
        ) {
            StandardToolbar(
                onNavigateUp = onNavigateUp,
                showBackArrow = true,
                title = {
                    Text(
                        text = stringResource(id = R.string.search_for_users),
                        fontWeight = FontWeight.Bold,
                        color = MaterialTheme.colors.onBackground
                    )
                }
            )
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(SpaceLarge)
            ) {
                StandardTextField(
                    modifier = Modifier
                        .fillMaxWidth(),
                    text = viewModel.searchFieldState.value.text,
                    hint = stringResource(id = R.string.search),
                    error = "",
                    leadingIcon = Icons.Default.Search,
                    onValueChange = {
                        viewModel.onEvent(SearchEvent.Query(it))
                    }
                )
                Spacer(modifier = Modifier.height(SpaceLarge))
                LazyColumn(
                    modifier = Modifier.fillMaxSize()
                ) {
                    items(state.userItems) { user ->
                        UserProfileItem(
                            user = user,
                            imageLoader = imageLoader,
                            actionIcon = {
                                IconButton(
                                    onClick = {
                                        viewModel.onEvent(SearchEvent.ToggleFollowState(user.userId))
                                    },
                                    modifier = Modifier
                                        .size(IconSizeMedium)
                                ) {
                                    Icon(
                                        imageVector = if (user.isFollowing) {
                                            Icons.Default.PersonRemove
                                        } else Icons.Default.PersonAdd,
                                        contentDescription = null,
                                        tint = MaterialTheme.colors.onBackground,
                                    )
                                }
                            },
                            onItemClick = {
                                onNavigate(
                                    Screen.ProfileScreen.route + "?userId=${user.userId}"
                                )
                            }
                        )
                        Spacer(modifier = Modifier.height(SpaceMedium))
                    }
                }
            }
        }
        if (state.isLoading) {
            CircularProgressIndicator(
                modifier = Modifier.align(Alignment.Center)
            )
        }
    }

}