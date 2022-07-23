package com.example.lgm_covidtrackerapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.lgm_covidtrackerapp.model.CovidModel

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        CovidModel(this)
    }
}
