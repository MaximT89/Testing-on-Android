package com.secondworld.buenas.testingonandroid.data.repository

import com.secondworld.buenas.testingonandroid.data.local.data_storage.QuestionType
import com.secondworld.buenas.testingonandroid.data.local.data_storage.QuestionsStorage
import com.secondworld.buenas.testingonandroid.data.local.data_storage.TestingComplexity
import com.secondworld.buenas.testingonandroid.domain.repository.Repository
import javax.inject.Inject

class RepositoryImpl @Inject constructor(private val storage: QuestionsStorage) : Repository {

    override fun getCountQuestions(complexity: TestingComplexity) = complexity.countQuestions

    override fun getQuestionScoreCount(type: QuestionType) = type.score

    override fun getQuestions(type: QuestionType, complexity: TestingComplexity) =
        storage.getQuestions()
            .filter { question -> question.type == type }
            .shuffled()
            .slice(0 until complexity.countQuestions)

}