package com.example.weatherapplication.data_source.database.pojo

import com.google.gson.annotations.SerializedName

data class CoordResponse(
    @SerializedName("lat")
    val lat: String? = null,
    @SerializedName("lon")
    val lon: String? = null
)