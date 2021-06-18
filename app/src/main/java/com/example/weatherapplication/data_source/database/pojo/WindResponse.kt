package com.example.weatherapplication.data_source.database.pojo

import com.google.gson.annotations.SerializedName

data class WindResponse(
    @SerializedName("speed")
    val speed: String? = null,
    @SerializedName("deg")
    val deg: String? = null
)