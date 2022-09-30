package com.secondworld.buenas.testingonandroid.ui.screens.questions

import androidx.fragment.app.viewModels
import com.secondworld.buenas.testingonandroid.core.bases.BaseFragment
import com.secondworld.buenas.testingonandroid.core.extension.click
import com.secondworld.buenas.testingonandroid.databinding.FragmentQuestionsBinding
import com.secondworld.buenas.testingonandroid.domain.main_screen.model.SettingsTesting
import com.secondworld.buenas.testingonandroid.ui.screens.main_screen.MainFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class QuestionsFragment :
    BaseFragment<FragmentQuestionsBinding, QuestionsViewModel>(FragmentQuestionsBinding::inflate) {

    override val viewModel: QuestionsViewModel by viewModels()

    override fun initView() = with(binding){

        btnNextQuestion.click { viewModel.nextQuestion() }

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

        currentQuestion.observe { question -> updateQuestionText(question.question) }

        currentTestingSettings.observe {
            viewModel.updateQuestionNumberInfo()
            viewModel.fetchQuestionsFromRepo()
        }

        currentListQuestions.observe { viewModel.updateCurrentQuestion() }
    }

    private fun updateQuestionText(question: String) {
        binding.questionText.text = question
    }

    override fun title() = viewModel.title()
}