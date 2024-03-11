package com.zm.myscore.core.designsystem.theme

import androidx.compose.ui.graphics.Color

internal object MyScoreColors {
    val PrimaryLight = Color(0xFF001E28)
    val PrimaryNight = Color(0xFF00141D)
    val Black = Color(0xFF010A0F)
    val White = Color(0xFFFFFFFF)
    val Red = Color(0xFFC70237)
    val DarkYellow = Color(0xFFEACF1E)
    val Yellow = Color(0xFFFFF2CF)
    val DividerLight = Color(0xFFC8C8C8)
    val DividerNight = Color(0xFF091C22)
}

fun getStatusBarColor(isDarkTheme: Boolean): Color {
    return if (isDarkTheme) {
        MyScoreColors.PrimaryNight
    } else {
        MyScoreColors.PrimaryLight
    }
}