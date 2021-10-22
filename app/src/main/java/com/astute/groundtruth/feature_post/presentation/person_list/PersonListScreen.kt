package com.astute.groundtruth.presentation

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.PersonAdd
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.navigation.NavController
import com.astute.groundtruth.R
import com.astute.groundtruth.core.domain.models.User
import com.astute.groundtruth.presentation.components.StandardToolbar
import com.astute.groundtruth.presentation.components.UserProfileItem
import com.astute.groundtruth.presentation.ui.theme.IconSizeMedium
import com.astute.groundtruth.presentation.ui.theme.SpaceLarge
import com.astute.groundtruth.presentation.ui.theme.SpaceMedium


@ExperimentalMaterialApi
@Composable
fun PersonListScreen(
    onNavigate: (String) -> Unit = {},
    onNavigateUp: () -> Unit = {},
) {
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        StandardToolbar(
            onNavigateUp = onNavigateUp,
            showBackArrow = true,
            title = {
                Text(
                    text = stringResource(id = R.string.liked_by),
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colors.onBackground
                )
            }
        )
        LazyColumn(
            modifier = Modifier.fillMaxSize(),
            contentPadding = PaddingValues(SpaceLarge)
        ) {
            items(10) {
                UserProfileItem(
                    user = User(
                        userId = "6127d2001241f332c88eb9a2",
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
                    }
                )
                Spacer(modifier = Modifier.height(SpaceMedium))
            }
        }
    }
}