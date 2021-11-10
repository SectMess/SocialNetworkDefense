package com.astute.socialnetworkdefense.presentation.util

import android.content.Intent
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
import androidx.navigation.navDeepLink
import coil.ImageLoader
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
    scaffoldState: ScaffoldState,
    imageLoader: ImageLoader
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
                onLogin = {
                    navController.popBackStack(
                        route = Screen.LoginScreen.route,
                        inclusive = true
                    )
                    navController.navigate(route = Screen.MainFeedScreen.route)
                },
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
                scaffoldState = scaffoldState,
                imageLoader = imageLoader
            )
        }

        composable(Screen.ChatScreen.route) {
            ChatScreen(
                onNavigateUp = navController::navigateUp,
                onNavigate = navController::navigate,
                imageLoader = imageLoader
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
                onLogout = {
                    navController.navigate(route = Screen.LoginScreen.route)
                },
                onNavigate = navController::navigate,
                scaffoldState = scaffoldState,
                imageLoader = imageLoader
            )
        }

        composable(Screen.CreatePostScreen.route) {
            CreatePostScreen(
                onNavigateUp = navController::navigateUp,
                onNavigate = navController::navigate,
                scaffoldState = scaffoldState,
                imageLoader = imageLoader
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
                scaffoldState = scaffoldState,
                imageLoader = imageLoader
            )
        }

        composable(Screen.SearchScreen.route) {
            SearchScreen(
                onNavigateUp = navController::navigateUp,
                onNavigate = navController::navigate,
                imageLoader = imageLoader
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
                imageLoader = imageLoader
            )
        }

        composable(
            route = Screen.PostDetailScreen.route + "/{postId}?shouldShowKeyboard={shouldShowKeyboard}",
            arguments = listOf(
                navArgument(
                    name = "postId"
                ) {
                    type = NavType.StringType
                },
                navArgument(
                    name = "shouldShowKeyboard"
                ) {
                    type = NavType.BoolType
                    defaultValue = false
                }
            ),
            deepLinks = listOf(
                navDeepLink {
                    action = Intent.ACTION_VIEW
                    uriPattern = "https://pl-coding.com/{postId}"
                }
            )
        ) {
            val shouldShowKeyboard = it.arguments?.getBoolean("shouldShowKeyboard") ?: false
            println("POST ID: ${it.arguments?.getString("postId")}")
            PostDetailScreen(
                scaffoldState = scaffoldState,
                onNavigateUp = navController::navigateUp,
                onNavigate = navController::navigate,
                shouldShowKeyboard = shouldShowKeyboard,
                imageLoader = imageLoader
            )
        }

    }
}