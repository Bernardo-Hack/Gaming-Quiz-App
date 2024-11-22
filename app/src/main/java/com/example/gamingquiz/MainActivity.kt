package com.example.gamingquiz

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.gamingquiz.data.database.QuizDatabase
import com.example.gamingquiz.data.model.QuestionList
import com.example.gamingquiz.data.repository.PlayerRepository
import com.example.gamingquiz.data.repository.QuestionRepository
import com.example.gamingquiz.data.viewModel.PlayerViewModel
import com.example.gamingquiz.data.viewModel.PlayerViewModelFactory
import com.example.gamingquiz.data.viewModel.QuestionViewModel
import com.example.gamingquiz.data.viewModel.QuestionViewModelFactory
import com.example.gamingquiz.ui.screens.LeaderboardScreen
import com.example.gamingquiz.ui.screens.LoginScreen
import com.example.gamingquiz.ui.screens.QuestionScreen
import com.example.gamingquiz.ui.theme.AppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyApp()
        }
    }
}

@Composable
fun MyApp() {
    AppTheme {
        val navController = rememberNavController()
        SetupRoutes(navController = navController)
    }
}

@Composable
fun SetupRoutes(navController: NavHostController) {
    val context = LocalContext.current
    val questions = QuestionList().getQuestions()

    val questionsDAO = QuizDatabase.getDatabase(context).questionDao()
    val repository = QuestionRepository(questionsDAO)
    val questionsViewModel = QuestionViewModelFactory(repository).create(QuestionViewModel::class.java)

    val playerDAO = QuizDatabase.getDatabase(context).playerDao()
    val playerRepository = PlayerRepository(playerDAO)
    val playerViewModel = PlayerViewModelFactory(playerRepository).create(PlayerViewModel::class.java)

    NavHost(navController = navController, startDestination = "mainScreen") {
        composable(route = "mainScreen") {
            LoginScreen(
                onContinueClicked = { playerName ->
                    navController.currentBackStackEntry?.savedStateHandle?.set("playerName", playerName)
                    navController.navigate("questionScreen")
                },
                onLeaderboardClicked = {
                    navController.navigate("leaderboardScreen")
                }
            )
        }
        composable(route = "questionScreen") {
            questionsViewModel.insertQuestions(questions)
            QuestionScreen(
                navController = navController,
                questionViewModel = questionsViewModel,
                playerViewModel = playerViewModel,
                onFinish = {
                    navController.navigate("leaderboardScreen")
                },
            )

        }
        composable(route = "leaderboardScreen") {
            LeaderboardScreen(
                playerViewModel = playerViewModel,
                onExit = {
                    navController.navigate("mainScreen")
                },
            )
        }
    }
}
