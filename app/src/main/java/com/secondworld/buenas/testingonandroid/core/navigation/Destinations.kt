package com.secondworld.buenas.testingonandroid.core.navigation

import com.secondworld.buenas.testingonandroid.R


enum class Destinations(val id : Int) {
    MAIN_TO_QUESTIONS(R.id.action_mainFragment_to_questionsFragment),
    QUESTIONS_TO_RESULT(R.id.action_questionsFragment_to_resultFragment),
    RESULT_TO_MAIN(R.id.action_resultFragment_to_mainFragment)

}