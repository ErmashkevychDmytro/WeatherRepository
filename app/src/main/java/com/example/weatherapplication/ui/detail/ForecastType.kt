package com.example.weatherapplication.ui.detail

private const val MAX_FORECAST_PER_DAY = 6

enum class ForecastType(val count: Int) {
    ONE_DAY(1 * MAX_FORECAST_PER_DAY),
    FIVE_DAYS(5 * MAX_FORECAST_PER_DAY)
}