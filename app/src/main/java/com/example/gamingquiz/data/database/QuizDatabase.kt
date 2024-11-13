package com.example.gamingquiz.data.database
import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.gamingquiz.data.dao.PlayerDAO
import com.example.gamingquiz.data.dao.QuestionDAO
import com.example.gamingquiz.data.model.Converters
import com.example.gamingquiz.data.model.Player
import com.example.gamingquiz.data.model.Question

@Database(entities = [Player::class, Question::class], version = 2, exportSchema = false)
@TypeConverters(Converters::class) // Use your own Converters class
abstract class QuizDatabase : RoomDatabase() {

    abstract fun playerDao(): PlayerDAO // Ensure you have the correct DAOs
    abstract fun questionDao(): QuestionDAO

    companion object {
        @Volatile
        private var INSTANCE: QuizDatabase? = null

        fun getDatabase(context: Context): QuizDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    QuizDatabase::class.java,
                    "quiz_database"
                )
                    .fallbackToDestructiveMigration()
                    .build()
                INSTANCE = instance
                instance
            }
        }
    }
}