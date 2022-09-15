package com.secondworld.buenas.testingonandroid.data.local.data_storage

data class Question(
    val id : Int,
    val question : String,
    val answers : List<String>,
    val rightAnswer : Int,
    val type : TypeQuestion,
    val score : Int
)

enum class TypeQuestion(val score : Int){
    SIMPLE(1),
    MEDIUM(2),
    STRONG(3)
}