package com.example.weatherapplication.ui.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.weatherapplication.data_source.database.entity.CityEntity
import kotlinx.android.synthetic.main.item_city.view.*

class CityViewHolder(
    itemView: View,
    private val listener: CityOnClickListener
) : RecyclerView.ViewHolder(itemView) {
    fun bind(city: CityEntity) {
        with(itemView) {
            textCityName.text = city.name

            setOnClickListener {
               listener.cityOnClick(city)
            }
        }
    }
}