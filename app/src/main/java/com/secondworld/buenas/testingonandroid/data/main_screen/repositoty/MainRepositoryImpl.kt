package com.secondworld.buenas.testingonandroid.data.main_screen.repositoty

import com.secondworld.buenas.testingonandroid.data.main_screen.local.MainPrefs
import com.secondworld.buenas.testingonandroid.domain.main_screen.repository.MainRepository
import javax.inject.Inject

class MainRepositoryImpl @Inject constructor(private val prefs: MainPrefs) : MainRepository {

    override fun saveQuestionsType(value: String) {
        prefs.saveQuestionsType(value)
    }

    override fun loadQuestionsType() : String {
        return prefs.loadQuestionsType()!!
    }

    override fun saveCountQuestions(value: String) {
        prefs.saveCountQuestions(value)
    }

    override fun loadCountQuestions(): String {
        return prefs.loadCountQuestions()!!
    }
}