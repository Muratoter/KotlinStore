package com.moter.koin.presenter

import android.util.Log
import com.moter.koin.repository.HelloRepository


class MySimplePresenter(val repository: HelloRepository) {
    init {
        Log.d("MySimplePresenter","init")
    }
    fun sayHello():String {
        return repository.hello()
    }
}