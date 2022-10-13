package com.secondworld.buenas.testingonandroid.ui.screens.main_screen

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.secondworld.buenas.testingonandroid.R
import com.secondworld.buenas.testingonandroid.core.bases.BaseViewModel
import com.secondworld.buenas.testingonandroid.core.common.ResourceProvider
import com.secondworld.buenas.testingonandroid.data.testing_screen.local.data_storage.models.QuestionType
import com.secondworld.buenas.testingonandroid.data.testing_screen.local.data_storage.models.CountQuestionsType
import com.secondworld.buenas.testingonandroid.domain.main_screen.interactor.MainInteractor
import com.secondworld.buenas.testingonandroid.domain.main_screen.model.SettingsTesting
import com.secondworld.buenas.testingonandroid.domain.main_screen.repository.MainRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val resourceProvider: ResourceProvider,
    interactor: MainInteractor,
    private val repository: MainRepository
) : BaseViewModel() {
    override fun title() = resourceProvider.string(R.string.title_main)

    private var _settingsTesting = MutableLiveData(SettingsTesting())

    init {
        updateSetting(
            complexity = interactor.loadCountQuestions(),
            questionType = interactor.loadQuestionsType()
        )
    }

    fun updateQuestionType(questionType: QuestionType) {
        repository.saveQuestionsType(questionType.name)
        _settingsTesting.value = SettingsTesting(
            questionsType = questionType,
            countQuestions = _settingsTesting.value!!.countQuestions
        )
    }

    fun updateComplexity(countQuestions: CountQuestionsType) {
        repository.saveCountQuestions(countQuestions.name)
        _settingsTesting.value = SettingsTesting(
            questionsType = _settingsTesting.value!!.questionsType,
            countQuestions = countQuestions
        )
    }

    fun updateSetting(
        complexity: CountQuestionsType,
        questionType: QuestionType,
    ) {
        _settingsTesting.value = SettingsTesting(
            questionsType = questionType,
            countQuestions = complexity
        )
    }

    fun getSettingsTesting() = _settingsTesting.value
}