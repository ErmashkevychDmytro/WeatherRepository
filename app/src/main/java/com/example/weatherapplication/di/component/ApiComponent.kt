package com.example.weatherapplication.di.component

import com.example.weatherapplication.di.module.ApiModule
import com.example.weatherapplication.di.scope.ApiScope
import com.example.weatherapplication.remote_data_source.ServerCommunicator
import dagger.Component

@ApiScope
@Component(modules = [ApiModule::class])
interface ApiComponent {
    val serverCommunicator: ServerCommunicator
}