package com.secondworld.buenas.testingonandroid.ui.screens.questions_screen

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.secondworld.buenas.testingonandroid.R
import com.secondworld.buenas.testingonandroid.core.bases.BaseViewModel
import com.secondworld.buenas.testingonandroid.core.common.ResourceProvider
import com.secondworld.buenas.testingonandroid.core.common.Timer
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

    private var _choiceUser = MutableLiveData<Int>()

    private var _statusChoiceUser = MutableLiveData<Boolean>()
    val statusChoiceUser: LiveData<Boolean> = _statusChoiceUser

    private var _currentTimerSecond = MutableLiveData<Long>()
    val currentTimerSecond: LiveData<Long> = _currentTimerSecond

    private var _questionsState = MutableLiveData<QuestionsState>()
    val questionsState: LiveData<QuestionsState> = _questionsState

    // TODO: данную переменную нужно будет модифицировать когда вопросы будут разбиты по темам
    private var _currentRightAnswers = MutableLiveData(0)
    val currentRightAnswers: LiveData<Int> = _currentRightAnswers

    var timer: Timer? = Timer()

    fun saveCurrentTestingSettings(settings: SettingsTesting) {
        _currentTestingSettings.value = settings
    }

    fun fetchQuestionsFromRepo() {
        _currentListQuestions.value = testingRepository.getQuestions(
            _currentTestingSettings.value!!.questionsType,
            _currentTestingSettings.value!!.countQuestions
        )
    }

    fun updateQuestionNumberInfo() {
        _currentCountQuestions.value =
            "Вопрос ${_currentNumberQuestion.value} / ${_currentTestingSettings.value!!.countQuestions.countQuestions}"
    }

    fun nextQuestion() {

        val newQuestionNumber = _currentNumberQuestion.value!!.plus(1)

        if (newQuestionNumber <= _currentTestingSettings.value!!.countQuestions.countQuestions) {
            _currentNumberQuestion.value = newQuestionNumber
            _questionsState.value = QuestionsState.NewQuestion

            updateCurrentQuestion()
            startTimer()
        } else {
            _questionsState.value = QuestionsState.FinishTesting(_currentRightAnswers.value!!)
        }
    }

    fun startTimer() {
        if (timer != null) {
            timer?.stopTimer()
            timer = null
            timer = Timer(
                fullTime = _currentTestingSettings.value!!.questionsType.timeForAnswer.toLong()
            )
            timer?.startTimer(
                onTick = {
                    _currentTimerSecond.value = it
                },
                onFinish = {
                    nextQuestion()

                })
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

    fun updateStatusAnswer(newStatus: CheckedStatus) {
        _currentAnswers.value = _currentAnswers.value!!.mapIndexed { index, answerUi ->
            if (index == _choiceUser.value) answerUi.copy(checkedStatus = newStatus)
            else answerUi.copy(checkedStatus = CheckedStatus.COMMON)
        }
    }

    fun currentChoiceUser(numberElement: Int) {
        _choiceUser.value = numberElement
    }

    fun checkChoiceUser() {
        _statusChoiceUser.value =
            _currentQuestion.value!!.rightAnswer == _choiceUser.value!!.plus(1)
    }

    fun incCountRightAnswers() {
        _currentRightAnswers.value = _currentRightAnswers.value!!.plus(1)
    }
}

sealed class QuestionsState {
    object NewQuestion : QuestionsState()
    class FinishTesting(val countRightAnswers: Int) : QuestionsState()
}