package com.example.weatherapplication.di.component

import com.example.weatherapplication.di.module.RepositoryModule
import com.example.weatherapplication.di.scope.RepositoryScope
import com.example.weatherapplication.repository.AppRepository
import dagger.Component

@RepositoryScope
@Component(modules = [RepositoryModule::class], dependencies = [ApiComponent::class, DatabaseComponent::class])
interface RepositoryComponent {
    val repository: AppRepository
}
