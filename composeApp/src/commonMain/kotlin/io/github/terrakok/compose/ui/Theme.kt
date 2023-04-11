package io.github.terrakok.compose.ui

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.compositionLocalOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf

private val LightColors = lightColors(
    primary = md_theme_light_primary,
    onPrimary = md_theme_light_onPrimary,
    secondary = md_theme_light_secondary,
    onSecondary = md_theme_light_onSecondary,
    error = md_theme_light_error,
    onError = md_theme_light_onError,
    background = md_theme_light_background,
    onBackground = md_theme_light_onBackground,
    surface = md_theme_light_surface,
    onSurface = md_theme_light_onSurface,
)

private val DarkColors = darkColors(
    primary = md_theme_dark_primary,
    onPrimary = md_theme_dark_onPrimary,
    secondary = md_theme_dark_secondary,
    onSecondary = md_theme_dark_onSecondary,
    error = md_theme_dark_error,
    onError = md_theme_dark_onError,
    background = md_theme_dark_background,
    onBackground = md_theme_dark_onBackground,
    surface = md_theme_dark_surface,
    onSurface = md_theme_dark_onSurface,
)

val LocalThemeIsDark = compositionLocalOf { mutableStateOf(true) }

@Composable
fun AppTheme(
    content: @Composable() () -> Unit
) {
    CompositionLocalProvider(
        LocalThemeIsDark provides mutableStateOf(isSystemInDarkTheme())
    ) {
        val isDark by LocalThemeIsDark.current
        val colors = if (!isDark) LightColors else DarkColors

//        var robotoFontFamily: FontFamily by remember { mutableStateOf(FontFamily.Default) }
//
//        LaunchedEffect(Unit) {
//            robotoFontFamily = FontFamily(
//                Font("Roboto-Regular.ttf", resource("Roboto-Regular.ttf").readBytes())
//            )
//        }

        MaterialTheme(
            colors = colors,
//            typography = Typography(robotoFontFamily),
            content = {
                Surface(content = content)
            }
        )
    }
}
