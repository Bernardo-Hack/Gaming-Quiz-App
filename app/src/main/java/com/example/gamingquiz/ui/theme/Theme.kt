package com.example.gamingquiz.ui.theme

import androidx.compose.runtime.Composable
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme

@Composable
fun AppTheme(
    content: @Composable () -> Unit
) {
    MaterialTheme(
        colorScheme = MyColorScheme,
        typography = MyTypography,
        content = content,
    )
}