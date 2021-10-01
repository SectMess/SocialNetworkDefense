package com.astute.socialnetworkdefense.presentation.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Message
import androidx.compose.material.icons.outlined.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.astute.socialnetworkdefense.domain.models.BottomNavItem
import com.astute.socialnetworkdefense.presentation.util.Screen
import com.astute.socialnetworkdefense.R


@Composable
fun StandardScaffold(
    navController: NavController,
    modifier: Modifier = Modifier,
    showBottomBar: Boolean = true,
    //Display the Bottom Nav items
    bottomNavItems: List<BottomNavItem> = listOf(
        BottomNavItem(
            route = Screen.MainFeedScreen.route,
            icon = Icons.Outlined.Home,
            contentDescription = "Home"
        ),
        BottomNavItem(
            route = Screen.ChatScreen.route,
            icon = Icons.Outlined.Message,
            contentDescription = "Message"
        ),
        BottomNavItem(route = ""),
        BottomNavItem(
            route = Screen.ActivityScreen.route,
            icon = Icons.Outlined.Notifications,
            contentDescription = "Activity"
        ),
        BottomNavItem(
            route = Screen.ProfileScreen.route,
            icon = Icons.Outlined.Person,
            contentDescription = "Profile"
        ),
    ),
    onFabClick: () -> Unit = {},
    content: @Composable () -> Unit
) {
    Scaffold(
        bottomBar = {
            //There are screens where we dont want to show BottomBar
            if (showBottomBar) {
                BottomAppBar(
                    modifier = Modifier.fillMaxWidth(),
                    backgroundColor = MaterialTheme.colors.surface,
                    cutoutShape = CircleShape,
                    elevation = 5.dp
                ) {
                    BottomNavigation {
                        bottomNavItems.forEachIndexed { i, bottomNavItem ->
                            //using the standard component
                            StandardBottomNavItem(
                                icon = bottomNavItem.icon,
                                contentDescription = bottomNavItem.contentDescription,
                                selected = bottomNavItem.route == navController.currentDestination?.route,
                                alertCount = bottomNavItem.alertCount,
                                enabled = bottomNavItem.icon != null
                            ) {
                                if(navController.currentDestination?.route != bottomNavItem.route) {
                                    navController.navigate(bottomNavItem.route)
                                }
                            }
                        }
                    }
                }
            }
        },
        floatingActionButton = {
            if(showBottomBar) {
                FloatingActionButton(
                    backgroundColor = MaterialTheme.colors.primary,
                    onClick = onFabClick
                ) {
                    Icon(
                        imageVector = Icons.Default.Add,
                        contentDescription = stringResource(id = R.string.make_post)
                    )
                }
            }
        },
        isFloatingActionButtonDocked = true,
        floatingActionButtonPosition = FabPosition.Center,
        modifier = modifier
    ) {
        content()
    }
}