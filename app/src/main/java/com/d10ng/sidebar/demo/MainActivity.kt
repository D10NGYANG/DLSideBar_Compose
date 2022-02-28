package com.d10ng.sidebar.demo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.core.tween
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.view.WindowCompat
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.d10ng.applib.view.lockScreenOrientation
import com.d10ng.sidebar.demo.model.AppViewModel
import com.d10ng.sidebar.demo.ui.page.AREA_SCREEN
import com.d10ng.sidebar.demo.ui.page.AreaScreen
import com.d10ng.sidebar.demo.ui.page.HOME_SCREEN
import com.d10ng.sidebar.demo.ui.page.HomeScreen
import com.d10ng.sidebar.demo.ui.theme.DLSideBarTheme
import com.google.accompanist.navigation.animation.AnimatedNavHost
import com.google.accompanist.navigation.animation.composable
import com.google.accompanist.navigation.animation.rememberAnimatedNavController

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalAnimationApi::class, ExperimentalComposeUiApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // 沉浸式状态栏
        WindowCompat.setDecorFitsSystemWindows(window, false)
        // 固定屏幕方向
        lockScreenOrientation(true)

        setContent {
            DLSideBarTheme {
                val navController = rememberAnimatedNavController()
                Box(modifier = Modifier.fillMaxSize()) {
                    MainNavigation(navController = navController)
                }
            }
        }
    }
}

@ExperimentalComposeUiApi
@ExperimentalAnimationApi
@Composable
fun MainNavigation(
    navController: NavHostController
) {
    val appModel: AppViewModel = viewModel()

    AnimatedNavHost(
        navController,
        HOME_SCREEN,
        modifier = Modifier
            .fillMaxSize(),
        enterTransition = {
            slideInHorizontally(initialOffsetX = {it})
        },
        exitTransition = {
            slideOutHorizontally(targetOffsetX = {-it})
        },
        popEnterTransition = {
            slideInHorizontally(initialOffsetX = {-it})
        },
        popExitTransition = {
            slideOutHorizontally(targetOffsetX = {it})
        }
    ) {
        composable(HOME_SCREEN) {
            HomeScreen(navController, appModel)
        }
        composable(AREA_SCREEN) {
            AreaScreen(navController, appModel)
        }
    }
}