package com.example.signinsample.ui.theme

import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

data class AppSpacing(
    val spacingXs: Dp = 8.dp,
    val spacingS: Dp = 12.dp,
    val spacingM: Dp = 16.dp,
    val spacingL: Dp = 20.dp
)

val LocalAppSpacing = staticCompositionLocalOf { AppSpacing() }