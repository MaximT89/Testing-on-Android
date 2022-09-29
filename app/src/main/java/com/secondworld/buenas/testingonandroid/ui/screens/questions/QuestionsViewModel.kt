package com.secondworld.buenas.testingonandroid.ui.screens.questions

import androidx.lifecycle.MutableLiveData
import com.secondworld.buenas.testingonandroid.R
import com.secondworld.buenas.testingonandroid.core.bases.BaseViewModel
import com.secondworld.buenas.testingonandroid.core.common.ResourceProvider
import com.secondworld.buenas.testingonandroid.core.extension.log
import com.secondworld.buenas.testingonandroid.domain.main_screen.model.SettingsTesting
import com.secondworld.buenas.testingonandroid.domain.testing_screen.repository.TestingRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class QuestionsViewModel @Inject constructor(
    private val resourceProvider: ResourceProvider,
    private val testingRepository: TestingRepository
) : BaseViewModel() {
    override fun title(): String = resourceProvider.string(R.string.title_questions)

    private var _currentTestingSettings = MutableLiveData<SettingsTesting>()

    fun saveCurrentTestingSettings(settings: SettingsTesting) {
        _currentTestingSettings.value = settings
        log(_currentTestingSettings.value.toString())
    }
}