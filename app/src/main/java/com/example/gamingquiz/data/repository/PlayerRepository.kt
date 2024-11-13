package com.example.gamingquiz.data.repository
import com.example.gamingquiz.data.dao.PlayerDAO
import com.example.gamingquiz.data.model.Player

class PlayerRepository(private val playerDao: PlayerDAO) {

    suspend fun insertPlayer(player: Player) {
        playerDao.insertPlayer(player)
    }

    suspend fun getAllPlayers(): List<Player> {
        return playerDao.getAllPlayers()
    }

    suspend fun updatePlayer(player: Player) {
        playerDao.updatePlayer(player)
    }

    suspend fun deleteAllPlayers() {
        playerDao.deleteAllPlayers()
    }

    suspend fun getPlayerByNickname(name: String): Player? {
        return playerDao.getPlayerByNickname(name)
    }
}