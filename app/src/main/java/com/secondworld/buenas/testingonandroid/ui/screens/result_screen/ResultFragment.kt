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

    override fun initObservers() {
    }

    override fun listenerBundleArguments() {

        readArguments<ResultCurrentTesting>(QuestionsFragment.RESULT_CURRENT_TESTING,
            ifExist = { countRightQuestions -> updateUi(countRightQuestions) })
    }

    private fun updateUi(result: ResultCurrentTesting) {
        updateTextColor(result)
        binding.countRightQuestions.text = "${result.rightAnswers} из ${result.countQuestions}"
    }

    private fun updateTextColor(result: ResultCurrentTesting) = with(binding){
        when(result.rightAnswers.toDouble() / (result.countQuestions.toDouble() / 100)){
            in 0.00..29.99 -> countRightQuestions.setTextColor(resources.getColor(R.color.Red))
            in 30.00..69.99 -> countRightQuestions.setTextColor(resources.getColor(R.color.chocolate))
            in 70.00..100.00 -> countRightQuestions.setTextColor(resources.getColor(R.color.Green))
        }
    }
}