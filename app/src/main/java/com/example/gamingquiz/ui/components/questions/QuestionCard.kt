package com.example.gamingquiz.ui.components.questions

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.gamingquiz.R
import com.example.gamingquiz.data.model.Question
import com.example.gamingquiz.ui.theme.AppTheme
import com.example.gamingquiz.ui.theme.QuestionBackgroundGradient

@Composable
fun QuestionCard(
    question: Question,
    isCorrect: ((Boolean) -> Unit)?,
    timeLimit: Int,
    onTimeUp: () -> Unit,
    ) {

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(brush = QuestionBackgroundGradient)
            .padding(vertical = 20.dp, horizontal = 15.dp)
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {

            QuestionClock(
                timeLimit = timeLimit,
                onTimeUp = onTimeUp,
            )

            Spacer(modifier = Modifier.height(16.dp))

            QuestionPanel(
                question = question.question,
                imgUrl = question.imgPath
            )

            Spacer(modifier = Modifier.height(16.dp))

            AnswerPanel(
                options = question.options,
                onAnswerSelected = { selectedAnswer ->
                    isCorrect?.invoke(isCorrectCheck(question, selectedAnswer))
                }
            )
        }
    }
}

fun isCorrectCheck(question: Question, selectedAnswer: Int): Boolean {
    return question.correctAnswer == selectedAnswer
}

@Preview(device = "spec:width=411dp,height=891dp")
@Composable
fun QuestionCardPreview() {
    val q = Question(
        // Question 7
        question = "What is the name of this survivor?",
        options = listOf("Acrid", "False Son", "Commando", "Bandit"),
        correctAnswer = 1,
        imgPath = "question1",
    )

    AppTheme {
        QuestionCard(
            question = q,
            isCorrect = null,
            timeLimit = 15,
            onTimeUp = {}
        )
    }
}