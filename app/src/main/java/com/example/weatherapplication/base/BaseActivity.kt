package com.example.weatherapplication.base

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.weatherapplication.WeatherApp
import com.example.weatherapplication.di.component.ViewModelComponent

abstract class BaseActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        createDaggerDependencies()
    }

    override fun startActivity(intent: Intent) {
        super.startActivity(intent)
//        overridePendingTransition(R.layout.activity_main)
    }

    override fun finish() {
        super.finish()
//        overridePendingTransition(R.layout.activity_spash)
    }

    protected abstract fun injectDependency(component: ViewModelComponent)

    private fun createDaggerDependencies() {
        injectDependency((application as WeatherApp).getViewModelComponent())
    }

     fun showError(error: String) {
        Toast.makeText(this, error, Toast.LENGTH_LONG).show()
    }
}