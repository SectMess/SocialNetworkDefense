package com.astute.groundtruth.feature_profile.presentation.search

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.PersonAdd
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.astute.groundtruth.R
import com.astute.groundtruth.core.domain.models.User
import com.astute.groundtruth.core.util.Screen
import com.astute.groundtruth.presentation.components.StandardTextField
import com.astute.groundtruth.presentation.components.StandardToolbar
import com.astute.groundtruth.presentation.components.UserProfileItem
import com.astute.groundtruth.presentation.ui.theme.IconSizeMedium
import com.astute.groundtruth.presentation.ui.theme.SpaceLarge
import com.astute.groundtruth.presentation.ui.theme.SpaceMedium
import com.astute.groundtruth.presentation.util.states.StandardTextFieldState

@ExperimentalMaterialApi
@Composable
fun SearchScreen(
    onNavigate: (String) -> Unit = {},
    onNavigateUp: () -> Unit = {},
    viewModel: SearchViewModel = hiltViewModel()
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
                text = viewModel.searchState.value.text,
                hint = stringResource(id = R.string.search),
                error = "",
                leadingIcon = Icons.Default.Search,
                onValueChange = {
                    viewModel.setSearchState(
                        StandardTextFieldState(text = it)
                    )
                }
            )
            Spacer(modifier = Modifier.height(SpaceLarge))
            LazyColumn(
                modifier = Modifier.fillMaxSize()
            ) {
                items(10) {
                    UserProfileItem(
                        user = User(
                            userId = "615ef4c928959a41f3a89ca2",
                            profilePictureUrl = "",
                            username = "Test Astute",
                            description = "Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed\n" +
                                    "diam nonumy eirmod tempor invidunt ut labore et dolore \n" +
                                    "magna aliquyam erat, sed diam voluptua",
                            followerCount = 234,
                            followingCount = 534,
                            postCount = 65
                        ),
                        actionIcon = {
                            Icon(
                                imageVector = Icons.Default.PersonAdd,
                                contentDescription = null,
                                tint = MaterialTheme.colors.onBackground,
                                modifier = Modifier.size(IconSizeMedium)
                            )
                        },
                        onItemClick = {
                            onNavigate(
                                Screen.ProfileScreen.route + "?userId=616ab8eeddc6e878cd062c96"
                            )

                        }
                    )
                    Spacer(modifier = Modifier.height(SpaceMedium))
                }
            }
        }
    }
}