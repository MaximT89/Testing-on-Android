package com.secondworld.buenas.testingonandroid.ui.screens.result_screen

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.secondworld.buenas.testingonandroid.R
import com.secondworld.buenas.testingonandroid.core.bases.BaseViewModel
import com.secondworld.buenas.testingonandroid.core.common.ResourceProvider
import com.secondworld.buenas.testingonandroid.domain.result_screen.interactors.ResultInteractor
import com.secondworld.buenas.testingonandroid.ui.screens.questions_screen.modelUi.ResultCurrentTesting
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ResultViewModel @Inject constructor(
    private val resourceProvider: ResourceProvider,
    private val interactor: ResultInteractor
) : BaseViewModel() {
    override fun title(): String = resourceProvider.string(R.string.result_fragment_title)

    private var _resultUiSTate = MutableLiveData<ResultUiState>()
    val resultUiState : LiveData<ResultUiState> = _resultUiSTate

    fun updateResultCurrentTesting(result: ResultCurrentTesting) {
        _resultUiSTate.value = ResultUiState.UpdateUi(
            result,
            interactor.getResultColor(result.countQuestions, result.rightAnswers),
            interactor.getConclusionText(result)
        )
    }
}

sealed class ResultUiState {
    class UpdateUi(
        val result: ResultCurrentTesting,
        val textResultColor : Int,
        val conclusionText : String) : ResultUiState()
}

