package com.kamp.will.stackmvrx.core

import com.airbnb.mvrx.BaseMvRxViewModel
import com.airbnb.mvrx.MvRxState
import com.kamp.will.stackmvrx.BuildConfig

abstract class MvRxViewModel<S : MvRxState>(initialState: S) : BaseMvRxViewModel<S>(
    initialState, debugMode = BuildConfig.DEBUG
)
