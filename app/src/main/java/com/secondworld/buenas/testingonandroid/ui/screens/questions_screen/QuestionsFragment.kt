package com.secondworld.buenas.testingonandroid.ui.screens.questions_screen

import androidx.core.os.bundleOf
import androidx.core.view.isInvisible
import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import androidx.lifecycle.LifecycleOwner
import com.secondworld.buenas.testingonandroid.R
import com.secondworld.buenas.testingonandroid.core.bases.BaseFragment
import com.secondworld.buenas.testingonandroid.core.extension.click
import com.secondworld.buenas.testingonandroid.core.extension.log
import com.secondworld.buenas.testingonandroid.core.navigation.Destinations
import com.secondworld.buenas.testingonandroid.databinding.FragmentQuestionsBinding
import com.secondworld.buenas.testingonandroid.domain.main_screen.model.SettingsTesting
import com.secondworld.buenas.testingonandroid.ui.screens.main_screen.MainFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class QuestionsFragment :
    BaseFragment<FragmentQuestionsBinding, QuestionsViewModel>(FragmentQuestionsBinding::inflate) {

    override val viewModel: QuestionsViewModel by viewModels()

    private val questionsAdapter = QuestionsAdapter()

    companion object {
        const val RIGHT_ANSWERS = "right_answers"
    }

    override fun initView() = with(binding) {

        btnNextQuestion.click {
            viewModel.nextQuestion()
        }

        btnAnswerComplete.click {
            viewModel.checkChoiceUser()
            questionsAdapter.isClickable = false
        }

        recyclerView.adapter = questionsAdapter

        customBackPressed(needCheck = true, titleAlert = "Новый текст")
    }

    override fun listenerBundleArguments() {
        readArguments<SettingsTesting>(MainFragment.SETTINGS_TESTING,
            ifExist = { settings ->
                log("сработало чтение аргументов")
                viewModel.saveCurrentTestingSettings(settings)
            })
    }

    override fun initObservers() = with(viewModel) {
        currentCountQuestions.observe { text -> binding.numberQuestion.text = text }

        currentNumberQuestion.observe { updateQuestionNumberInfo() }

        questionsState.observe { state ->

            when (state) {
                QuestionsState.NewQuestion -> {
                    hideBtnAnswerComplete()
                    questionsAdapter.isClickable = true
                }
                is QuestionsState.FinishTesting -> navigateTo(
                    Destinations.QUESTIONS_TO_RESULT.id,
                    bundleOf(RIGHT_ANSWERS to state.countRightAnswers)
                )
            }
        }

        currentQuestion.observe { question ->
            updateQuestionText(question.question)
            getCurrentAnswers(question.answers)
        }

        currentAnswers.observe { answers -> updateQuestionsAdapter(answers) }

        currentTestingSettings.observe {
            viewModel.updateQuestionNumberInfo()
            viewModel.fetchQuestionsFromRepo()
        }

        statusChoiceUser.observe { statusAnswer ->
            if (statusAnswer) {
                viewModel.updateStatusAnswer(CheckedStatus.RIGHT_ANSWER)
                viewModel.incCountRightAnswers()
            } else viewModel.updateStatusAnswer(CheckedStatus.WRONG_ANSWER)
        }

        currentListQuestions.observe {
            viewModel.updateCurrentQuestion()
            viewModel.startTimer()
        }

        currentTimerSecond.observe { second ->
            updateTimerText(second)

        }
    }

    private fun updateTimerText(second: Long) {
        binding.timer.text = second.toString()
        if (second <= 10) binding.timer.setTextColor(resources.getColor(R.color.crimson))
        else binding.timer.setTextColor(resources.getColor(R.color.Black))
    }

    private fun getCurrentAnswers(answers: List<String>) {
        viewModel.updateCurrentAnswers(answers)
    }

    override fun initCallbacks() {
        questionsAdapter.answerCallback = { numberElement ->
            viewModel.currentChoiceUser(numberElement)
            viewModel.updateStatusAnswer(CheckedStatus.SELECTED)
            showBtnAnswerComplete()
        }
    }

    private fun updateQuestionsAdapter(answers: List<AnswerUi>) {
        questionsAdapter.items = answers
    }

    private fun updateQuestionText(question: String) {
        binding.questionText.text = question
    }

    private fun hideBtnAnswerComplete() {
        binding.btnAnswerComplete.isInvisible = true
    }

    private fun showBtnAnswerComplete() {
        binding.btnAnswerComplete.isVisible = true
    }

    override fun title() = viewModel.title()
    override fun initLifecycleOwner(): LifecycleOwner = this@QuestionsFragment
}