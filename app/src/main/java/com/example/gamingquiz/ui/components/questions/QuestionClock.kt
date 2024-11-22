package com.example.gamingquiz.ui.components.questions

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.height
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.gamingquiz.ui.theme.AppTheme
import kotlinx.coroutines.delay

@Composable
fun QuestionClock(
    timeLimit: Int,
    onTimeUp: () -> Unit
) {
    var timeLeft by remember { mutableFloatStateOf((timeLimit.toFloat() * 1000)) }
    // ticks is the time remaining, gotta implement it properly

    val clockColor = MaterialTheme.colorScheme.primary
    val clockBorderColor = MaterialTheme.colorScheme.tertiary
    var sweepAngle by remember {mutableFloatStateOf(360f)}

    Box {
        Canvas(
            modifier = Modifier
                .height(120.dp)
                .aspectRatio(ratio = 1f)
                .align(Alignment.Center)
        ) {
            val canvasWidth = size.width
            val arcDiameter = canvasWidth * .75f

            drawCircle(
                color = clockBorderColor,
                style = Stroke(canvasWidth * 0.05f),
                radius = canvasWidth * .45f
            )

            drawArc(
                color = clockColor,
                startAngle = 270f,
                sweepAngle = sweepAngle,
                useCenter = true,
                topLeft = Offset((canvasWidth - arcDiameter) / 2, (canvasWidth - arcDiameter) / 2),
                size = Size(arcDiameter, arcDiameter)
            )

        }

        Text(
            text = (timeLeft / 1000).toInt().toString(),
            fontSize = 35.sp,
            color = clockBorderColor,
            modifier = Modifier
                .align(Alignment.Center)
        )

        LaunchedEffect(Unit) {
            while(timeLeft > 0) {
                delay(1000)
                timeLeft -= 1000
                sweepAngle = ((timeLeft / 1000) / timeLimit) * 360
            }
            onTimeUp()
        }
    }
}

@Preview
@Composable
private fun ClockArcSample() {
    AppTheme {
        QuestionClock(
            timeLimit = 15,
            onTimeUp = {}
        )
    }
}