package com.astute.socialnetworkdefense.presentation.util

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
import com.astute.socialnetworkdefense.core.domain.models.Post
import com.astute.socialnetworkdefense.core.util.Screen
import com.astute.socialnetworkdefense.presentation.MainFeedScreen
import com.astute.socialnetworkdefense.presentation.PersonListScreen
import com.astute.socialnetworkdefense.feature_activity.presentation.ActivityScreen
import com.astute.socialnetworkdefense.presentation.chat.ChatScreen
import com.astute.socialnetworkdefense.feature_post.presentation.create_post.CreatePostScreen
import com.astute.socialnetworkdefense.feature_profile.presentation.edit_profile.EditProfileScreen
import com.astute.socialnetworkdefense.feature_auth.presentation.login.LoginScreen
import com.astute.socialnetworkdefense.presentation.post_detail.PostDetailScreen
import com.astute.socialnetworkdefense.feature_profile.presentation.profile.ProfileScreen
import com.astute.socialnetworkdefense.feature_auth.presentation.register.RegisterScreen
import com.astute.socialnetworkdefense.feature_profile.presentation.search.SearchScreen
import com.astute.socialnetworkdefense.presentation.splash.SplashScreen

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

        composable(
            route = Screen.PersonListScreen.route + "/{parentId}",
            arguments = listOf(
                navArgument("parentId") {
                    type = NavType.StringType
                }
            )
        ) {
            PersonListScreen(
                scaffoldState = scaffoldState,
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
                scaffoldState = scaffoldState,
                onNavigateUp = navController::navigateUp,
                onNavigate = navController::navigate
            )
        }

    }
}