package com.example.weatherapplication.data_source.database.pojo

import com.google.gson.annotations.SerializedName

class MainResponse (
    @SerializedName("temp")
    val temp: String? = null
)