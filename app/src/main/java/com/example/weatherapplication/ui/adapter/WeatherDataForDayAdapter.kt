package com.example.weatherapplication.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.weatherapplication.R
import com.example.weatherapplication.base.BaseAdapter
import com.example.weatherapplication.model.WeatherForDay

class WeatherDataForDayAdapter(
    private val context: Context,
    private val data: ArrayList<WeatherForDay>) :
    BaseAdapter<WeatherDataForDayViewHolder, WeatherForDay>(data as MutableList<WeatherForDay>) {

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): WeatherDataForDayViewHolder {
       return WeatherDataForDayViewHolder(
           LayoutInflater.from(p0.context).inflate(R.layout.item_weather_data_for_day, p0,false)
       )
    }

    override fun onBindViewHolder(holder: WeatherDataForDayViewHolder, position: Int) {
        super.onBindViewHolder(holder, position)
        holder.bind(data[position])
    }

    override fun getItemCount(): Int {
        return data.size
    }

}