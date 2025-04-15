package com.example.signinsample.common.ui.components

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import com.example.signinsample.ui.theme.AppTheme

data class InputViewColors(
    val inputColor: Color,
    val cursorColor: Color,
    val borderColor: Color,
    val focusedBorderColor: Color,
    val labelColor: Color,
    val focusedLabelColor: Color,
    val errorBorderColor: Color,
    val errorTextColor: Color,
    val placeholderColor: Color
)

@Composable
fun defaultInputViewColors(): InputViewColors {
    return InputViewColors(
        inputColor = AppTheme.colors.onNeutralXxHigh,
        cursorColor = AppTheme.colors.onNeutralXxHigh,
        borderColor = AppTheme.colors.surfaceXHigh,
        focusedBorderColor = AppTheme.colors.defaultFocus,
        labelColor = AppTheme.colors.onNeutralXxHigh,
        focusedLabelColor = AppTheme.colors.defaultFocus,
        errorBorderColor = AppTheme.colors.surfaceDanger,
        errorTextColor = AppTheme.colors.onNeutralDanger,
        placeholderColor = AppTheme.colors.onNeutralLow
    )
}