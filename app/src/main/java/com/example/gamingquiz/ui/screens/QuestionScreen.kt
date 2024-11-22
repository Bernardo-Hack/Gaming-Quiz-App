package com.example.gamingquiz.ui.screens

import android.content.Context
import android.media.MediaPlayer
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.gamingquiz.R
import com.example.gamingquiz.data.model.Player
import com.example.gamingquiz.data.viewModel.PlayerViewModel
import com.example.gamingquiz.data.viewModel.QuestionViewModel
import com.example.gamingquiz.ui.components.questions.IsCorrectCard
import com.example.gamingquiz.ui.components.questions.PlayerScorePanel
import com.example.gamingquiz.ui.components.questions.QuestionCard
import com.example.gamingquiz.ui.theme.AppTheme

@Composable
fun QuestionScreen(
    navController: NavHostController,
    questionViewModel: QuestionViewModel,
    playerViewModel: PlayerViewModel,
    onFinish: () -> Unit
) {
    val context = LocalContext.current

    var isLoading by remember { mutableStateOf(value = true) }
    var currentQuestionIndex by remember { mutableIntStateOf(value = 0) }
    var score by remember { mutableFloatStateOf(value = 0.0f) }
    var showPlayerScore by remember { mutableStateOf(value = false) }

    var isCorrect by remember { mutableStateOf<Boolean?>(value = null) }

    val timeLimit = 15
    val timeLeft by remember { mutableFloatStateOf(timeLimit.toFloat()) }
    val onTimeUp: () -> Unit = { isCorrect = false }

    val questions by questionViewModel.questions

    LaunchedEffect(Unit) {
        kotlinx.coroutines.delay(1000)
        isLoading = false
    }

    if (isLoading) {
        LoadingBox()
    } else {

        if (showPlayerScore) {
            handlePlayer(
                playerViewModel = playerViewModel,
                score = score.toInt(),
                navController = navController
            )
            PlayerScorePanel(
                score = score.toInt(),
                onFinish = {
                    onFinish()
                }
            )
        } else {

            if (currentQuestionIndex < questions.size && isCorrect == null) {
                questions[currentQuestionIndex].randomizeOptions()

                QuestionCard(
                    question = questions[currentQuestionIndex],
                    timeLimit = timeLimit,
                    onTimeUp = {
                        onTimeUp()
                    },
                    isCorrect = { correct ->
                        isCorrect = correct
                        if (correct) {
                            playSound(context, R.raw.correct_answer)
                            score += (timeLeft / timeLimit) * 1000
                        } else {
                            playSound(context, R.raw.wrong_answer)
                        }
                    },
                )
            }

        }
    }

    if (isCorrect != null) {
        IsCorrectCard(
            isCorrect = isCorrect!!,
            onClick = {
                isCorrect = null
                currentQuestionIndex += 1
                if (currentQuestionIndex >= 12) {
                    showPlayerScore = true
                }
            }
        )

        LaunchedEffect(key1 = isCorrect) {
            kotlinx.coroutines.delay(3000)
            isCorrect = null
            currentQuestionIndex += 1
            if (currentQuestionIndex >= 12) {
                showPlayerScore = true
            }
        }
    }
}

fun handlePlayer(
    playerViewModel: PlayerViewModel,
    score: Int,
    navController: NavHostController
) {
    val name = navController.previousBackStackEntry?.savedStateHandle?.get<String>("playerName")

    if (name != null) {
        val player = Player(
            name = name,
            score = score,
            personalBest = score
        )
        playerViewModel.insertOrUpdatePlayer(player)
    }
}

fun playSound(context: Context, sound: Int) {
    try {
        val mediaPlayer = MediaPlayer.create(context, sound)
        mediaPlayer?.start()

        mediaPlayer?.setOnCompletionListener {
            mediaPlayer.release()
        }
    } catch (e: Exception) {
        e.printStackTrace()
    }
}

@Composable
fun LoadingBox() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background),
        contentAlignment = Alignment.Center
    ) {
        CircularProgressIndicator(
            color = MaterialTheme.colorScheme.primary,
            strokeWidth = 5.dp
        )
    }
}

@Preview(showBackground = true)
@Composable
fun QuestionPreview() {
    AppTheme {
        //QuestionScreen(questionList = questions)
    }
}