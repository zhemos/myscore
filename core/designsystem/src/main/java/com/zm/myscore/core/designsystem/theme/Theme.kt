package com.zm.myscore.core.designsystem.theme

import android.os.Build
import androidx.annotation.ChecksSdkIntAtLeast
import androidx.annotation.VisibleForTesting
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext

@VisibleForTesting
private val DarkColorScheme = darkColorScheme(
    primary = MyScoreColors.PrimaryNight,
    onPrimary = MyScoreColors.Black,
    primaryContainer = MyScoreColors.PrimaryNight,
    onPrimaryContainer = MyScoreColors.Red,
    secondary = MyScoreColors.White,
    onSecondary = MyScoreColors.White,
    secondaryContainer = MyScoreColors.White,
    onSecondaryContainer = MyScoreColors.White,
    tertiary = MyScoreColors.Black,
    onTertiary = MyScoreColors.Black,
    tertiaryContainer = MyScoreColors.Black,
    onTertiaryContainer = MyScoreColors.Black,
    error = MyScoreColors.Black,
    onError = MyScoreColors.Black,
    errorContainer = MyScoreColors.Black,
    onErrorContainer = MyScoreColors.Black,
    background = MyScoreColors.Black,
    onBackground = MyScoreColors.Black,
    surface = MyScoreColors.PrimaryNight,
    onSurface = MyScoreColors.PrimaryNight,
    surfaceVariant = MyScoreColors.White,
    onSurfaceVariant = MyScoreColors.White,
    inverseSurface = MyScoreColors.Black,
    inverseOnSurface = MyScoreColors.Black,
    outline = MyScoreColors.DividerNight,
)

@VisibleForTesting
private val LightColorScheme = lightColorScheme(
    primary = MyScoreColors.PrimaryLight,
    onPrimary = MyScoreColors.White,
    primaryContainer = MyScoreColors.White,
    onPrimaryContainer = MyScoreColors.Red,
    secondary = MyScoreColors.White,
    onSecondary = Color.Green,
    secondaryContainer = Color.Magenta,
    onSecondaryContainer = Color.Red,
    tertiary = MyScoreColors.White,
    onTertiary = MyScoreColors.White,
    tertiaryContainer = Color.Red,
    onTertiaryContainer = Color.Red,
    error = MyScoreColors.White,
    onError = MyScoreColors.White,
    errorContainer = MyScoreColors.White,
    onErrorContainer = MyScoreColors.White,
    background = Color.Black,
    onBackground = MyScoreColors.Yellow,
    surface = MyScoreColors.White,
    onSurface = Color.Red,
    surfaceVariant = MyScoreColors.DarkYellow,
    onSurfaceVariant = MyScoreColors.DividerLight,
    inverseSurface = Color.Green,
    inverseOnSurface = Color.Red,
    outline = MyScoreColors.DividerLight,
)

@Composable
fun MyScoreTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    disableDynamicTheming: Boolean = true,
    content: @Composable () -> Unit,
) {
    val colorScheme = when {
        !disableDynamicTheming && supportsDynamicTheming() -> {
            val context = LocalContext.current
            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
        }
        else -> if (darkTheme) DarkColorScheme else LightColorScheme
    }
    // Background theme
    val defaultBackgroundTheme = BackgroundTheme(
        color = colorScheme.surface,
    )

    CompositionLocalProvider(
        LocalBackgroundTheme provides defaultBackgroundTheme,
    ) {
        MaterialTheme(
            colorScheme = colorScheme,
            typography = MyScoreTypography,
            content = content,
        )
    }
}

@ChecksSdkIntAtLeast(api = Build.VERSION_CODES.S)
internal fun supportsDynamicTheming() = Build.VERSION.SDK_INT >= Build.VERSION_CODES.S