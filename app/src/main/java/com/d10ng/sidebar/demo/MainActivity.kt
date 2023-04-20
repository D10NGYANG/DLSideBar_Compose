package com.d10ng.sidebar.demo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.core.view.WindowCompat
import com.d10ng.app.view.lockScreenOrientation
import com.d10ng.sidebar.demo.ui.page.NavGraphs
import com.d10ng.sidebar.demo.ui.theme.DLSideBarTheme
import com.google.accompanist.navigation.material.ExperimentalMaterialNavigationApi
import com.ramcosta.composedestinations.DestinationsNavHost
import com.ramcosta.composedestinations.animations.rememberAnimatedNavHostEngine

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalAnimationApi::class, ExperimentalMaterialNavigationApi::class,
        ExperimentalComposeUiApi::class
    )
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // 沉浸式状态栏
        WindowCompat.setDecorFitsSystemWindows(window, false)
        // 固定屏幕方向
        lockScreenOrientation(true)

        setContent {
            DLSideBarTheme {
                val engine = rememberAnimatedNavHostEngine()
                val navController = engine.rememberNavController()

                DestinationsNavHost(
                    engine = engine,
                    navController = navController,
                    navGraph = NavGraphs.root,
                    modifier = Modifier.fillMaxSize()
                )
            }
        }
    }
}