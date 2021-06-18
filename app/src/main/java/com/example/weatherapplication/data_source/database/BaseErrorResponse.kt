package com.example.weatherapplication.data_source.database

import com.google.gson.annotations.SerializedName

data class BaseErrorResponse (
    @SerializedName("cod")
    val code: Int? = null,
    @SerializedName("message")
    override val message: String? = null
) : Throwable()