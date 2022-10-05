package com.secondworld.buenas.testingonandroid.ui.screens.questions_screen.modelUi

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class ResultCurrentTesting(
    var countQuestions: Int = 0,
    var rightAnswers : Int = 0
) : Parcelable