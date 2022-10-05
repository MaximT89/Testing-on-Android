package com.secondworld.buenas.testingonandroid.domain.result_screen.interactors

import com.secondworld.buenas.testingonandroid.data.testing_screen.local.data_storage.models.QuestionType
import com.secondworld.buenas.testingonandroid.domain.result_screen.models.ResultTesting
import com.secondworld.buenas.testingonandroid.ui.screens.questions_screen.modelUi.ResultCurrentTesting
import javax.inject.Inject

class ResultInteractor @Inject constructor() {

    fun getResultColor(totalQuestions: Int, countRightAnswers: Int) =
        when (countRightAnswers.toDouble() / (totalQuestions.toDouble() / 100)) {
            in 0.00..29.99 -> ResultTesting.BAD.colorId
            in 30.00..69.99 -> ResultTesting.GOOD.colorId
            in 70.00..100.00 -> ResultTesting.BEST.colorId
            else -> ResultTesting.BEST.colorId
        }

    fun getConclusionText(result: ResultCurrentTesting) =
        when (result.rightAnswers.toDouble() / (result.countQuestions.toDouble() / 100)) {
            in 0.00..29.99 -> BadTestingResult(result)
            in 30.00..69.99 -> GoodTestingResult(result)
            in 70.00..100.00 -> BestTestingResult(result)
            else -> "Результат неизвестен"
        }

    private fun BestTestingResult(result: ResultCurrentTesting) = when (result.questionsType) {
        QuestionType.JUNIOR -> ""
        QuestionType.MIDDLE -> ""
        QuestionType.SENIOR -> ""
    }

    private fun GoodTestingResult(result: ResultCurrentTesting) = when (result.questionsType) {
        QuestionType.JUNIOR -> ""
        QuestionType.MIDDLE -> ""
        QuestionType.SENIOR -> ""
    }

    private fun BadTestingResult(result: ResultCurrentTesting) = when (result.questionsType) {
        QuestionType.JUNIOR -> ""
        QuestionType.MIDDLE -> ""
        QuestionType.SENIOR -> ""
    }
}