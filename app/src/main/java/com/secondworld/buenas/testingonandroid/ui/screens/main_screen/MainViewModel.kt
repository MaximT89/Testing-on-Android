package com.secondworld.buenas.testingonandroid.ui.screens.main_screen

import androidx.lifecycle.MutableLiveData
import com.secondworld.buenas.testingonandroid.R
import com.secondworld.buenas.testingonandroid.core.bases.BaseViewModel
import com.secondworld.buenas.testingonandroid.core.common.ResourceProvider
import com.secondworld.buenas.testingonandroid.data.testing_screen.local.data_storage.models.QuestionType
import com.secondworld.buenas.testingonandroid.data.testing_screen.local.data_storage.models.TestingComplexity
import com.secondworld.buenas.testingonandroid.domain.main_screen.model.SettingsTesting
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val resourceProvider: ResourceProvider): BaseViewModel() {
    override fun title() = resourceProvider.string(R.string.title_main)

    private var _settingsTesting = MutableLiveData(SettingsTesting())

    fun updateQuestionType(questionType : QuestionType) {
        _settingsTesting.value = SettingsTesting(
            questionsType = questionType,
            countQuestions = _settingsTesting.value!!.countQuestions
        )
    }

    fun updateComplexity(complexity: TestingComplexity) {
        _settingsTesting.value = SettingsTesting(
            questionsType = _settingsTesting.value!!.questionsType,
            countQuestions = complexity.countQuestions)
    }

    fun getSettingsTesting() = _settingsTesting.value
}