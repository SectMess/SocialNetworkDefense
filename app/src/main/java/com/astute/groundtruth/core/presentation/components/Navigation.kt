package com.astute.groundtruth.presentation.util

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.ScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import coil.annotation.ExperimentalCoilApi
import com.astute.groundtruth.core.domain.models.Post
import com.astute.groundtruth.core.util.Screen
import com.astute.groundtruth.presentation.MainFeedScreen
import com.astute.groundtruth.presentation.PersonListScreen
import com.astute.groundtruth.feature_activity.presentation.ActivityScreen
import com.astute.groundtruth.presentation.chat.ChatScreen
import com.astute.groundtruth.feature_post.presentation.create_post.CreatePostScreen
import com.astute.groundtruth.feature_profile.presentation.edit_profile.EditProfileScreen
import com.astute.groundtruth.feature_auth.presentation.login.LoginScreen
import com.astute.groundtruth.presentation.post_detail.PostDetailScreen
import com.astute.groundtruth.feature_profile.presentation.profile.ProfileScreen
import com.astute.groundtruth.feature_auth.presentation.register.RegisterScreen
import com.astute.groundtruth.feature_profile.presentation.search.SearchScreen
import com.astute.groundtruth.presentation.splash.SplashScreen

@ExperimentalCoilApi
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
            SplashScreen(
                onPopBackStack = navController::popBackStack,
                onNavigate = navController::navigate
            )
        }

        composable(Screen.LoginScreen.route){
            LoginScreen(
                onNavigate = navController::navigate,
                scaffoldState = scaffoldState
            )
        }

        composable(Screen.RegisterScreen.route){
            RegisterScreen(
                navController = navController,
                scaffoldState = scaffoldState
            )
        }

        composable(Screen.MainFeedScreen.route){
            MainFeedScreen(
                onNavigateUp = navController::navigateUp,
                onNavigate = navController::navigate,
                scaffoldState = scaffoldState
            )
        }

        //TODO: Create MainMapScreen


        composable(Screen.ChatScreen.route) {
            ChatScreen(
                onNavigateUp = navController::navigateUp,
                onNavigate = navController::navigate,
            )
        }

        composable(Screen.ActivityScreen.route) {
            ActivityScreen(
                onNavigateUp = navController::navigateUp,
                onNavigate = navController::navigate,
            )
        }

        composable(
            route = Screen.ProfileScreen.route + "?userId={userId}",
            arguments = listOf(
                navArgument(name = "userId") {
                    type = NavType.StringType
                    nullable = true
                    defaultValue = null
                }
            )
        ) {
            ProfileScreen(
                userId = it.arguments?.getString("userId"),
                onNavigateUp = navController::navigateUp,
                onNavigate = navController::navigate,
                scaffoldState = scaffoldState
            )
        }

        composable(Screen.CreatePostScreen.route) {
            CreatePostScreen(
                onNavigateUp = navController::navigateUp,
                onNavigate = navController::navigate,
                scaffoldState = scaffoldState
            )
        }

        composable(
            Screen.EditProfileScreen.route + "/{userId}",
            arguments = listOf(
                navArgument(name = "userId") {
                    type = NavType.StringType
                }
            )
        ) {
            EditProfileScreen(
                onNavigateUp = navController::navigateUp,
                onNavigate = navController::navigate,
                scaffoldState = scaffoldState
            )
        }

        composable(Screen.SearchScreen.route) {
            SearchScreen(
                onNavigateUp = navController::navigateUp,
                onNavigate = navController::navigate,
            )
        }

        composable(Screen.PersonListScreen.route) {
            PersonListScreen(
                onNavigateUp = navController::navigateUp,
                onNavigate = navController::navigate,
            )
        }

        composable(
            route = Screen.PostDetailScreen.route + "/{postId}",
            arguments = listOf(
                navArgument(
                    name = "postId"
                ) {
                    type = NavType.StringType
                }
            )
        ) {
            PostDetailScreen(
                onNavigateUp = navController::navigateUp,
                onNavigate = navController::navigate
            )
        }

    }
}