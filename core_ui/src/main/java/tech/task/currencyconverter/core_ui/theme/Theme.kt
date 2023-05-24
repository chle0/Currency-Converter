package tech.task.currencyconverter.core_ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.lightColors
import androidx.compose.runtime.*
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import com.google.accompanist.systemuicontroller.rememberSystemUiController

const val ENABLE_DARK_THEME = false

private val LightColorPalette = lightColors(
    primary = primary,
    primaryVariant = primary_dark,
    secondary = secondary,
    secondaryVariant = secondary,
    background = white,
    surface = white,
    error = secondary,
    onPrimary = black,
    onSecondary = secondary,
    onBackground = white,
    onSurface = white,
    onError = secondary
)

private val DarkColorPalette = lightColors(
    primary = primary,
    primaryVariant = primary_dark,
    secondary = secondary,
    secondaryVariant = secondary,
    background = black,
    surface = black,
    error = secondary,
    onPrimary = white,
    onSecondary = secondary,
    onBackground = white,
    onSurface = white,
    onError = secondary
)

@Composable
fun ProvideDimens(
    dimensions: Dimensions,
    content: @Composable () -> Unit
) {
    val dimensionSet = remember { dimensions }
    CompositionLocalProvider(LocalAppDimens provides dimensionSet, content = content)
}

private val LocalAppDimens = staticCompositionLocalOf {
    smallDimensions
}

@Composable
fun CurrencyConverterTaskTheme(
    isDarkTheme: Boolean = isSystemInDarkTheme(),
    isPreview: Boolean = true,
    content: @Composable () -> Unit
) {
    val colors = if (ENABLE_DARK_THEME) {
        if (isDarkTheme) DarkColorPalette else LightColorPalette
    } else {
        LightColorPalette
    }
    val configuration = LocalConfiguration.current
    val dimensions = if (configuration.screenWidthDp <= 360) smallDimensions else sw360Dimensions

    if (!isPreview) {
        val sysUiController = rememberSystemUiController()
        SideEffect {
            sysUiController.setSystemBarsColor(color = colors.primary)
            sysUiController.setNavigationBarColor(color = Color.White)
        }
    }

    ProvideDimens(dimensions = dimensions) {
        MaterialTheme(
            colors = colors,
            typography = CurrencyConverterTaskTypography,
            shapes = CurrencyConverterTaskShapes,
            content = content
        )
    }

}

object CurrencyConverterTaskTheme {
    val dimens: Dimensions
        @Composable
        get() = LocalAppDimens.current
}
