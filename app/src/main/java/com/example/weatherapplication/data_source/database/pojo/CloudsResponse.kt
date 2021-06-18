package com.example.weatherapplication.data_source.database.pojo

import com.google.gson.annotations.SerializedName

data class CloudsResponse(
    @SerializedName("all")
    val all: Int? = null
)