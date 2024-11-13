package com.example.gamingquiz

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
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
import com.example.gamingquiz.data.viewModel.QuizViewModelFactory
import com.example.gamingquiz.ui.theme.AppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val dao = QuizDatabase.getDatabase(application).questionDao()
        val repository = QuestionRepository(dao)
        val factory = QuizViewModelFactory(repository)
        setContent {
            MyApp()
        }
    }
}

@Composable
fun MyApp() {
    AppTheme {
        val navController = rememberNavController()
        SetupNavGraph(navController = navController)
    }
}

@Composable
fun SetupNavGraph(navController: NavHostController) {
    val context = LocalContext.current
    val questions = QuestionList().getQuestions()
    val playerDAO = QuizDatabase.getDatabase(context).playerDao()
    val playerRepository = PlayerRepository(playerDAO)
    val playerViewModel = PlayerViewModel(playerRepository)

    NavHost(navController = navController, startDestination = "main") {
        composable("main") {

        }
        composable("quizScreen") {

        }
        composable("leaderboard") {

        }
    }
}
