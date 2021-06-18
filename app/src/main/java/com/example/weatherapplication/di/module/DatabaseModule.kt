package com.example.weatherapplication.di.module

import com.example.weatherapplication.data_source.database.AppDatabase
import dagger.Module
import dagger.Provides

@Module
class DatabaseModule(private val appDatabase: AppDatabase) {
    @Provides
    internal fun providesRoomDatabase(): AppDatabase {
        return appDatabase
    }
}