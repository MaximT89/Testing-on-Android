package com.secondworld.buenas.testingonandroid.data.main_screen.local

import com.secondworld.buenas.testingonandroid.core.bases.BaseSharedPreferences
import com.secondworld.buenas.testingonandroid.core.extension.editMe
import com.secondworld.buenas.testingonandroid.core.extension.put
import com.secondworld.buenas.testingonandroid.data.testing_screen.local.data_storage.models.QuestionType
import com.secondworld.buenas.testingonandroid.data.testing_screen.local.data_storage.models.CountQuestionsType
import javax.inject.Inject

class MainPrefs @Inject constructor(private val basePrefs : BaseSharedPreferences) {

    companion object{
        const val QUESTIONS_TYPE = "questions_type"
        const val COUNT_QUESTIONS = "count_questions"
    }

    fun saveQuestionsType(value : String) = basePrefs.defaultPref().editMe { it.put(QUESTIONS_TYPE to value) }
    fun loadQuestionsType() = basePrefs.defaultPref().getString(QUESTIONS_TYPE, QuestionType.JUNIOR.name)

    fun saveCountQuestions(value : String) = basePrefs.defaultPref().editMe { it.put(COUNT_QUESTIONS to value) }
    fun loadCountQuestions() = basePrefs.defaultPref().getString(COUNT_QUESTIONS, CountQuestionsType.EASY.name)
}