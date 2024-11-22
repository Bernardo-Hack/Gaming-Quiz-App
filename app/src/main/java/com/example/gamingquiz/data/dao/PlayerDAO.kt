package com.example.gamingquiz.data.dao
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.gamingquiz.data.model.Player

@Dao
interface PlayerDAO {

    @Insert
    suspend fun insertPlayer(player: Player)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun listPlayers(players: List<Player>)

    @Query("SELECT * FROM player ORDER BY score DESC")
    suspend fun getAllPlayers(): List<Player>

    @Query("DELETE FROM player WHERE name = :name")
    suspend fun deletePlayer(name: String)

    @Update
    suspend fun updatePlayer(player: Player)

    @Query("SELECT * FROM player WHERE name = :name")
    suspend fun getPlayerByNickname(name: String): Player?
}