package com.example.weatherapplication.data_source.database.pojo

import com.google.gson.annotations.SerializedName

class WeatherResponse (
    @SerializedName("main")
    val main: String? = null,
    @SerializedName("description")
    val description: String? = null
)