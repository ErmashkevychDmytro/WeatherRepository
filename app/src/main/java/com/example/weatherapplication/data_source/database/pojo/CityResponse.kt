package com.example.weatherapplication.data_source.database.pojo

import com.google.gson.annotations.SerializedName

data class CityResponse(
    @SerializedName("name")
    val name: String,
    @SerializedName("id")
    val serverId: Int? = 0,
    @SerializedName("coord")
    val coord: CoordResponse? = null,
    @SerializedName("country")
    val country: String? = null,
    @SerializedName("population")
    val population: Int? = 0,
    @SerializedName("timezone")
    val timezone: Long? = 0
)