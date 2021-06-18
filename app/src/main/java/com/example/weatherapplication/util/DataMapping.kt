package com.example.weatherapplication.util

import com.example.weatherapplication.data_source.database.BaseErrorResponse
import com.example.weatherapplication.data_source.database.entity.CityEntity
import com.example.weatherapplication.data_source.database.pojo.BaseResponse
import com.example.weatherapplication.data_source.database.pojo.ForecastResponse
import com.example.weatherapplication.model.WeatherData
import com.example.weatherapplication.model.WeatherForDay
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.google.gson.JsonParseException
import okhttp3.ResponseBody
import retrofit2.Response
import java.util.*
import kotlin.collections.ArrayList


class DataMapping {
    companion object {

        fun convertStringToCity(name: String): CityEntity {
            return CityEntity(name)
        }

        fun convertList(list: List<String>): List<CityEntity> {
            var listCities = ArrayList<CityEntity>()
            for (i in 0 until list.size) {
                var cityEntity = CityEntity(list[i])
                listCities.add(cityEntity)
            }
            return listCities
        }

        fun parseBaseErrorResponse(response: ResponseBody): BaseErrorResponse {
            try {
                return getGson().fromJson(response.string(), BaseErrorResponse::class.java)
            } catch (e: JsonParseException) {
                return BaseErrorResponse(0, e.message)
            }
        }

        fun prepareData(response: Response<ResponseBody>): List<WeatherData> {
            var list = parseForecast(response.body()!!)
            return mappingForecast(list)
        }

        private fun mappingForecast(listFroMaping: List<ForecastResponse>): List<WeatherData> {

            var dictionary = Hashtable<String, WeatherData>()

            for (forecast in listFroMaping) {
                if (forecast.dtTxt != null) {
                    var keyDate = DateUtil.getDateData(forecast.dtTxt, DateUtil.FORMAT_DD_MMMM)
                    var existedWeather = dictionary.get(keyDate)
                    // if weatherData by key not exist - get init
                    if (existedWeather == null) {
                        var listWeatherForDay = ArrayList<WeatherForDay>()
                        listWeatherForDay.add(initWeatherForDay(forecast))
                        existedWeather =
                            WeatherData(keyDate, listWeatherForDay)
                        dictionary.put(keyDate, existedWeather)
                    }
                    //if weatherData by key exist - update list weatherForDay
                    else {
                        var array =
                            if (existedWeather.list!!.isNotEmpty()) ArrayList(existedWeather.list) else ArrayList()
                        array.add(initWeatherForDay(forecast))
                        existedWeather.list = array
                        dictionary.put(keyDate, existedWeather)
                    }
                }
            }

            return ArrayList(dictionary.values)
        }

        private fun parseForecast(response: ResponseBody): List<ForecastResponse> {
            try {
                val gson = getGson();
                var baseResponse = gson.fromJson(response.string(), BaseResponse::class.java)
                return baseResponse.list!!
            } catch (e: JsonParseException) {
                return Collections.emptyList()
            }
        }

        private fun initWeatherForDay(forecastResponse: ForecastResponse): WeatherForDay {
            var dataHours = DateUtil.getDateData(forecastResponse.dtTxt!!, DateUtil.FORMAT_HH_MM)
            var status = initStatus(forecastResponse)
            var temperature = initTemperature(forecastResponse)
            var windSpeed = initWindSpeed(forecastResponse)
            return WeatherForDay(
                dataHours,
                status,
                temperature,
                windSpeed
            )
        }

        private fun initWindSpeed(forecastResponse: ForecastResponse): String? {
            if (forecastResponse.wind != null)
                return forecastResponse.wind.speed!!
            else
                return null
        }

        private fun initStatus(forecastResponse: ForecastResponse): String? {
            var result: String? = ""
            if (forecastResponse.weather != null) {
                if (forecastResponse.weather[0] != null) {
                    result =
                        result + forecastResponse.weather[0].main + " (" + forecastResponse.weather[0].description + ")"
                }
            }
            return result
        }

        private fun initTemperature(forecastResponse: ForecastResponse): String? {
            if (forecastResponse.main?.temp != null)
                return forecastResponse.main?.temp
            else
                return null
        }

        private fun getGson() : Gson {
            return GsonBuilder().create()
        }
    }
}