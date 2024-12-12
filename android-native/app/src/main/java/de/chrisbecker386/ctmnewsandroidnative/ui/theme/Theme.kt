package de.chrisbecker386.ctmnewsandroidnative.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable

private val LightColorScheme =
    lightColorScheme(
        primary = appDarkGreen,
        onPrimary = appWhite,
        primaryContainer = appLightGreen,
        onPrimaryContainer = appBlack,
        secondary = appLightRed,
        onSecondary = appWhite,
        secondaryContainer = appLightRed,
        onSecondaryContainer = appBlack,
        tertiary = appDarkestGreen,
        onTertiary = appWhite,
        tertiaryContainer = appDarkestGreen,
        onTertiaryContainer = appWhite,
        error = appLightRed,
        onError = appWhite,
        errorContainer = appLightRed,
        onErrorContainer = appBlack,
        background = appWhite,
        onBackground = appBlack,
        surface = appWhite,
        onSurface = appBlack,
        surfaceVariant = appGray,
        onSurfaceVariant = appBlack,
        outline = appBlack,
    )

private val DarkColorScheme =
    darkColorScheme(
        primary = appDarkGreen,
        onPrimary = appBlack,
        primaryContainer = appDarkestGreen,
        onPrimaryContainer = appWhite,
        secondary = appLightRed,
        onSecondary = appBlack,
        secondaryContainer = appLightRed,
        onSecondaryContainer = appWhite,
        tertiary = appDarkestGreen,
        onTertiary = appBlack,
        tertiaryContainer = appDarkestGreen,
        onTertiaryContainer = appWhite,
        error = appLightRed,
        onError = appBlack,
        errorContainer = appLightRed,
        onErrorContainer = appWhite,
        background = appBlack,
        onBackground = appWhite,
        surface = appBlack,
        onSurface = appWhite,
        surfaceVariant = appDarkestGreen,
        onSurfaceVariant = appWhite,
        outline = appWhite,
    )

@Composable
fun CtmNewsAndroidNativeTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    // Dynamic color is available on Android 12+
    dynamicColor: Boolean = true,
    content: @Composable () -> Unit,
) {
    val colorScheme = if (!darkTheme) LightColorScheme else DarkColorScheme

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content,
    )
}
