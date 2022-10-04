package com.secondworld.buenas.testingonandroid.ui.screens.result_screen

import androidx.activity.OnBackPressedCallback
import androidx.fragment.app.viewModels
import androidx.lifecycle.LifecycleOwner
import androidx.navigation.fragment.findNavController
import com.secondworld.buenas.testingonandroid.core.bases.BaseFragment
import com.secondworld.buenas.testingonandroid.core.extension.click
import com.secondworld.buenas.testingonandroid.core.extension.updateText
import com.secondworld.buenas.testingonandroid.core.navigation.Destinations
import com.secondworld.buenas.testingonandroid.databinding.FragmentResultBinding
import com.secondworld.buenas.testingonandroid.ui.screens.questions_screen.QuestionsFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ResultFragment :
    BaseFragment<FragmentResultBinding, ResultViewModel>(FragmentResultBinding::inflate) {
    override val viewModel: ResultViewModel by viewModels()

    override fun title(): String = viewModel.title()

    override fun initView() {
        binding.btnTest.click {
            findNavController().navigateUp()
        }

    }

    override fun initObservers() {
    }

    override fun listenerBundleArguments() {

        readArguments<Int>(QuestionsFragment.RIGHT_ANSWERS,
            ifExist = { countRightQuestions -> updateUi(countRightQuestions) })
    }


    private fun updateUi(countRightQuestions: Int) {
        binding.countRightQuestions.text = countRightQuestions.toString()
    }

    override fun initLifecycleOwner(): LifecycleOwner = this@ResultFragment
}