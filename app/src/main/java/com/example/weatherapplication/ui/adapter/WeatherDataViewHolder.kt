package com.example.weatherapplication.ui.adapter

import android.content.Context
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.weatherapplication.model.WeatherData
import kotlinx.android.synthetic.main.item_weather_data.view.*

class WeatherDataViewHolder (
    itemView: View,
   var context:Context,
    val listener: WeatherOnClickListener
        ): RecyclerView.ViewHolder(itemView) {


    fun bind(weather: WeatherData) {
       itemView.tvWeatherDate.text = weather.date

        itemView.rvData.layoutManager = LinearLayoutManager(context)
        itemView.rvData.adapter =WeatherDataForDayAdapter(context, ArrayList(weather.list)
        )

        itemView.tvWeatherDate.setOnClickListener {
            weather.list?.let { it1 -> listener.weatherOnClickListener(weather,it1.first()) }
        }
    }
}