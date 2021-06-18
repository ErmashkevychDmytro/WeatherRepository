package com.example.weatherapplication.ui.main

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.weatherapplication.R
import com.example.weatherapplication.base.BaseActivity
import com.example.weatherapplication.data_source.database.entity.CityEntity
import com.example.weatherapplication.di.component.ViewModelComponent
import com.example.weatherapplication.ui.adapter.CityAdapter
import com.example.weatherapplication.ui.adapter.CityOnClickListener
import com.example.weatherapplication.ui.detail.DetailActivity
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class MainActivity : BaseActivity(), CityOnClickListener {

    var viewModel: MainViewModel? = null
        @Inject set

    lateinit var adapterCity: CityAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupViewModel()
        viewModel?.getListCities()
        initCityName()
    }

    override fun injectDependency(component: ViewModelComponent) {
        component.inject(this)
    }

    override fun cityOnClick(city: CityEntity) {
        val nextActivity = Intent ( this, DetailActivity::class.java)
        nextActivity.putExtra("cityName", city.name)
        startActivity(nextActivity)
    }

    private fun showListCities(list: List<CityEntity>) {
        rvCities.layoutManager = LinearLayoutManager(this)
        val items = ArrayList(list)
        adapterCity = CityAdapter( items, this)
        rvCities.adapter = adapterCity
    }

    private fun addCity(city: CityEntity) {
        adapterCity.addItem(city)
    }

    private fun removeCity(city: CityEntity) {
        adapterCity.removeItem(city)
    }

    private fun initCityName() {
        addCityToList.setOnClickListener {
            val cityName = editCityName.text.toString()
            viewModel?.addCity(cityName)
        }
    }

    private fun setupViewModel() = viewModel?.apply {
        error.observe(this@MainActivity, ::showError)
        onCityRemoved.observe(this@MainActivity, ::removeCity)
        onCityAdded.observe(this@MainActivity, ::addCity)
        onListUpdated.observe(this@MainActivity, ::showListCities)
    }

    companion object {
        @JvmStatic
        fun newInstance(context: Context): Intent {
            val intent = Intent(context, MainActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            return intent
        }
    }

}