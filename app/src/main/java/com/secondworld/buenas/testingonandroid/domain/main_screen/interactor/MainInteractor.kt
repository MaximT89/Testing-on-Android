package com.secondworld.buenas.testingonandroid.domain.main_screen.interactor

import com.secondworld.buenas.testingonandroid.data.testing_screen.local.data_storage.models.CountQuestionsType
import com.secondworld.buenas.testingonandroid.data.testing_screen.local.data_storage.models.QuestionType
import com.secondworld.buenas.testingonandroid.domain.main_screen.repository.MainRepository
import javax.inject.Inject

class MainInteractor @Inject constructor(private val repository: MainRepository) {

    fun loadQuestionsType() = when (repository.loadQuestionsType()) {
        QuestionType.JUNIOR.name -> QuestionType.JUNIOR
        QuestionType.MIDDLE.name -> QuestionType.MIDDLE
        QuestionType.SENIOR.name -> QuestionType.SENIOR
        else -> QuestionType.JUNIOR
    }

    fun loadCountQuestions() = when(repository.loadCountQuestions()){
        CountQuestionsType.TESTING.name -> CountQuestionsType.TESTING
        CountQuestionsType.EASY.name -> CountQuestionsType.EASY
        CountQuestionsType.MEDIUM.name -> CountQuestionsType.MEDIUM
        CountQuestionsType.HARD.name -> CountQuestionsType.HARD
        else -> CountQuestionsType.EASY
    }
}