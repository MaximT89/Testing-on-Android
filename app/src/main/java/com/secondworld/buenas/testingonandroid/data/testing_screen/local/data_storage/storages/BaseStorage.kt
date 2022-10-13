package com.secondworld.buenas.testingonandroid.data.testing_screen.local.data_storage.storages

import com.secondworld.buenas.testingonandroid.data.testing_screen.local.data_storage.models.Question
import com.secondworld.buenas.testingonandroid.data.testing_screen.local.data_storage.models.QuestionType

interface BaseStorage {

    val listQuestions: List<Question>

    fun getQuestions(countQuestions: Int, questionType: QuestionType): List<Question> {
        return listQuestions
            .filter { it.type == questionType }
            .shuffled()
            .slice(0..countQuestions)
    }
}