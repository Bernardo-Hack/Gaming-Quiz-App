package com.example.gamingquiz.data.viewModel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.gamingquiz.data.model.Player
import com.example.gamingquiz.data.repository.PlayerRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class PlayerViewModel(private val repository: PlayerRepository) : ViewModel() {

    private val _players = MutableStateFlow<List<Player>>(emptyList())
    val players: StateFlow<List<Player>> = _players

    init {
        loadPlayers()
    }

    private fun loadPlayers() {
        viewModelScope.launch { _players.value = repository.getAllPlayers() }
    }

    fun insertOrUpdatePlayer(player: Player) = viewModelScope.launch {
        val existingPlayer = repository.getPlayerByNickname(player.name)

        if (existingPlayer != null) {
            val updatedHigherScore = if (player.score > existingPlayer.personalBest) {
                player.score
            } else {
                existingPlayer.personalBest
            }

            val updatedPlayer = existingPlayer.copy(
                score = player.score,
                personalBest = updatedHigherScore
            )

            repository.updatePlayer(updatedPlayer)

        } else {
            repository.insertPlayer(player)
        }
        loadPlayers()
    }

    fun deletePlayer(name: String) = viewModelScope.launch {
        repository.deletePlayer(name)
        loadPlayers()
    }
}