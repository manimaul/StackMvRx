package com.kamp.will.stackmvrx.questions.fragment

import android.os.Bundle
import android.view.View
import com.airbnb.mvrx.BaseMvRxFragment
import com.airbnb.mvrx.fragmentViewModel
import com.airbnb.mvrx.withState
import com.kamp.will.stackmvrx.R
import com.kamp.will.stackmvrx.questions.viewmodel.MainViewModel
import kotlinx.android.synthetic.main.main_fragment.*

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
