package com.example.gamingquiz.data.viewModel

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.gamingquiz.data.model.Question
import com.example.gamingquiz.data.repository.QuestionRepository
import kotlinx.coroutines.launch

class QuestionViewModel(private val repository: QuestionRepository): ViewModel() {

    private val _questions = mutableStateOf<List<Question>>(emptyList())
    val questions: State<List<Question>> = _questions

    private fun loadQuestions() {
        viewModelScope.launch {
            _questions.value = repository.getAllQuestions()
        }
    }

    fun insertQuestions(question: List<Question>) {
        viewModelScope.launch {
            repository.insertAllQuestion(question)
            loadQuestions()
        }
    }
}