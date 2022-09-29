package com.secondworld.buenas.testingonandroid.domain.testing_screen.repository

import com.secondworld.buenas.testingonandroid.data.testing_screen.local.data_storage.models.Question
import com.secondworld.buenas.testingonandroid.data.testing_screen.local.data_storage.models.QuestionType
import com.secondworld.buenas.testingonandroid.data.testing_screen.local.data_storage.models.TestingComplexity

interface TestingRepository {

    fun getCountQuestions(complexity : TestingComplexity) : Int

    fun getQuestionScoreCount(type : QuestionType) : Int

    fun getQuestions(type: QuestionType, complexity: TestingComplexity) : List<Question>
}