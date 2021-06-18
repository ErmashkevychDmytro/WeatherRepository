package com.example.weatherapplication.remote_data_source

import io.reactivex.ObservableTransformer
import io.reactivex.Single
import io.reactivex.SingleTransformer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import okhttp3.ResponseBody
import retrofit2.Response
import java.util.concurrent.TimeUnit

class ServerCommunicator(private val api: ApiService) {

    companion object {
        private const val DEFAULT_TIMEOUT = 10
        private const val DEFAULT_RETRY_ATTEMPTS = 4L
        private const val API_KEY = "4c38a963a75b0cc7ae2dd1f18681edb3"
    }

    fun getForecastByCityName(name: String, cnt: Int): Single<Response<ResponseBody>> {
        return api.getForecastByCityName(API_KEY, name, cnt)
            .compose(singleTransformer())
    }

    private fun <T> singleTransformer(): SingleTransformer<T, T> = SingleTransformer {
        it.subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .timeout(DEFAULT_TIMEOUT.toLong(), TimeUnit.SECONDS)
            .retry(DEFAULT_RETRY_ATTEMPTS)
    }

    private fun <T> observableTransformer(): ObservableTransformer<T, T> = ObservableTransformer {
        it.subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .timeout(DEFAULT_TIMEOUT.toLong(), TimeUnit.SECONDS)
            .retry(DEFAULT_RETRY_ATTEMPTS)
    }
}