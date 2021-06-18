package com.example.weatherapplication.di.module

import com.example.weatherapplication.data_source.database.AppDatabase
import com.example.weatherapplication.di.scope.RepositoryScope
import com.example.weatherapplication.remote_data_source.ServerCommunicator
import com.example.weatherapplication.repository.AppRepository
import dagger.Module
import dagger.Provides


@Module
class RepositoryModule {
    @RepositoryScope
    @Provides
    internal fun providesRepository(
        communicator: ServerCommunicator,
        database: AppDatabase
    ): AppRepository {
        return AppRepository(communicator, database)
    }
}
