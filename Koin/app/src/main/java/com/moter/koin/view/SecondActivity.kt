package com.moter.koin.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.moter.koin.presenter.MySimplePresenter
import com.moter.koin.R
import org.koin.android.ext.android.inject

class SecondActivity : AppCompatActivity() {
    val firstPresenter: MySimplePresenter by inject()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        Log.d("SecondActivity", firstPresenter.sayHello())
    }
}
