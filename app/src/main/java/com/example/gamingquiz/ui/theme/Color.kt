package com.example.gamingquiz.ui.theme

import androidx.compose.material3.darkColorScheme
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color

val C1lr = Color(0xFFD7AAF0)
val C2lr = Color(0xFFAA7ACC)
val C3lr = Color(0xFF6A4D80)
val C4lr = Color(0xFF42364D)
val C5lr = Color(0xFF242126)
val C6lr = Color(0xFF18161A)

val headlinerLargeColor = Color(0xFFC8C8C8)
val headlinerMediumColor = Color(0xFFAAAAAA)

val MyColorScheme = darkColorScheme(
    primary = C1lr,
    secondary = C2lr,
    tertiary = C3lr,
    background = C6lr,
    surface = C6lr,
    onSurface = C3lr,
    outline = C4lr
)

val LoginBackgroundGradient = Brush.verticalGradient(
    colors = listOf(C2lr, C4lr, C6lr)
)

val LeaderboardBackgroundGradient = Brush.verticalGradient(
    colors = listOf(C2lr, C4lr, C6lr)
)

val HeadlinerLargeGradient = Brush.linearGradient(
    colors = listOf(C4lr, C6lr)
)

val HeadlinerMediumGradient = Brush.linearGradient(
    colors = listOf(
        Color(127,127,127),
        C1lr)
)

val PanelGradient = Brush.linearGradient(
    colors = listOf(C5lr, C6lr)
)

val TextColor = C1lr

