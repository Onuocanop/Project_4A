package com.example.project_4a_kadioglu.presentation.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.project_4a_kadioglu.R
import kotlinx.android.synthetic.main.activity_third.*

class ThirdActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_third)

        toolbar.setTitle("Pokemon List")
    }
}