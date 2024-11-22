package com.example.gamingquiz.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp

val MyTypography = Typography(
    bodyLarge = TextStyle(
        // Quiz - Answer Options
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Medium,
        fontSize = 20.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.5.sp,
        color = C1lr
    ),
    bodyMedium = TextStyle(
        // Login & PlayerScorePanel - Button
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Medium,
        fontSize = 15.sp,
        lineHeight = 20.sp,
        letterSpacing = 0.5.sp,
        color = C5lr
    ),
    titleLarge = TextStyle(
        // Login, Leaderboard, Questions & PlayerScore - Title
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Bold,
        fontSize = 35.sp,
        textAlign = TextAlign.Center,
        lineHeight = 35.sp,
        letterSpacing = 0.5.sp,
        color = TitleLargeColor,
        shadow = Shadow(
            color = Color.Black.copy(alpha = 0.5f),
            offset = Offset(2f, 2f),
            blurRadius = 4f
        )
    ),
    titleMedium = TextStyle(
        // Login, Leaderboard & PlayerScore - Text
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Medium,
        fontSize = 20.sp,
        lineHeight = 25.sp,
        letterSpacing = 0.sp,
        color = TitleMediumColor
    ),
    labelLarge = TextStyle(
        // Leaderboard - Rank
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Bold,
        fontSize = 25.sp,
        lineHeight = 16.sp,
        letterSpacing = 0.5.sp,
        color = C1lr,
    ),
    labelMedium = TextStyle(
        // Leaderboard - PlayerName
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.SemiBold,
        fontSize = 20.sp,
        lineHeight = 16.sp,
        letterSpacing = 0.5.sp,
        color = C2lr,
    ),
    labelSmall = TextStyle(
        // Leaderboard - Score
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 15.sp,
        lineHeight = 16.sp,
        letterSpacing = 0.5.sp,
        color = Color.LightGray,
    ),
)