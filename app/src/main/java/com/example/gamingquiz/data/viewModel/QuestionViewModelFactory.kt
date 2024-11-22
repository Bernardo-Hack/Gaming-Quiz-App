package com.example.gamingquiz.data.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.gamingquiz.data.repository.QuestionRepository

class QuestionViewModelFactory(private val repository: QuestionRepository): ViewModelProvider.NewInstanceFactory() {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(QuestionViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return QuestionViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}