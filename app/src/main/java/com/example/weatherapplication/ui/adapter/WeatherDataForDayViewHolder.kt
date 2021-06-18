package com.example.weatherapplication.ui.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.weatherapplication.model.WeatherForDay
import kotlinx.android.synthetic.main.item_weather_data_for_day.view.*

class WeatherDataForDayViewHolder(
    itemView: View
) : RecyclerView.ViewHolder(itemView) {

    fun bind(day: WeatherForDay) {
       with(itemView){
           tvDayTemp.text = day.temperature
           tvDayStatus.text = day.description
           tvDayTime.text = day.hourData
           tvDayWind.text = day.windSpeed
       }
    }

}