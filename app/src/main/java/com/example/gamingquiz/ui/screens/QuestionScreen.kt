package com.example.gamingquiz.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.gamingquiz.R
import com.example.gamingquiz.ui.components.AnswerButton
import com.example.gamingquiz.ui.components.QuestionCard

@Composable
fun QuestionBoard(btnNames: Array<String>) {
    LaunchedEffect(Unit) {
        // Load questions and create user profile
    }

    Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->

        Column(
            modifier = Modifier.padding(innerPadding)
        ) {

            QuestionCard(
                modifier = Modifier.padding(innerPadding),
                questionText = "What company does this logo belong to?",
                imageUrl = R.drawable.john_doe
            )

            AnswerButton(
                btnText = btnNames,
                modifier = Modifier.padding(innerPadding)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun QuestionPreview() {
    val btnNames = arrayOf("Answer 1", "Answer 2", "Answer 3", "Answer 4")
    QuestionBoard(btnNames)
}