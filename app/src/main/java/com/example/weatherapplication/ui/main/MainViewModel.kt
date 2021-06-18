package com.example.weatherapplication.ui.main

import androidx.lifecycle.MutableLiveData
import com.example.weatherapplication.base.BaseViewModel
import com.example.weatherapplication.data_source.database.entity.CityEntity
import com.example.weatherapplication.repository.AppRepository

class MainViewModel(
    private val repository: AppRepository
) : BaseViewModel() {

    val onCityRemoved = MutableLiveData<CityEntity>()
    val onCityAdded = MutableLiveData<CityEntity>()
    val onListUpdated = MutableLiveData<List<CityEntity>>()


    fun removeCity(name: String) {
        var cityEntity = CityEntity(name)
        compositeDisposable.add(repository.removeCity(cityEntity).subscribe {
            onCityRemoved.postValue(cityEntity)
        })
    }

    fun addCity(name: String) {
        var cityEntity = CityEntity(name)
        compositeDisposable.add(repository.addCity(cityEntity).subscribe {
            onCityAdded.postValue(cityEntity)
        })
    }

    fun getListCities() {
        compositeDisposable?.add(repository.getListCities().subscribe({
            onListUpdated.postValue(it)
        }, ::onError))
    }
}