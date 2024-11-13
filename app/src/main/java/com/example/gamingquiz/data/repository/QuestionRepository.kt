package com.example.gamingquiz.data.repository
import com.example.gamingquiz.data.dao.QuestionDAO
import com.example.gamingquiz.data.model.Question

class QuestionRepository(private val questionDAO: QuestionDAO) {

    suspend fun getAllQuestions():List<Question>{
        return questionDAO.getAllQuestions()
    }

    suspend fun insertAllQuestion(question: List<Question>){
        questionDAO.insertAll(question)
    }

}