package com.example.weatherapplication.ui.detail

import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.weatherapplication.R
import com.example.weatherapplication.base.BaseActivity
import com.example.weatherapplication.di.component.ViewModelComponent
import com.example.weatherapplication.model.WeatherData
import com.example.weatherapplication.model.WeatherForDay
import com.example.weatherapplication.ui.adapter.WeatherAdapter
import com.example.weatherapplication.ui.adapter.WeatherOnClickListener
import com.example.weatherapplication.util.shareWeather
import kotlinx.android.synthetic.main.activity_datail.*
import javax.inject.Inject

class DetailActivity : BaseActivity(),WeatherOnClickListener {

    var viewModel: DetailViewModel? = null
        @Inject set

    lateinit var weatherAdapter: WeatherAdapter

    private val cityName: String by lazy {
        intent.getStringExtra("cityName").toString()
    }

    private var type: ForecastType = ForecastType.ONE_DAY

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_datail)
        setupViewModel()
        loadData()

        bottomNav.setOnNavigationItemSelectedListener {
            when(it.itemId) {
                R.id.oneDay-> {
                    type = ForecastType.ONE_DAY
                    loadData()
                    true
                }

                R.id.fiveDay-> {
                    type = ForecastType.FIVE_DAYS
                    loadData()
                    true
                }
                else -> false
            }
        }
    }

    override fun injectDependency(component: ViewModelComponent) {
        component.inject(this)
    }

    private fun setupViewModel() = viewModel?.apply {
        error.observe(this@DetailActivity, ::showError)
        readyForcastByCityName.observe(this@DetailActivity, ::initRecycler)
    }

    private fun initRecycler(list: List<WeatherData>) {
        rvWeatherData.layoutManager = LinearLayoutManager(this)
        rvWeatherData.adapter = WeatherAdapter(this, ArrayList(list), this)
    }

    private fun loadData() = viewModel?.getForecastByCityName(cityName, type)

    override fun weatherOnClickListener(weather: WeatherData, weatherList: WeatherForDay) =
        shareWeather(cityName, weather.date.toString(), weatherList.toString())

}

