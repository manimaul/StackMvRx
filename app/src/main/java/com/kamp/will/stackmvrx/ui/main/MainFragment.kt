package com.kamp.will.stackmvrx.ui.main

import android.os.Bundle
import android.view.View
import com.airbnb.mvrx.*
import com.kamp.will.stackmvrx.BuildConfig
import com.kamp.will.stackmvrx.R
import kotlinx.android.synthetic.main.main_fragment.*

data class MainState(val title: String = "Hello World") : MvRxState

class MainViewModel(initialState: MainState) : BaseMvRxViewModel<MainState>(initialState, debugMode = BuildConfig.DEBUG) {
    fun getMoreExcited() = setState { copy(title = "$title!") }
}

class MainFragment : BaseMvRxFragment(R.layout.main_fragment) {

    companion object {
        fun newInstance() = MainFragment()
    }

    private val viewModel: MainViewModel by fragmentViewModel()

    override fun invalidate() = withState(viewModel) { state ->
        message.text = state.title
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        message.setOnClickListener {
            viewModel.getMoreExcited()
        }
    }
}
