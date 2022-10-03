package com.secondworld.buenas.testingonandroid.ui.screens.questions

import android.annotation.SuppressLint
import androidx.core.view.isInvisible
import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import com.secondworld.buenas.testingonandroid.core.bases.BaseFragment
import com.secondworld.buenas.testingonandroid.core.extension.click
import com.secondworld.buenas.testingonandroid.core.extension.enabled
import com.secondworld.buenas.testingonandroid.core.extension.log
import com.secondworld.buenas.testingonandroid.core.extension.notEnabled
import com.secondworld.buenas.testingonandroid.databinding.FragmentQuestionsBinding
import com.secondworld.buenas.testingonandroid.domain.main_screen.model.SettingsTesting
import com.secondworld.buenas.testingonandroid.ui.screens.main_screen.MainFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class QuestionsFragment :
    BaseFragment<FragmentQuestionsBinding, QuestionsViewModel>(FragmentQuestionsBinding::inflate) {

    override val viewModel: QuestionsViewModel by viewModels()

    private val questionsAdapter = QuestionsAdapter()

    override fun initView() = with(binding) {

        btnNextQuestion.click {
            viewModel.nextQuestion()
            hideBtnAnswerComplete()
            questionsAdapter.isClickable = true
        }

        btnAnswerComplete.click {
            // TODO: нужно сделать логику увеличения счета
            viewModel.checkChoiceUser()
            questionsAdapter.isClickable = false
        }

        recyclerView.adapter = questionsAdapter

        customBackPressed(needCheck = true)
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

        currentQuestion.observe { question ->
            updateQuestionText(question.question)
            getCurrentAnswers(question.answers)
        }

        currentAnswers.observe { answers -> updateQuestionsAdapter(answers) }

        currentTestingSettings.observe {
            viewModel.updateQuestionNumberInfo()
            viewModel.fetchQuestionsFromRepo()
        }

        statusChoiceUser.observe {
            if (it) viewModel.updateStatusAnswer(CheckedStatus.RIGHT_ANSWER)
            else viewModel.updateStatusAnswer(CheckedStatus.WRONG_ANSWER)
        }

        currentListQuestions.observe { viewModel.updateCurrentQuestion() }
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
}

