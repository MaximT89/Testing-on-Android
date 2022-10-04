package com.secondworld.buenas.testingonandroid.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.secondworld.buenas.testingonandroid.R
import com.secondworld.buenas.testingonandroid.core.extension.log
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onBackPressed() {
        super.onBackPressed()

        log("Activity onBackPressed work")
    }
}