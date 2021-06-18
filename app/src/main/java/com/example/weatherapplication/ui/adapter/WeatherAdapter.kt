package com.example.weatherapplication.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.weatherapplication.R
import com.example.weatherapplication.base.BaseAdapter
import com.example.weatherapplication.model.WeatherData
import com.example.weatherapplication.ui.detail.DetailActivity

class WeatherAdapter(
    private var context: Context,
    private var weather: ArrayList<WeatherData>,
    private var listener: DetailActivity
    )
    : BaseAdapter<WeatherDataViewHolder, WeatherData>(weather as MutableList<WeatherData>) {

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): WeatherDataViewHolder {
        return WeatherDataViewHolder(
            LayoutInflater.from(p0.context).inflate(R.layout.item_weather_data, p0, false),
            context,
            listener
        )
    }

    override fun onBindViewHolder(holder: WeatherDataViewHolder, position: Int) {
        super.onBindViewHolder(holder, position)
        holder.bind(weather[position])
    }

    override fun getItemCount(): Int {
        return weather.count()
    }
}