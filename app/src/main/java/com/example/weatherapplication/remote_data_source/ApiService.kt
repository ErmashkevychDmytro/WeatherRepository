package com.example.weatherapplication.remote_data_source

import io.reactivex.Single
import okhttp3.ResponseBody
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

private const val UNIT_METRIC = "metric"

interface ApiService {

    @GET("/data/2.5/forecast/")
    fun getForecastByCityName(
        @Query("appid") apiKey: String,
        @Query("q") query: String,
        @Query("cnt") cnt: Int,
        @Query("units") units: String = UNIT_METRIC
    ) : Single<Response<ResponseBody>>

}