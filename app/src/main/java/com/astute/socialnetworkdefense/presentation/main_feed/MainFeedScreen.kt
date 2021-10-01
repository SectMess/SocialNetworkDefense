package com.astute.socialnetworkdefense.presentation

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.astute.socialnetworkdefense.presentation.components.Post
import com.astute.socialnetworkdefense.presentation.util.Screen

@Composable
fun MainFeedScreen(
    navController: NavController
) {
    Post(
        post = com.astute.socialnetworkdefense.domain.models.Post(
            username = "Testing",
            imageUrl = "Testing",
            profilePictureUrl = "Testing",
            description = "Testing Testing Testing Testing Testing Testing Testing Testing Testing Testing Testing Testing Testing Testing Testing Testing Testing Testing Testing Testing",
            likeCount = 10,
            commentCount = 10
        )
    )
}