package com.kamp.will.stackmvrx.core

import android.os.Bundle
import android.view.View
import androidx.annotation.LayoutRes
import com.airbnb.epoxy.EpoxyRecyclerView
import com.airbnb.mvrx.BaseMvRxFragment
import com.kamp.will.stackmvrx.R

open class BaseFragment(@LayoutRes contentLayoutId: Int = 0) : BaseMvRxFragment(contentLayoutId) {

    var recyclerView: EpoxyRecyclerView? = null
    protected val epoxyController by lazy { epoxyController() }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recyclerView = view.findViewById(R.id.recyclerView)
        recyclerView?.setController(epoxyController)
    }

    override fun invalidate() {
        recyclerView?.requestModelBuild()
    }

    open fun epoxyController() = MvRxEpoxyController {}

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        epoxyController.onSaveInstanceState(outState)
    }

    override fun onDestroyView() {
        epoxyController.cancelPendingModelBuild()
        super.onDestroyView()
    }
}