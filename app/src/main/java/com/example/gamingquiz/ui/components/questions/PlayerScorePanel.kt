package com.example.gamingquiz.ui.components.questions

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.gamingquiz.data.database.QuizDatabase
import com.example.gamingquiz.data.repository.PlayerRepository
import com.example.gamingquiz.data.viewModel.PlayerViewModel
import com.example.gamingquiz.data.viewModel.PlayerViewModelFactory
import com.example.gamingquiz.ui.theme.AppTheme
import com.example.gamingquiz.ui.theme.LeaderboardBackgroundGradient
import com.example.gamingquiz.ui.theme.LoginBackgroundGradient
import com.example.gamingquiz.ui.theme.PlayerScoreGradient
import com.example.gamingquiz.ui.theme.QuestionBackgroundGradient

@Composable
fun PlayerScorePanel(
    score: Int,
    onFinish: () -> Unit,
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
                text = "Quiz Finished.",
                style = MaterialTheme.typography.titleLarge,
                textAlign = TextAlign.Center
            )

            Spacer(modifier = Modifier.height(24.dp))

            Text(
                text = "Your Score:\n $score",
                style = MaterialTheme.typography.titleMedium
            )

            Spacer(modifier = Modifier.height(24.dp))

            Button(
                onClick = { onFinish() },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 32.dp)
            ) {
                Text(
                    text = "Leaderboard",
                    style = MaterialTheme.typography.bodyMedium
                )
            }
        }
    }
}

@Preview
@Composable
fun PlayerScorePanelPreview() {
    AppTheme {
        PlayerScorePanel(
            score = 1000,
            onFinish = {}
        )
    }
}