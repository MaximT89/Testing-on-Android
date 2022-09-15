package com.secondworld.buenas.testingonandroid.core.bases

import android.content.Context
import android.content.SharedPreferences
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class BaseSharedPreferences @Inject constructor(@ApplicationContext private val context: Context) {

    companion object {
        private const val APP_PREF = "app_prefs"
    }

    fun defaultPref(): SharedPreferences =
        context.getSharedPreferences(APP_PREF, Context.MODE_PRIVATE)
}