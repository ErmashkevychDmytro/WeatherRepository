package com.example.weatherapplication.util

import android.content.Context
import android.content.Intent

fun Context.shareWeather(cityName: String, date: String, weather: String) {
    val sendIntent: Intent = Intent().apply {
        action = Intent.ACTION_SEND
        putExtra(
            Intent.EXTRA_TEXT,
            "in city:$cityName\nday:${date} \nweather is: $weather"
        )
        type = "text/plain"
    }
    val shareIntent = Intent.createChooser(sendIntent, null)
    startActivity(shareIntent)
}