package com.example.signinsample.ui.theme

import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider

@Composable
fun AppTheme(
    colors: AppColors = AppColors(),
    typography: AppTypography = AppTypography(),
    radius: AppRadius = AppRadius(),
    spacing: AppSpacing = AppSpacing(),
    content: @Composable () -> Unit
) {
    CompositionLocalProvider(
        LocalAppColors provides colors,
        LocalAppTypography provides typography,
        LocalAppRadius provides radius,
        LocalAppSpacing provides spacing
    ) {
        content()
    }
}

object AppTheme {
    val colors: AppColors
        @Composable
        get() = LocalAppColors.current

    val typography: AppTypography
        @Composable
        get() = LocalAppTypography.current

    val radius: AppRadius
        @Composable
        get() = LocalAppRadius.current

    val spacing: AppSpacing
        @Composable
        get() = LocalAppSpacing.current
}