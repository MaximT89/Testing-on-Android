package com.secondworld.buenas.testingonandroid.data.local.data_storage

data class Question(
    val id : Int,
    val question : String,
    val answers : List<String>,
    val rightAnswer : Int,
    val type : QuestionType,
    val score : Int
)