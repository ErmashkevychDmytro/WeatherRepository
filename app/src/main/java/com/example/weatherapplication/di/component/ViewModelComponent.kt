package com.example.weatherapplication.di.component

import com.example.weatherapplication.di.module.ViewModelModule
import com.example.weatherapplication.di.scope.ViewModelScope
import com.example.weatherapplication.ui.detail.DetailActivity
import com.example.weatherapplication.ui.main.MainActivity
import com.example.weatherapplication.ui.splash.SplashActivity
import dagger.Component

@ViewModelScope
@Component(modules = [ViewModelModule::class], dependencies = [RepositoryComponent::class])
interface ViewModelComponent {
    fun inject(activity: MainActivity)
    fun inject(activity: SplashActivity)
    fun inject(activity: DetailActivity)
}
