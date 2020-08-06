package com.kamp.will.stackmvrx.viewmodel

import com.airbnb.mvrx.BaseMvRxViewModel
import com.airbnb.mvrx.MvRxState
import com.kamp.will.stackmvrx.BuildConfig

data class MainState(val title: String = "Hello World") : MvRxState

class MainViewModel(initialState: MainState) : BaseMvRxViewModel<MainState>(initialState, debugMode = BuildConfig.DEBUG) {
    fun getMoreExcited() = setState { copy(title = "$title!") }
}