package com.example.weatherapplication.repository

import com.example.weatherapplication.data_source.database.AppDatabase
import com.example.weatherapplication.data_source.database.entity.CityEntity
import com.example.weatherapplication.remote_data_source.ServerCommunicator
import io.reactivex.Completable
import io.reactivex.Maybe
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import okhttp3.ResponseBody
import retrofit2.Response

class AppRepository(
    private val communicator: ServerCommunicator,
    private val database: AppDatabase)
{

    fun getForecastByCityName(name: String, cnt: Int): Single<Response<ResponseBody>> {
        return communicator.getForecastByCityName(name, cnt)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
    }

    fun addCity(city: CityEntity): Completable {
        return Maybe.just(city)
            .flatMapCompletable {
                Completable.fromAction { database.cityDao().insert(it) }
            }
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
    }

    fun removeCity(city: CityEntity): Completable {
        return Maybe.just(city)
            .flatMapCompletable {
                Completable.fromAction { database.cityDao().delete(city) }
            }
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
    }

    fun getListCities(): Single<List<CityEntity>> {
        return Single.just(database.cityDao().getAll())
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
    }
}