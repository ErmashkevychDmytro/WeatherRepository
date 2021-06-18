package com.example.weatherapplication.model

    data class WeatherData(
        val date: String? = null,
        var list: List<WeatherForDay>? = null

    )
