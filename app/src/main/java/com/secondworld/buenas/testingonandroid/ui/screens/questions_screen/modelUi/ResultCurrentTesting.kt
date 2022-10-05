package com.secondworld.buenas.testingonandroid.ui.screens.questions_screen.modelUi

import android.os.Parcelable
import com.secondworld.buenas.testingonandroid.data.testing_screen.local.data_storage.models.QuestionType
import kotlinx.parcelize.Parcelize

@Parcelize
data class ResultCurrentTesting(
    var countQuestions: Int = 0,
    var rightAnswers : Int = 0,
    var questionsType : QuestionType = QuestionType.JUNIOR
) : Parcelable