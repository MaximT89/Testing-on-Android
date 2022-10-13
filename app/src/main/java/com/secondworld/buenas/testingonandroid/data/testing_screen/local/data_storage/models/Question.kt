package com.secondworld.buenas.testingonandroid.data.testing_screen.local.data_storage.models

data class Question(
    val question : String,
    val answers : List<String>,
    val rightAnswer : Int,
    val type : QuestionType,
    val score : Int,
    val questionTheme : QuestionTheme
)