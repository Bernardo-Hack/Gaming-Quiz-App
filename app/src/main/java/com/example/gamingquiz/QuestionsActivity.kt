package com.example.gamingquiz

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.gamingquiz.ui.QuestionBoard

class QuestionsActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val btnNames = arrayOf("Answer 1", "Answer 2", "Answer 3", "Answer 4")
            QuestionBoard(btnNames = btnNames)
        }
    }
}
