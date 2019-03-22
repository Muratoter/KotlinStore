package com.moter.mvvm

import android.app.Application
import com.moter.mvvm.di.appModule
import org.koin.core.context.startKoin


class MyApplication:Application()  {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            modules(appModule)
        }
    }
}