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
import androidx.compose.ui.unit.dp

@VisibleForTesting
private val DarkColorScheme = darkColorScheme(
    primary = Black,
    onPrimary = Black,
    primaryContainer = Black,
    onPrimaryContainer = Black,
    secondary = Black,
    onSecondary = Black,
    secondaryContainer = Black,
    onSecondaryContainer = Black,
    tertiary = Black,
    onTertiary = Black,
    tertiaryContainer = Black,
    onTertiaryContainer = Black,
    error = Black,
    onError = Black,
    errorContainer = Black,
    onErrorContainer = Black,
    background = Black,
    onBackground = Black,
    surface = Black,
    onSurface = Black,
    surfaceVariant = Black,
    onSurfaceVariant = Black,
    inverseSurface = Black,
    inverseOnSurface = Black,
    outline = Black,
)

@VisibleForTesting
private val LightColorScheme = lightColorScheme(
    primary = Color.Green,
    onPrimary = White,
    primaryContainer = Color.Magenta,
    onPrimaryContainer = Color.Yellow,
    secondary = Color.Red,
    onSecondary = Color.Green,
    secondaryContainer = Color.Magenta,
    onSecondaryContainer = Color.Yellow,
    tertiary = Color.Magenta,
    onTertiary = White,
    tertiaryContainer = Color.Red,
    onTertiaryContainer = Color.Blue,
    error = White,
    onError = White,
    errorContainer = White,
    onErrorContainer = White,
    background = Color.Black,
    onBackground = Yellow,
    surface = White,
    onSurface = Red10,
    surfaceVariant = DarkYellow,
    onSurfaceVariant = Gray,
    inverseSurface = Color.Green,
    inverseOnSurface = Color.Red,
    outline = Color.Magenta,
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
        tonalElevation = 2.dp,
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