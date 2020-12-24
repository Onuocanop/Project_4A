package com.example.project_4a_kadioglu


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import org.koin.android.ext.android.inject
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    val mainViewModule: MainViewModule by inject()
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        main_button.setOnClickListener {
            mainViewModule.onClickedIncrement()
        }

        mainViewModule.counter.observe(this, Observer {
                value -> main_text.text = value.toString()
        })
    }
}