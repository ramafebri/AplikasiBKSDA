package com.example.aplikasibksda.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.aplikasibksda.R
import android.os.Handler
import android.os.Looper

class ExitActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_exit)

        Handler(Looper.getMainLooper()).postDelayed({
            finishAffinity()
        }, 1500)
    }
}