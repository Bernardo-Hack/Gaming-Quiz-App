package com.example.gamingquiz.data.model

class QuestionList {

    private val questions = listOf(
        Question(
            question = "Qual o nome do personagem principal de The Legend of Zelda?",
            options = listOf("Link", "Zelda", "Hero", "Mario"),
            correctAnswer = 1,
            imgPath = 0,
        ),
        Question(
            question = "Qual desses personagens não é um personagem jogável em Super Smash Bros?",
            options = listOf("", "", "", ""),
            correctAnswer = 0,
            imgPath = 0,
        ),
        Question(
            question = "Qual item é o resultado dessa receita?",
            options = listOf("", "", "", ""),
            correctAnswer = 0,
            imgPath = 0,
        ),
        Question(
            question = "Qual item é o resultado dessa receita?",
            options = listOf("", "", "", ""),
            correctAnswer = 0,
            imgPath = 0,
        ),
        Question(
            question = "Qual item é o resultado dessa receita?",
            options = listOf("", "", "", ""),
            correctAnswer = 0,
            imgPath = 0,
        ),
        Question(
            question = "",
            options = listOf("", "", "", ""),
            correctAnswer = 0,
            imgPath = 0,
        ),
        Question(
            question = "",
            options = listOf("", "", "", ""),
            correctAnswer = 0,
            imgPath = 0,
        ),
        Question(
            question = "",
            options = listOf("", "", "", ""),
            correctAnswer = 0,
            imgPath = 0,
        ),
        Question(
            question = "",
            options = listOf("", "", "", ""),
            correctAnswer = 0,
            imgPath = 0,
        ),
        Question(
            question = "",
            options = listOf("", "", "", ""),
            correctAnswer = 0,
            imgPath = 0,
        )
    )
    fun getQuestions(): List<Question> {
        return questions.shuffled()
    }
}