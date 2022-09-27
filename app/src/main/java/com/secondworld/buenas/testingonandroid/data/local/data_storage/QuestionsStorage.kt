package com.secondworld.buenas.testingonandroid.data.local.data_storage

import com.secondworld.buenas.testingonandroid.data.local.data_storage.QuestionType.*
import javax.inject.Inject

class QuestionsStorage @Inject constructor() {

    fun getQuestions() = listOf(
        Question(1, "Класс в котлин, аналог класса Object" , listOf("Any", "Unit", "Nothing", "Open"), 1, JUNIOR, JUNIOR.score)
    )

}