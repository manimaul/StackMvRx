package com.kamp.will.stackmvrx.questions.epoxycontroller

import com.airbnb.epoxy.EpoxyController
import com.kamp.will.stackmvrx.viewcomponent.textRow

class QuestionEpoxyController : EpoxyController() {

    override fun buildModels() {
        textRow {
            id("text row")
            title("hello epoxy")
        }
    }

}