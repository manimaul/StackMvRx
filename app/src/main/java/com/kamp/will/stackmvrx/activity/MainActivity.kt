package com.kamp.will.stackmvrx.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.kamp.will.stackmvrx.R
import com.kamp.will.stackmvrx.questions.fragment.QuestionsFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                    .replace(R.id.container, QuestionsFragment.newInstance())
                    .commitNow()
        }
    }
}