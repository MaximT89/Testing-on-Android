package com.secondworld.buenas.testingonandroid.ui.screens.main_screen

import androidx.core.os.bundleOf
import androidx.fragment.app.viewModels
import androidx.lifecycle.LifecycleOwner
import com.secondworld.buenas.testingonandroid.core.bases.BaseFragment
import com.secondworld.buenas.testingonandroid.core.extension.click
import com.secondworld.buenas.testingonandroid.core.navigation.Destinations
import com.secondworld.buenas.testingonandroid.databinding.FragmentMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainFragment :
    BaseFragment<FragmentMainBinding, MainViewModel>(FragmentMainBinding::inflate) {

    companion object{
        const val SETTINGS_TESTING = "settings_testing"
    }

    override val viewModel: MainViewModel by viewModels()

    override fun initView() = with(binding) {

        btnStartTesting.click {
            navigateTo(
                Destinations.MAIN_TO_QUESTIONS.id,
                bundleOf(SETTINGS_TESTING to viewModel.)
            )
        }
    }

    override fun initObservers() {

    }

    override fun showBack(): Boolean = false
    override fun title() = viewModel.title()

}