package com.kamp.will.stackmvrx.questions.fragment

import android.os.Bundle
import android.view.View
import com.airbnb.epoxy.EpoxyRecyclerView
import com.airbnb.epoxy.SimpleEpoxyController
import com.airbnb.mvrx.BaseMvRxFragment
import com.airbnb.mvrx.fragmentViewModel
import com.airbnb.mvrx.withState
import com.kamp.will.stackmvrx.R
import com.kamp.will.stackmvrx.questions.epoxycontroller.QuestionEpoxyController
import com.kamp.will.stackmvrx.questions.viewmodel.MainViewModel
import kotlinx.android.synthetic.main.main_fragment.*

class MainFragment : BaseMvRxFragment(R.layout.main_fragment) {

    private lateinit var recyclerView: EpoxyRecyclerView
    private val epoxyController = QuestionEpoxyController()

    companion object {
        fun newInstance() = MainFragment()
    }

    private val viewModel: MainViewModel by fragmentViewModel()

    override fun invalidate() = withState(viewModel) { state ->
        epoxyController.requestModelBuild()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recyclerView = view.findViewById(R.id.recyclerView)
        recyclerView.setController(epoxyController)
    }
}
