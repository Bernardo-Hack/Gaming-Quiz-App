package com.example.gamingquiz.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "player")
data class Player(

    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val name: String,
    val score: Int,
    val personalBest: Int
)
