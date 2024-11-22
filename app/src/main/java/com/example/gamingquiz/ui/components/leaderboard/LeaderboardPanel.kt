package com.example.gamingquiz.ui.components.leaderboard

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.sharp.Home
//import androidx.compose.material.icons.sharp.Refresh
import androidx.compose.material3.FilledIconButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.gamingquiz.data.model.Player
import com.example.gamingquiz.ui.theme.AppTheme
import com.example.gamingquiz.ui.theme.LeaderboardBackgroundGradient

@Composable
fun LeaderboardPanel(
    //onRestart: () -> Unit = {},
    onExit: () -> Unit = {},
    players: List<Player>?
) {

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(brush = LeaderboardBackgroundGradient)
            .padding(vertical = 20.dp, horizontal = 15.dp),
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top
        ) {
            Spacer(modifier = Modifier.height(16.dp))

            Row(
                horizontalArrangement = Arrangement.SpaceEvenly,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .height(60.dp)
                    .fillMaxWidth()
            ) {

                Text(
                    text = "Leaderboard",
                    style = MaterialTheme.typography.titleLarge,
                    modifier = Modifier.padding(8.dp)
                )

                FilledIconButton(
                    onClick = onExit,
                    modifier = Modifier.padding(8.dp),
                    content = {
                        Icon(
                            imageVector = Icons.Sharp.Home,
                            contentDescription = "Restart"
                        )
                    }
                )
            }

            Spacer(modifier = Modifier.height(16.dp))

            if (players.isNullOrEmpty()) {
                Text(
                    text = "No Players Found.",
                    style = MaterialTheme.typography.titleMedium,
                    modifier = Modifier.padding(8.dp)
                )
            } else {
                val sortedPlayers = players.sortedByDescending { it.personalBest }
                PlayerLeaderboardList(players = sortedPlayers)

            }
        }
    }
}

@Preview
@Composable
fun LeaderboardScreenPreview() {
    AppTheme {
        val samplePlayers = listOf(
            Player(name = "Player 1", score = 100, personalBest = 200),
            Player(name = "Player 2", score = 80, personalBest = 150),
            Player(name = "Player 3", score = 120, personalBest = 250),
            Player(name = "Player 4", score = 90, personalBest = 180),
            Player(name = "Player 5", score = 110, personalBest = 220),
            Player(name = "Player 6", score = 70, personalBest = 160),
            Player(name = "Player 7", score = 95, personalBest = 195),
            Player(name = "Player 8", score = 105, personalBest = 215),
            Player(name = "Player 9", score = 85, personalBest = 175),
            Player(name = "Player 10", score = 130, personalBest = 280),
            Player(name = "Perna", score = 69, personalBest = 420),
        )

        LeaderboardPanel(
            onExit = {},
            players = samplePlayers
        )
    }
}