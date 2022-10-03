package com.secondworld.buenas.testingonandroid.domain.main_screen.model

import android.os.Parcelable
import com.secondworld.buenas.testingonandroid.data.testing_screen.local.data_storage.models.QuestionType
import com.secondworld.buenas.testingonandroid.data.testing_screen.local.data_storage.models.CountQuestionsType
import kotlinx.parcelize.Parcelize

@Parcelize
data class SettingsTesting(
    val questionsType: QuestionType = QuestionType.JUNIOR,
    val countQuestions: CountQuestionsType = CountQuestionsType.EASY
) : Parcelable