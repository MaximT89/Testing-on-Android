package com.secondworld.buenas.testingonandroid.ui.screens.result_screen

import android.annotation.SuppressLint
import androidx.fragment.app.viewModels
import com.secondworld.buenas.testingonandroid.R
import com.secondworld.buenas.testingonandroid.core.bases.BaseFragment
import com.secondworld.buenas.testingonandroid.core.extension.click
import com.secondworld.buenas.testingonandroid.core.navigation.Destinations
import com.secondworld.buenas.testingonandroid.databinding.FragmentResultBinding
import com.secondworld.buenas.testingonandroid.ui.screens.questions_screen.QuestionsFragment
import com.secondworld.buenas.testingonandroid.ui.screens.questions_screen.modelUi.ResultCurrentTesting
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
@SuppressLint("SetTextI18n")
class ResultFragment :
    BaseFragment<FragmentResultBinding, ResultViewModel>(FragmentResultBinding::inflate) {
    override val viewModel: ResultViewModel by viewModels()

    override fun title(): String = viewModel.title()

    override fun initView() = with(binding) {

        btnReturnToMain.click { navigateTo(Destinations.RESULT_TO_MAIN.id) }
    }

    override fun initObservers() = with(viewModel){

        resultUiState.observe{ state ->
            when(state){
                is ResultUiState.UpdateUi -> {
                    updateResultText(state.result)
                    updateTextColor(state.textResultColor)
                    updateConclusionText(state.conclusionText)
                }
            }
        }
    }

    private fun updateConclusionText(conclusionText: String) {
        binding.conclusionText.text = conclusionText
    }

    override fun listenerBundleArguments() {
        readArguments<ResultCurrentTesting>(QuestionsFragment.RESULT_CURRENT_TESTING,
            ifExist = { resultCurrentTesting -> viewModel.updateResultCurrentTesting(resultCurrentTesting) })
    }

    private fun updateResultText(result: ResultCurrentTesting) = with(binding){
        countRightQuestions.text = "${result.rightAnswers} из ${result.countQuestions}"
    }

    private fun updateTextColor(textColor : Int) = with(binding){
        countRightQuestions.setTextColor(resources.getColor(textColor))
    }
}

