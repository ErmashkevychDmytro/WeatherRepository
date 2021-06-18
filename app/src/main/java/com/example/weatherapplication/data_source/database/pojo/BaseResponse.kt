package com.example.weatherapplication.data_source.database.pojo

import com.google.gson.annotations.SerializedName

data class BaseResponse(
    @SerializedName("cod")
    val code: Int? = null,
    @SerializedName("message")
    val message: String? = null,
    @SerializedName("cnt")
    val count: Int? = null,
    @SerializedName("list")
    val list: List<ForecastResponse>? = null,
    @SerializedName("city")
    val city: CityResponse? = null
)