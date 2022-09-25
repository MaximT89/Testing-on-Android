package com.secondworld.buenas.testingonandroid.ui.screens.questions

import androidx.lifecycle.ViewModel
import com.secondworld.buenas.testingonandroid.R
import com.secondworld.buenas.testingonandroid.core.bases.BaseViewModel
import com.secondworld.buenas.testingonandroid.core.common.ResourceProvider
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class QuestionsViewModel @Inject constructor(private val resourceProvider: ResourceProvider) : BaseViewModel() {
    override fun title(): String  = resourceProvider.string(R.string.title_questions)
}