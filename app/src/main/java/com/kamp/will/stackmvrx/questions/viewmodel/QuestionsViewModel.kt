package com.kamp.will.stackmvrx.questions.viewmodel

import com.airbnb.mvrx.BaseMvRxViewModel
import com.airbnb.mvrx.MvRxState
import com.kamp.will.stackmvrx.BuildConfig

data class QuestionsState(val title: String = "Hello World") : MvRxState

class MainViewModel(initialState: QuestionsState) : BaseMvRxViewModel<QuestionsState>(initialState, debugMode = BuildConfig.DEBUG) {
    fun getMoreExcited() = setState { copy(title = "$title!") }
}