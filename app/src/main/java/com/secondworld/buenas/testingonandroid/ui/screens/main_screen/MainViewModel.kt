package com.secondworld.buenas.testingonandroid.ui.screens.main_screen

import androidx.lifecycle.MutableLiveData
import com.secondworld.buenas.testingonandroid.R
import com.secondworld.buenas.testingonandroid.core.bases.BaseViewModel
import com.secondworld.buenas.testingonandroid.core.common.ResourceProvider
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val resourceProvider: ResourceProvider): BaseViewModel() {
    override fun title() = resourceProvider.string(R.string.title_main)

    var _settingsTesting = MutableLiveData<>()


}