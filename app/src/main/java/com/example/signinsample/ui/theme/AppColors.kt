package com.example.signinsample.ui.theme

import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color

val Gray950 = Color(0xFF2C2C31)
val Gray500 = Color(0xFF8C8C9A)
val Gray300 = Color(0xFFC9C9CE)
val Gray00 = Color(0xFFFFFFFF)

val Red600 = Color(0xFFDC2828)

val AlphaDim800 = Color(0xCC1A1A1A)

data class AppColors(
    val surfaceXHigh: Color = Gray500,
    val surfaceXLow: Color = Gray00,
    val surfaceDanger: Color = Red600,
    val onNeutralXxHigh: Color = Gray950,
    val onNeutralLow: Color = Gray300,
    val onNeutralDanger: Color = Red600,
    val defaultFocus: Color = AlphaDim800,
)

val LocalAppColors = staticCompositionLocalOf { AppColors() }