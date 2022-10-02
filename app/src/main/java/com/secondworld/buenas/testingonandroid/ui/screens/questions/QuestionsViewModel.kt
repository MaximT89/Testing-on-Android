package com.secondworld.buenas.testingonandroid.ui.screens.questions

import android.annotation.SuppressLint
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.map
import com.secondworld.buenas.testingonandroid.R
import com.secondworld.buenas.testingonandroid.core.bases.BaseViewModel
import com.secondworld.buenas.testingonandroid.core.common.ResourceProvider
import com.secondworld.buenas.testingonandroid.data.testing_screen.local.data_storage.models.Question
import com.secondworld.buenas.testingonandroid.domain.main_screen.model.SettingsTesting
import com.secondworld.buenas.testingonandroid.domain.testing_screen.repository.TestingRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class QuestionsViewModel @Inject constructor(
    private val resourceProvider: ResourceProvider,
    private val testingRepository: TestingRepository,
) : BaseViewModel() {
    override fun title(): String = resourceProvider.string(R.string.title_questions)

    private var _currentTestingSettings = MutableLiveData<SettingsTesting>()
    val currentTestingSettings: LiveData<SettingsTesting> = _currentTestingSettings

    private var _currentListQuestions = MutableLiveData<List<Question>>()
    val currentListQuestions: LiveData<List<Question>> = _currentListQuestions

    private var _currentQuestion = MutableLiveData<Question>()
    val currentQuestion: LiveData<Question> = _currentQuestion

    private var _currentCountQuestions = MutableLiveData<String>()
    val currentCountQuestions: LiveData<String> = _currentCountQuestions

    private var _currentNumberQuestion = MutableLiveData(1)
    val currentNumberQuestion: LiveData<Int> = _currentNumberQuestion

    private var _currentAnswers = MutableLiveData<List<AnswerUi>>()
    val currentAnswers: LiveData<List<AnswerUi>> = _currentAnswers

    fun saveCurrentTestingSettings(settings: SettingsTesting) {
        _currentTestingSettings.value = settings
    }

    fun fetchQuestionsFromRepo() {
        _currentListQuestions.value = testingRepository.getQuestions(
            _currentTestingSettings.value!!.questionsType,
            _currentTestingSettings.value!!.complexity
        )
    }

    fun updateQuestionNumberInfo() {
        _currentCountQuestions.value =
            "Вопрос ${_currentNumberQuestion.value} / ${_currentTestingSettings.value!!.complexity.countQuestions}"
    }

    fun nextQuestion() {

        val newQuestionNumber = _currentNumberQuestion.value!!.plus(1)

        if (newQuestionNumber <= _currentTestingSettings.value!!.complexity.countQuestions) {
            _currentNumberQuestion.value = newQuestionNumber

            updateCurrentQuestion()
        } else {
            // TODO: в таком случае нужно переводить на результаты теста
            // TODO: сохранить результаты в объект и переводить на страницу с результатами
        }
    }

    fun updateCurrentQuestion() {
        _currentQuestion.value =
            _currentListQuestions.value!![_currentNumberQuestion.value!!.minus(1)]
    }

    fun updateCurrentAnswers(answers: List<String>) {
        val answersUi: List<AnswerUi> = answers.map { answer -> AnswerUi(answer = answer) }
        _currentAnswers.value = answersUi
    }

    fun updateStatusAnswer(numberElement: Int, newStatus: CheckedStatus) {
        _currentAnswers.value = _currentAnswers.value!!.mapIndexed { index, answerUi ->
            if (index == numberElement) answerUi.copy(checkedStatus = newStatus)
            else answerUi.copy(checkedStatus = CheckedStatus.COMMON)
        }
    }
}