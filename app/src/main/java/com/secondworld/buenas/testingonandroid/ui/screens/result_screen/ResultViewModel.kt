package com.secondworld.buenas.testingonandroid.ui.screens.result_screen

import com.secondworld.buenas.testingonandroid.R
import com.secondworld.buenas.testingonandroid.core.bases.BaseViewModel
import com.secondworld.buenas.testingonandroid.core.common.ResourceProvider
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ResultViewModel @Inject constructor(private val resourceProvider: ResourceProvider) : BaseViewModel() {
    override fun title(): String = resourceProvider.string(R.string.result_fragment_title)
}