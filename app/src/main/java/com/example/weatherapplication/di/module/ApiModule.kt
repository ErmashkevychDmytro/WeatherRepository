package com.example.weatherapplication.di.module

import androidx.multidex.BuildConfig
import com.example.weatherapplication.di.scope.ApiScope
import com.example.weatherapplication.remote_data_source.ApiService
import com.example.weatherapplication.remote_data_source.ServerCommunicator
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import kotlinx.coroutines.timeunit.TimeUnit
import okhttp3.ConnectionPool
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

@Module
class ApiModule {

    @Provides
    @ApiScope
    fun provideCommunicator(apiService: ApiService): ServerCommunicator {
        return ServerCommunicator(apiService)
    }

    @Provides
    @ApiScope
    fun provideApiService(retrofit: Retrofit): ApiService {
        return retrofit.create<ApiService>(ApiService::class.java)
    }

    @Provides
    @ApiScope
    fun provideRetrofit(builder: Retrofit.Builder): Retrofit {
        return builder.baseUrl(API_URL).build()
    }

    @Provides
    @ApiScope
    fun provideRetrofitBuilder(): Retrofit.Builder {
        val builder = OkHttpClient.Builder()
            .connectionPool(ConnectionPool(5, 30, TimeUnit.SECONDS))
            .connectTimeout(30, TimeUnit.SECONDS)
            .readTimeout(30, TimeUnit.SECONDS)
            .writeTimeout(30, TimeUnit.SECONDS)

        if (BuildConfig.DEBUG) {
            val httpLoggingInterceptor = HttpLoggingInterceptor()
            httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
            builder.addInterceptor(httpLoggingInterceptor)
        }

        val gson = GsonBuilder()
            .create()

        return Retrofit.Builder()
            .client(builder.build())
            .addConverterFactory(GsonConverterFactory.create(gson))
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
    }

    companion object {
        private const val API_URL = "https://api.openweathermap.org/"
    }

}