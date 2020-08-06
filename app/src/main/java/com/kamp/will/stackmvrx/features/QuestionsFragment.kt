package com.kamp.will.stackmvrx.features

import android.util.Log
import android.view.View
import androidx.lifecycle.viewModelScope
import com.airbnb.mvrx.*
import com.kamp.will.stackmvrx.R
import com.kamp.will.stackmvrx.core.BaseFragment
import com.kamp.will.stackmvrx.core.MvRxViewModel
import com.kamp.will.stackmvrx.core.simpleController
import com.kamp.will.stackmvrx.model.Questions
import com.kamp.will.stackmvrx.network.StackExchangeService
import com.kamp.will.stackmvrx.view.basicRow
import com.kamp.will.stackmvrx.view.loadingRow
import com.kamp.will.stackmvrx.view.marquee
import kotlinx.coroutines.launch

data class QuestionsState(
    val title: String = "Hello StackMvRx",
    val questions: Async<Questions> = Uninitialized
) : MvRxState

class QuestionsViewModel(initialState: QuestionsState) : MvRxViewModel<QuestionsState>(initialState) {
    private val stackExchangeService = StackExchangeService()

    init {
        request()
    }

    fun request() {
        setState { copy(questions = Loading()) }
        viewModelScope.launch {
            try {
                val response = stackExchangeService.questions()
                setState { copy(questions = Success(response)) }
            } catch (e: Exception) {
                setState { copy(questions = Fail(e)) }
            }
        }
    }
}

class QuestionsFragment : BaseFragment(R.layout.questions_fragment) {

    companion object {
        fun newInstance() = QuestionsFragment()
    }

    private val viewModel: QuestionsViewModel by fragmentViewModel()

    override fun epoxyController() = simpleController(viewModel) { state ->
        marquee {
            id("title")
            title(state.title)
        }
        when (val questions = state.questions) {
            is Loading -> {
                loadingRow {
                    id("loading")
                }
            }
            is Success -> {
                questions().items?.forEachIndexed { i, item ->
                    item.title?.let {
                        basicRow {
                            id("question $i")
                            title(item.title)
                            subtitle(R.string.view_answers)
                        }
                    }
                }
            }
            is Fail -> {
                Log.e(QuestionsFragment::class.java.simpleName, "error", questions.error)
                basicRow {
                    id("error try again")
                    title(R.string.error)
                    subtitle(R.string.error_retry)
                    clickListener(View.OnClickListener { viewModel.request() })
                }
            }
        }
    }
}
