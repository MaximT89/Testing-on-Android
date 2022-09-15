package com.secondworld.buenas.testingonandroid.ui.screens.questions

import androidx.fragment.app.viewModels
import com.secondworld.buenas.testingonandroid.core.bases.BaseFragment
import com.secondworld.buenas.testingonandroid.databinding.FragmentQuestionsBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class QuestionsFragment : BaseFragment<FragmentQuestionsBinding, QuestionsViewModel>(FragmentQuestionsBinding::inflate) {

    override val viewModel: QuestionsViewModel by viewModels()

    override fun initView() {

    }

    override fun initObservers() {
        TODO("Not yet implemented")
    }

    override fun navigationArrowBack() {
        TODO("Not yet implemented")
    }
}