package com.example.gamingquiz.data.model
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "question")
data class Question(

    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val question: String,
    var options: List<String>,
    var correctAnswer: Int,
    val imgPath: Int
) {
    fun randomizeOptions() {
        val newList = this.options.toMutableList()
        val newCorrectAnswer = newList.indexOf(options[correctAnswer])

        this.options = newList
        this.correctAnswer = newCorrectAnswer
    }
}
