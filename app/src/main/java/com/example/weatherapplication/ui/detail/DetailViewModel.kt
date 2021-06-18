package com.example.weatherapplication.ui.detail

import androidx.lifecycle.MutableLiveData
import com.example.weatherapplication.base.BaseViewModel
import com.example.weatherapplication.model.WeatherData
import com.example.weatherapplication.repository.AppRepository
import com.example.weatherapplication.util.DataMapping

class DetailViewModel(val repository: AppRepository): BaseViewModel() {

    var listItems = MutableLiveData<List<WeatherData>>()
    val readyForcastByCityName = MutableLiveData<List<WeatherData>>()
    val isWeatherEmpty = MutableLiveData<String>()



    fun getForecastByCityName(cityName: String, type: ForecastType) {
        compositeDisposable.add(repository.getForecastByCityName(cityName, type.count).subscribe ({ response ->
            if (response.isSuccessful) {
                val listContent = DataMapping.prepareData(response)
                if(listContent.isNotEmpty()) {
                    this.readyForcastByCityName.value = listContent
                }else{
                    isWeatherEmpty.value = "List is empty"
                }
            } else {
                val errorContent = response.errorBody()?.let { DataMapping.parseBaseErrorResponse(it) }
                isWeatherEmpty.value = errorContent?.message
            }
        }, :: onError))
    }


}
