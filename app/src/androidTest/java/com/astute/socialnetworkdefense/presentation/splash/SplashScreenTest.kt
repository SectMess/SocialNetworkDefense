package com.astute.socialnetworkdefense.presentation.splash

import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithContentDescription
import androidx.navigation.NavController
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.astute.socialnetworkdefense.presentation.MainActivity
import com.astute.socialnetworkdefense.presentation.ui.theme.SocialNetworkDefenseTheme
import io.mockk.MockKAnnotations
import io.mockk.impl.annotations.RelaxedMockK
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.runBlocking
import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@ExperimentalCoroutinesApi
@RunWith(AndroidJUnit4::class)
class SplashScreenTest {

    @get:Rule
    val composeTestRule = createAndroidComposeRule<MainActivity>()

    @RelaxedMockK
    lateinit var navController: NavController

    @Before
    fun setUp() {
        MockKAnnotations.init(this)
    }

    @Test
    fun splashScreen_displaysAndDisappears() = runBlocking {
        composeTestRule.setContent {
            SocialNetworkDefenseTheme {
                SplashScreen(
                    navController = navController,
                )
            }
        }

        composeTestRule
            .onNodeWithContentDescription("Logo")
            .assertExists()
    }
}