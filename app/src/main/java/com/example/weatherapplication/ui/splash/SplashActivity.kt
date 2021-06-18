package com.example.weatherapplication.ui.splash

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import com.example.weatherapplication.R
import com.example.weatherapplication.ui.auth.AuthActivity

class SplashActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_spash)

        Handler().postDelayed({
            val intent = Intent(this,AuthActivity::class.java)


            startActivity(intent)
            finish()
        }, 5000)

    }
}