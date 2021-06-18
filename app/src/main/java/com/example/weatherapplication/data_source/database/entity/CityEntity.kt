package com.example.weatherapplication.data_source.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "city")
data class CityEntity(
    @PrimaryKey
    @SerializedName("name")
    val name: String
)