package com.example.weatherapplication.data_source.database.pojo

import com.google.gson.annotations.SerializedName

data class ForecastResponse(
    @SerializedName("dt")
    val dt: Long? = 0,
    @SerializedName("main")
    val main: MainResponse? = null,
    @SerializedName("weather")
    val weather: List<WeatherResponse>? = null,
    @SerializedName("clouds")
    val clouds: CloudsResponse? = null,
    @SerializedName("wind")
    val wind: WindResponse? = null,
    @SerializedName("rain")
    val rain: RainResponse? = null,
    @SerializedName("dt_txt")
    val dtTxt: String? = null
)