package com.astute.socialnetworkdefense.presentation.util

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.ScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.astute.socialnetworkdefense.core.domain.models.Post
import com.astute.socialnetworkdefense.core.util.Screen
import com.astute.socialnetworkdefense.presentation.MainFeedScreen
import com.astute.socialnetworkdefense.presentation.PersonListScreen
import com.astute.socialnetworkdefense.feature_activity.presentation.activity.ActivityScreen
import com.astute.socialnetworkdefense.presentation.chat.ChatScreen
import com.astute.socialnetworkdefense.feature_post.presentation.create_post.CreatePostScreen
import com.astute.socialnetworkdefense.feature_profile.presentation.edit_profile.EditProfileScreen
import com.astute.socialnetworkdefense.feature_auth.presentation.login.LoginScreen
import com.astute.socialnetworkdefense.presentation.post_detail.PostDetailScreen
import com.astute.socialnetworkdefense.feature_profile.presentation.profile.ProfileScreen
import com.astute.socialnetworkdefense.feature_auth.presentation.register.RegisterScreen
import com.astute.socialnetworkdefense.feature_profile.presentation.search.SearchScreen
import com.astute.socialnetworkdefense.presentation.splash.SplashScreen

@ExperimentalMaterialApi
@Composable
fun Navigation(
    navController: NavHostController,
    scaffoldState: ScaffoldState
) {
    NavHost(
        navController = navController,
        startDestination = Screen.SplashScreen.route,
        modifier = Modifier.fillMaxSize()
    ){
        composable(Screen.SplashScreen.route){
            SplashScreen(navController = navController)
        }

        composable(Screen.LoginScreen.route){
            LoginScreen(navController = navController)
        }

        composable(Screen.RegisterScreen.route){
            RegisterScreen(
                navController = navController,
                scaffoldState = scaffoldState
            )
        }

        composable(Screen.MainFeedScreen.route){
            MainFeedScreen(navController = navController)
        }

        composable(Screen.ChatScreen.route) {
            ChatScreen(navController = navController)
        }

        composable(Screen.ActivityScreen.route) {
            ActivityScreen(navController = navController)
        }

        composable(Screen.ProfileScreen.route) {
            ProfileScreen(navController = navController)
        }

        composable(Screen.CreatePostScreen.route) {
            CreatePostScreen(navController = navController)
        }

        composable(Screen.EditProfileScreen.route) {
            EditProfileScreen(navController = navController)
        }

        composable(Screen.SearchScreen.route) {
            SearchScreen(navController = navController)
        }

        composable(Screen.PersonListScreen.route) {
            PersonListScreen(navController = navController)
        }

        composable(Screen.PostDetailScreen.route) {
            PostDetailScreen(
                navController = navController,
                post = Post(
                    username = "Philipp Lackner",
                    imageUrl = "",
                    profilePictureUrl = "",
                    description = "Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed\n" +
                            "diam nonumy eirmod tempor invidunt ut labore et dolore \n" +
                            "magna aliquyam erat, sed diam voluptua Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed\\n\" +\n" +
                            "                    \"diam nonumy eirmod tempor invidunt ut labore et dolore \\n\" +\n" +
                            "                    \"magna aliquyam erat, sed diam voluptua",
                    likeCount = 17,
                    commentCount = 7
                )
            )
        }

    }

}