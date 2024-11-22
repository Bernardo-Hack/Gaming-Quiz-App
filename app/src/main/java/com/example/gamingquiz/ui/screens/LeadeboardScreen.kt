package com.example.gamingquiz.ui.screens

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import com.example.gamingquiz.data.viewModel.PlayerViewModel
import com.example.gamingquiz.ui.components.leaderboard.LeaderboardPanel

@Composable
fun LeaderboardScreen(
    onExit: () -> Unit = {},
    playerViewModel: PlayerViewModel
) {
    val players by playerViewModel.players.collectAsState(initial = emptyList())

    LeaderboardPanel(
        onExit = onExit,
        players = players
    )
}
