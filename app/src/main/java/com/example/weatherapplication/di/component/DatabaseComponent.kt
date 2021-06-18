package com.example.weatherapplication.di.component

import com.example.weatherapplication.data_source.database.AppDatabase
import com.example.weatherapplication.di.module.DatabaseModule
import dagger.Component

@Component(modules = [DatabaseModule::class])
interface DatabaseComponent {
    val database: AppDatabase
}