package com.kamp.will.stackmvrx.features

import android.view.View
import com.airbnb.mvrx.MvRxState
import com.airbnb.mvrx.fragmentViewModel
import com.kamp.will.stackmvrx.R
import com.kamp.will.stackmvrx.core.BaseFragment
import com.kamp.will.stackmvrx.core.MvRxViewModel
import com.kamp.will.stackmvrx.core.simpleController
import com.kamp.will.stackmvrx.network.StackExchangeService
import com.kamp.will.stackmvrx.view.basicRow
import com.kamp.will.stackmvrx.view.marquee

data class QuestionsState(val title: String = "Hello Epoxy") : MvRxState

class MainViewModel(initialState: QuestionsState) : MvRxViewModel<QuestionsState>(initialState) {
    private val stackExchangeService = StackExchangeService()

    fun getMoreExcited() = setState { copy(title = "$title!") }
}

class QuestionsFragment : BaseFragment(R.layout.questions_fragment) {

    companion object {
        fun newInstance() = QuestionsFragment()
    }

    private val viewModel: MainViewModel by fragmentViewModel()

    override fun epoxyController() = simpleController(viewModel) { state ->
        marquee {
            id("header")
            title("welcome to stack mvrx")
        }
        basicRow {
            id("hello row")
            title(state.title)
            subtitle(R.string.app_name)
            clickListener(View.OnClickListener { viewModel.getMoreExcited() })
        }

    }
}
