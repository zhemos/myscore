package com.zm.myscore.core.designsystem.component

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.LocalAbsoluteTonalElevation
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.zm.myscore.core.designsystem.theme.LocalBackgroundTheme

@Composable
fun MyScoreBackground(
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit,
) {
    val color = LocalBackgroundTheme.current.color
    val tonalElevation = LocalBackgroundTheme.current.tonalElevation
    //tonalElevation = if (tonalElevation == Dp.Unspecified) 0.dp else tonalElevation,
    Surface(
        color = if (color == Color.Unspecified) Color.Transparent else color,
        tonalElevation = 20.dp,
        modifier = modifier.fillMaxSize(),
    ) {
//        CompositionLocalProvider(LocalAbsoluteTonalElevation provides 0.dp) {
//            content()
//        }
        content()
    }
}