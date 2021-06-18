package com.example.weatherapplication.di.module



import com.example.weatherapplication.di.scope.ViewModelScope
import com.example.weatherapplication.repository.AppRepository
import com.example.weatherapplication.ui.detail.DetailViewModel
import com.example.weatherapplication.ui.main.MainViewModel
import dagger.Module
import dagger.Provides


@Module
class ViewModelModule {

    @Provides
    @ViewModelScope
    internal fun provideMainViewModel(repository: AppRepository):MainViewModel {
        return MainViewModel(repository)
    }

    @Provides
    @ViewModelScope
    internal fun provideDetailViewModel(repository: AppRepository):DetailViewModel {
        return DetailViewModel(repository)
    }
}