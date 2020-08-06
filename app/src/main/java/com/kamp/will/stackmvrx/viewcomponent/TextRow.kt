package com.kamp.will.stackmvrx.viewcomponent

import android.content.Context
import android.util.AttributeSet
import android.widget.FrameLayout
import androidx.appcompat.widget.AppCompatTextView
import com.airbnb.epoxy.ModelView
import com.airbnb.epoxy.TextProp
import com.airbnb.paris.annotations.Styleable
import com.kamp.will.stackmvrx.R


@Styleable // Dynamic styling via the Paris library
@ModelView(autoLayout = ModelView.Size.MATCH_WIDTH_WRAP_HEIGHT)
class TextRow @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : FrameLayout(context, attrs, defStyleAttr) {

    private val title: AppCompatTextView

    init {
        inflate(getContext(), R.layout.text_row, this)
        title = findViewById(R.id.title)
    }

    @TextProp
    fun setTitle(title: CharSequence?) {
        this.title.text = title
    }
}