package com.secondworld.buenas.testingonandroid.ui.screens.questions

import androidx.fragment.app.viewModels
import com.secondworld.buenas.testingonandroid.core.bases.BaseFragment
import com.secondworld.buenas.testingonandroid.databinding.FragmentQuestionsBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class QuestionsFragment :
    BaseFragment<FragmentQuestionsBinding, QuestionsViewModel>(FragmentQuestionsBinding::inflate) {

    override val viewModel: QuestionsViewModel by viewModels()

    override fun initView() {
        customBackPressed(
            needCheck = true,
            successBack = {

            },
            cancelBack = {

            }
        )
    }

    override fun initObservers() {}

    override fun title() = viewModel.title()
}