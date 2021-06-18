package com.example.weatherapplication.ui.adapter

import com.example.weatherapplication.data_source.database.entity.CityEntity

interface CityOnClickListener {
    fun cityOnClick(city: CityEntity)
}