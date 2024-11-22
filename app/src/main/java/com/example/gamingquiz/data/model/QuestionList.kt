package com.example.gamingquiz.data.model

class QuestionList {

    fun getQuestions(): List<Question> {
        val questions = listOf(
            // REMEMBER - correctAnswer is the index of the correct answer in the options list

            Question(
                // Question 1
                question = "What item is created with this recipe?",
                options = listOf("Hoe", "Sword", "Axe", "Pickaxe"),
                correctAnswer = 0,
                imgPath = "question1",
            ),
            Question(
                // Question 2
                question = "What item/block is created with this recipe?",
                options = listOf("Fishing Rod", "Ender Chest", "End Crystal", "Enchantment Table"),
                correctAnswer = 2,
                imgPath = "question2",
            ),
            Question(
                // Question 3
                question = "What block is created with this recipe?",
                options = listOf("Soul Lantern", "Furnace", "Torch", "Lantern"),
                correctAnswer = 3,
                imgPath = "question3",
            ),
            Question(
                // Question 4
                question = "What is the name of this boss?",
                options = listOf("Old Duke", "Betsy", "Duke Fishron", "XM-05 Thanatos"),
                correctAnswer = 1,
                imgPath = "question4",
            ),
            Question(
                // Question 5
                question = "What is the name of this boss?",
                options = listOf("Skeletron Prime", "Medusa", "XF-09 Ares", "Mechdusa"),
                correctAnswer = 0,
                imgPath = "question5",
            ),
            Question(
                // Question 6
                question = "What is the name of this boss?",
                options = listOf("Slime Queen", "Slime King", "Slime God", "Slime Emperor"),
                correctAnswer = 0,
                imgPath = "question6",
            ),
            Question(
                // Question 7
                question = "What is the name of this survivor?",
                options = listOf("Acrid", "False Son", "Commando", "Bandit"),
                correctAnswer = 1,
                imgPath = "question7",
            ),
            Question(
                // Question 8
                question = "What is the name of this survivor?",
                options = listOf("REX", "Captain", "Heretic", "Chef"),
                correctAnswer = 2,
                imgPath = "question8",
            ),
            Question(
                // Question 9
                question = "What is the name of this survivor?",
                options = listOf("Seeker", "Samurai", "Bandit", "Mercenary"),
                correctAnswer = 3,
                imgPath = "question9",
            ),
            Question(
                // Question 10
                question = "What is the name of this Persona?",
                options = listOf("Satanael", "Orpheus", "Izanagi-Picaro", "Messiah-Picaro"),
                correctAnswer = 3,
                imgPath = "question10",
            ),
            Question(
                // Question 11
                question = "What is the name of this Persona?",
                options = listOf("Shiki-Ouji", "Arsène", "Izanagi-no-Okami", "Magatsu-Izanagi"),
                correctAnswer = 2,
                imgPath = "question11",
            ),
            Question(
                // Question 12
                question = "What is the name of this Persona?",
                options = listOf("Jack-o'-Lantern", "Jack Frost", "Dark Frost", "King Frost"),
                correctAnswer = 1,
                imgPath = "question12",
            )
        )

        return questions.shuffled()
    }
}