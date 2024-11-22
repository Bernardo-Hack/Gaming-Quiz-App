package com.example.gamingquiz.ui.components.leaderboard

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.gamingquiz.data.model.Player
import com.example.gamingquiz.ui.theme.AppTheme

@Composable
fun PlayerLeaderboardList(players: List<Player> = emptyList()) {
    val sortedPlayers = players.sortedByDescending { it.personalBest }

    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(8.dp),
        userScrollEnabled = true
    ) {
        itemsIndexed(items = sortedPlayers) { index, player ->
            PlayerLeaderboardItem(player = player, rank = index + 1)
        }
    }
}

@Preview
@Composable
fun PlayerLeaderboardPreview() {
    val playerList = listOf(
        Player(0, "Player 1", 100, 150),
        Player(1, "Player 2", 200, 250),
        Player(2, "Player 3", 300, 350),
        Player(3, "Player 4", 400, 450),
        Player(4, "Player 5", 500, 550),
        Player(5, "Player 6", 600, 660),
        Player(6, "Player 7", 700, 750),
        Player(7, "Player 8", 800, 850),
        Player(8, "Player 9", 900, 950),
        Player(9, "Player 10", 1000, 1100),
    )

    AppTheme {
        PlayerLeaderboardList(players = playerList)
    }
}