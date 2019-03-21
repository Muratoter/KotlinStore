package com.moter.koin.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.moter.koin.presenter.MySimplePresenter
import com.moter.koin.R
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.android.ext.android.inject

class MainActivity : AppCompatActivity() {
    val firstPresenter: MySimplePresenter by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Log.d("MainActivity", firstPresenter.sayHello())

        btnNext.setOnClickListener {
            startActivity(Intent(applicationContext, SecondActivity::class.java))
        }
    }
}
