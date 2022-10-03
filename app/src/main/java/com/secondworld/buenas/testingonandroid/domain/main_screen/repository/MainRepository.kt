package com.secondworld.buenas.testingonandroid.domain.main_screen.repository

interface MainRepository {

    fun saveQuestionsType(value: String)
    fun loadQuestionsType(): String

    fun saveCountQuestions(value: String)
    fun loadCountQuestions(): String
}