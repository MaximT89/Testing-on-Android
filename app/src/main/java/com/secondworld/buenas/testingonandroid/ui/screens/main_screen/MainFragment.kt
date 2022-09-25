package com.secondworld.buenas.testingonandroid.ui.screens.main_screen

import androidx.fragment.app.viewModels
import androidx.lifecycle.LifecycleOwner
import com.secondworld.buenas.testingonandroid.core.bases.BaseFragment
import com.secondworld.buenas.testingonandroid.core.extension.click
import com.secondworld.buenas.testingonandroid.core.navigation.Destinations
import com.secondworld.buenas.testingonandroid.databinding.FragmentMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainFragment : BaseFragment<FragmentMainBinding, MainViewModel>(FragmentMainBinding::inflate) {
    override val viewModel: MainViewModel by viewModels()

    override fun initView() = with(binding){

        btnGoNext.click {
            navigateTo(Destinations.MAIN_TO_QUESTIONS.id)
        }
    }

    override fun initObservers() {

    }

    override fun showBack(): Boolean = false
    override fun title() = viewModel.title()

}