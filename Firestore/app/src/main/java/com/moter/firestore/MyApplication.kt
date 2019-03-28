package com.moter.firestore

import android.app.Application
import com.moter.firestore.di.appModule
import org.koin.core.context.startKoin


class MyApplication:Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            modules(appModule)
        }
    }
}