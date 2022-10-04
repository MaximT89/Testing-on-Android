package com.secondworld.buenas.testingonandroid.ui.screens.questions_screen

data class AnswerUi(
    val answer: String,
    val checkedStatus : CheckedStatus = CheckedStatus.COMMON
)

enum class CheckedStatus {
    COMMON,
    SELECTED,
    RIGHT_ANSWER,
    WRONG_ANSWER
}