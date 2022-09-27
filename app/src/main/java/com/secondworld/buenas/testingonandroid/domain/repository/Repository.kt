package com.secondworld.buenas.testingonandroid.domain.repository

import com.secondworld.buenas.testingonandroid.data.local.data_storage.Question
import com.secondworld.buenas.testingonandroid.data.local.data_storage.QuestionType
import com.secondworld.buenas.testingonandroid.data.local.data_storage.TestingComplexity

interface Repository {

    fun getCountQuestions(complexity : TestingComplexity) : Int

    fun getQuestionScoreCount(type : QuestionType) : Int

    fun getQuestions(type: QuestionType, complexity: TestingComplexity) : List<Question>
}