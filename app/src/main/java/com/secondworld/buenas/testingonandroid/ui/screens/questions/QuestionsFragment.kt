package com.secondworld.buenas.testingonandroid.ui.screens.questions

import android.annotation.SuppressLint
import androidx.fragment.app.viewModels
import com.secondworld.buenas.testingonandroid.core.bases.BaseFragment
import com.secondworld.buenas.testingonandroid.core.extension.click
import com.secondworld.buenas.testingonandroid.core.extension.log
import com.secondworld.buenas.testingonandroid.databinding.FragmentQuestionsBinding
import com.secondworld.buenas.testingonandroid.domain.main_screen.model.SettingsTesting
import com.secondworld.buenas.testingonandroid.ui.screens.main_screen.MainFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class QuestionsFragment :
    BaseFragment<FragmentQuestionsBinding, QuestionsViewModel>(FragmentQuestionsBinding::inflate) {

    override val viewModel: QuestionsViewModel by viewModels()

    private val questionsAdapter = QuestionsAdapter()

    override fun initView() = with(binding){

        btnNextQuestion.click { viewModel.nextQuestion() }

        recyclerView.adapter = questionsAdapter

        customBackPressed(
            successBack = {},
            cancelBack = {}
        )
    }

    override fun listenerBundleArguments() {
        readArguments<SettingsTesting>(MainFragment.SETTINGS_TESTING,
            ifExist = { settings ->
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

        currentAnswers.observe { answers ->  updateQuestionsAdapter(answers)}

        currentTestingSettings.observe {
            viewModel.updateQuestionNumberInfo()
            viewModel.fetchQuestionsFromRepo()
        }

        currentListQuestions.observe { viewModel.updateCurrentQuestion() }
    }

    private fun getCurrentAnswers(answers: List<String>) {
        viewModel.updateCurrentAnswers(answers)
    }

    override fun initCallbacks() {

        questionsAdapter.answerCallback = { numberElement ->
            viewModel.updateStatusAnswer(numberElement, CheckedStatus.SELECTED)
        }
    }

    private fun updateQuestionsAdapter(answers: List<AnswerUi>) {
        questionsAdapter.items = answers
    }

    private fun updateQuestionText(question: String) {
        binding.questionText.text = question
    }

    override fun title() = viewModel.title()
}

