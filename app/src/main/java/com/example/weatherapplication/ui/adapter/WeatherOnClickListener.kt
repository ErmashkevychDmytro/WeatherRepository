package com.example.weatherapplication.ui.adapter

import com.example.weatherapplication.data_source.database.entity.CityEntity
import com.example.weatherapplication.model.WeatherData
import com.example.weatherapplication.model.WeatherForDay

interface WeatherOnClickListener {
    fun weatherOnClickListener (weather: WeatherData, weatherList: WeatherForDay)
}