package com.example.weatherapplication

import android.app.Application
import androidx.room.Room
import com.example.weatherapplication.data_source.database.AppDatabase
import com.example.weatherapplication.di.component.*
import com.example.weatherapplication.di.module.ApiModule
import com.example.weatherapplication.di.module.DatabaseModule
import com.example.weatherapplication.di.module.ViewModelModule
import com.example.weatherapplication.di.module.RepositoryModule

class WeatherApp: Application() {

        private var viewModelComponent: ViewModelComponent? = null
        private var database: AppDatabase? = null

        override fun onCreate() {
            super.onCreate()
            initRoom()
            initDagger()
        }

        private fun initRoom() {
            database = Room.databaseBuilder(this, AppDatabase::class.java, "database")
                .allowMainThreadQueries()
                .build()
        }

        private fun initDagger() {
            val apiComponent = DaggerApiComponent.builder()
                .apiModule(ApiModule())
                .build()

            val databaseComponent = DaggerDatabaseComponent.builder()
                .databaseModule(DatabaseModule(this!!.database!!))
                .build()

            val repositoryComponent = DaggerRepositoryComponent.builder()
                .apiComponent(apiComponent)
                .databaseComponent(databaseComponent)
                .repositoryModule(RepositoryModule())
                .build()

            viewModelComponent = DaggerViewModelComponent.builder()
                .repositoryComponent(repositoryComponent)
                .viewModelModule(ViewModelModule())
                .build()
        }

        fun getViewModelComponent(): ViewModelComponent {
            return this!!.viewModelComponent!!
        }
    }
