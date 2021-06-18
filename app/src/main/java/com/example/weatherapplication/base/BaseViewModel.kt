package com.example.weatherapplication.base

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import io.reactivex.disposables.CompositeDisposable

abstract class BaseViewModel: ViewModel() {

    val error = MutableLiveData<String>()

    protected val compositeDisposable = CompositeDisposable()

    fun onError(t: Throwable) {
        t.message?.let(error::postValue)
    }

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.dispose()
    }
}