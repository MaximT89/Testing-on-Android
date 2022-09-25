package com.secondworld.buenas.testingonandroid.core.bases

import androidx.lifecycle.ViewModel

abstract class BaseViewModel : ViewModel() {
    abstract fun title() : String
}