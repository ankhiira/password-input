package com.example.signinsample.ui.theme

import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

data class AppRadius(
    val radiusInput: Dp = 12.dp
)

val LocalAppRadius = staticCompositionLocalOf { AppRadius() }