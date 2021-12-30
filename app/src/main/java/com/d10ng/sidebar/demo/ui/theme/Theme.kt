package com.d10ng.sidebar.demo.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.Color
import com.google.accompanist.insets.ProvideWindowInsets
import com.google.accompanist.systemuicontroller.rememberSystemUiController

private val DarkColorPalette = darkColors(
    primary = lightPrimary,
    primaryVariant = lightPrimaryVariant,
    onPrimary = lightOnPrimary,
    secondary = lightSecondary,
    secondaryVariant = lightSecondaryVariant,
    onSecondary = lightOnSecondary,
    background = lightBackground,
    onBackground = lightOnPrimary
)

private val LightColorPalette = lightColors(
    primary = lightPrimary,
    primaryVariant = lightPrimaryVariant,
    onPrimary = lightOnPrimary,
    secondary = lightSecondary,
    secondaryVariant = lightSecondaryVariant,
    onSecondary = lightOnSecondary,
    background = lightBackground,
    onBackground = lightOnPrimary
)

@Composable
fun DLSideBarTheme(darkTheme: Boolean = isSystemInDarkTheme(), content: @Composable() () -> Unit) {
    val colors = if (darkTheme) {
        DarkColorPalette
    } else {
        LightColorPalette
    }

    MaterialTheme(
        colors = colors,
        shapes = Shapes,
        content = {
            ProvideWindowInsets(windowInsetsAnimationsEnabled = true) {
                val systemUiController = rememberSystemUiController()
                val useDarkIcons = MaterialTheme.colors.isLight
                SideEffect {
                    systemUiController.setStatusBarColor(
                        Color.Transparent, darkIcons = useDarkIcons)
                }
                Surface(content = content)
            }
        }
    )
}