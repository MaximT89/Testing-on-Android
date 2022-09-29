package com.secondworld.buenas.testingonandroid.data.testing_screen.repository

import com.secondworld.buenas.testingonandroid.data.testing_screen.local.data_storage.models.QuestionType
import com.secondworld.buenas.testingonandroid.data.testing_screen.local.data_storage.QuestionsStorage
import com.secondworld.buenas.testingonandroid.data.testing_screen.local.data_storage.models.TestingComplexity
import com.secondworld.buenas.testingonandroid.domain.testing_screen.repository.TestingRepository
import javax.inject.Inject

class TestingRepositoryImpl @Inject constructor(private val storage: QuestionsStorage) : TestingRepository {

    override fun getCountQuestions(complexity: TestingComplexity) = complexity.countQuestions

    override fun getQuestionScoreCount(type: QuestionType) = type.score

    override fun getQuestions(type: QuestionType, complexity: TestingComplexity) =
        storage.getQuestions()
            .filter { question -> question.type == type }
            .shuffled()
            .slice(0 until complexity.countQuestions)

}