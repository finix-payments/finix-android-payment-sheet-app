package com.example.sampletokenize.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.material.ripple.RippleTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.ui.graphics.Color
import com.example.sampletokenize.ui.compose.common.isLight


private val DarkColorPalette2 = darkColors(
    primary = Purple200,
    primaryVariant = Purple700,
    secondary = Teal200
)

private val LightColorPalette2 = lightColors(
    primary = Purple500,
    primaryVariant = Purple700,
    secondary = Teal200

        /* Other default colors to override
    background = Color.White,
    surface = Color.White,
    onPrimary = Color.White,
    onSecondary = Color.Black,
    onBackground = Color.Black,
    onSurface = Color.Black,


    primary,
    primaryVariant,
    secondary,
    secondaryVariant,
    background,
    surface,
    error,
    onPrimary,
    onSecondary,
    onBackground,
    onSurface,
    onError,
    */
)

private val DarkColorPalette = darkColors(
    surface = Blue,
    onSurface = Navy,
    primary = Navy,
    onPrimary = Chartreuse
)

private val LightColorPalette = lightColors(
    surface = addCardColor,
    onSurface = Color.Black,
    primary = Purple700,
    primaryVariant = Purple700,
    onPrimary = Purple700,
    background = Color.White,
    onBackground = Color.LightGray,
    error = Color.Red,
)

@Composable
fun SampleTokenizeTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colors =
        if (darkTheme) { LightColorPalette } else { LightColorPalette }

    MaterialTheme(
        colors = colors,
        typography = Typography,
        shapes = Shapes,
        content = content
    )
}

@Immutable
private object SecondaryRippleTheme : RippleTheme {
    @Composable
    override fun defaultColor() = RippleTheme.defaultRippleColor(
        contentColor = androidx.compose.material3.MaterialTheme.colorScheme.secondary,
        lightTheme = androidx.compose.material3.MaterialTheme.colorScheme.isLight()
    )

    @Composable
    override fun rippleAlpha() = RippleTheme.defaultRippleAlpha(
        contentColor = androidx.compose.material3.MaterialTheme.colorScheme.secondary,
        lightTheme = androidx.compose.material3.MaterialTheme.colorScheme.isLight()
    )
}

