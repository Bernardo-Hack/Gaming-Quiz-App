package com.example.gamingquiz.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Typography
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp

val MyTypography = Typography(
    bodyLarge = TextStyle(
        // Utilizada nos botões de resposta
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.5.sp,
        color = C1lr
    ),
    titleLarge = TextStyle(
        // Utilizada para títulos
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Bold,
        fontSize = 35.sp,
        textAlign = TextAlign.Center,
        lineHeight = 35.sp,
        letterSpacing = 0.5.sp,
        color = headlinerLargeColor
    ),
    titleMedium = TextStyle(
        // Utilizada para textos
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Medium,
        fontSize = 18.sp,
        lineHeight = 25.sp,
        letterSpacing = 0.sp,
        color = headlinerMediumColor
    ),
    labelLarge = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Medium,
        fontSize = 15.sp,
        lineHeight = 16.sp,
        letterSpacing = 0.5.sp
    )
)