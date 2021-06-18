package com.example.weatherapplication.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.weatherapplication.R
import com.example.weatherapplication.base.BaseAdapter

import com.example.weatherapplication.data_source.database.entity.CityEntity
import com.example.weatherapplication.ui.main.MainActivity

class CityAdapter (
    private var cities: ArrayList<CityEntity>,
    private val listener: MainActivity)
    : BaseAdapter<CityViewHolder, CityEntity>(cities as MutableList<CityEntity>) {

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): CityViewHolder {
     return CityViewHolder(
         LayoutInflater.from(p0.context).inflate(R.layout.item_city, p0,false),
         listener
     )
    }

    override fun onBindViewHolder(holder: CityViewHolder, position: Int) {
        super.onBindViewHolder(holder, position)
        holder.bind(cities[position])
    }

    override fun getItemCount(): Int {
        return cities.size
    }

    fun addItem(item: CityEntity) {
        cities.add(item)
        notifyDataSetChanged()
    }

    fun removeItem(item: CityEntity) {
        cities.remove(item)
        notifyDataSetChanged()
    }
}