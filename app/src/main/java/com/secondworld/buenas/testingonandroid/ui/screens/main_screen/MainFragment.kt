package com.secondworld.buenas.testingonandroid.ui.screens.main_screen

import android.widget.RadioButton
import androidx.core.os.bundleOf
import androidx.fragment.app.viewModels
import com.secondworld.buenas.testingonandroid.R
import com.secondworld.buenas.testingonandroid.core.bases.BaseFragment
import com.secondworld.buenas.testingonandroid.core.extension.click
import com.secondworld.buenas.testingonandroid.core.navigation.Destinations
import com.secondworld.buenas.testingonandroid.data.testing_screen.local.data_storage.models.QuestionType
import com.secondworld.buenas.testingonandroid.data.testing_screen.local.data_storage.models.CountQuestionsType
import com.secondworld.buenas.testingonandroid.databinding.FragmentMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainFragment :
    BaseFragment<FragmentMainBinding, MainViewModel>(FragmentMainBinding::inflate) {

    companion object {
        const val SETTINGS_TESTING = "settings_testing"
    }

    override val viewModel: MainViewModel by viewModels()

    override fun initView() = with(binding) {

        radioGroupComplexity.setOnCheckedChangeListener { _, i ->
            when (i) {
                R.id.btnJunior -> viewModel.updateQuestionType(QuestionType.JUNIOR)
                R.id.btnMiddle -> viewModel.updateQuestionType(QuestionType.MIDDLE)
                R.id.btnSenior -> viewModel.updateQuestionType(QuestionType.SENIOR)
            }
        }

        radioGroupCountQuestions.setOnCheckedChangeListener { _, i ->
            when (i) {
                R.id.btnCountQuestion5 -> viewModel.updateComplexity(CountQuestionsType.TESTING)
                R.id.btnCountQuestion40 -> viewModel.updateComplexity(CountQuestionsType.EASY)
                R.id.btnCountQuestion60 -> viewModel.updateComplexity(CountQuestionsType.MEDIUM)
                R.id.btnCountQuestion80 -> viewModel.updateComplexity(CountQuestionsType.HARD)
            }
        }

        btnStartTesting.click {
            navigateTo(
                Destinations.MAIN_TO_QUESTIONS.id,
                bundleOf(SETTINGS_TESTING to viewModel.getSettingsTesting())
            )
        }

        initStartChoiceFromPrefs()
    }

    private fun initStartChoiceFromPrefs() = with(binding) {
        val setting = viewModel.getSettingsTesting()
        when (setting!!.questionsType) {
            QuestionType.JUNIOR -> btnJunior.active()
            QuestionType.MIDDLE -> btnMiddle.active()
            QuestionType.SENIOR -> btnSenior.active()
        }

        when (setting.countQuestions) {
            CountQuestionsType.TESTING -> btnCountQuestion5.active()
            CountQuestionsType.EASY -> btnCountQuestion40.active()
            CountQuestionsType.MEDIUM -> btnCountQuestion60.active()
            CountQuestionsType.HARD -> btnCountQuestion80.active()
        }
    }

    private fun RadioButton.active() {
        isChecked = true
    }

    override fun showBack(): Boolean = false
    override fun title() = viewModel.title()
    override fun initObservers() = Unit
}