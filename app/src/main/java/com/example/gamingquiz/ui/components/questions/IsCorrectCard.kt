package com.example.gamingquiz.ui.components.questions

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.gamingquiz.ui.theme.PlayerScoreGradient
import com.example.gamingquiz.ui.theme.QuestionBackgroundGradient

@Composable
fun IsCorrectCard(
    isCorrect: Boolean,
    onClick: () -> Unit
    ) {

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(brush = QuestionBackgroundGradient)
            .padding(vertical = 20.dp, horizontal = 15.dp),
        contentAlignment = Alignment.Center
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier
                .fillMaxWidth()
                .padding(15.dp)
                .background(
                    brush = PlayerScoreGradient,
                    shape = RoundedCornerShape(5.dp)
                )
                .padding(32.dp)
        ) {
            Text(
                text = if (isCorrect) "Correct!" else "Incorrect!",
                color = if (isCorrect) Color(0xFF4CAF50) else Color(0xFFF44336),
                style = MaterialTheme.typography.titleLarge,
                textAlign = TextAlign.Center
            )

            Spacer(modifier = Modifier.height(24.dp))

            Button(
                onClick = { onClick() },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 32.dp)
            ) {
                Text(
                    text = "Next Question",
                    style = MaterialTheme.typography.bodyMedium
                )
            }
        }
    }
}