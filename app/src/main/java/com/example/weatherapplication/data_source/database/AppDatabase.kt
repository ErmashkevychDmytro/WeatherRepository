package com.example.weatherapplication.data_source.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.weatherapplication.data_source.database.dao.CityDao
import com.example.weatherapplication.data_source.database.entity.CityEntity

@Database(entities = [CityEntity::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun cityDao(): CityDao
}