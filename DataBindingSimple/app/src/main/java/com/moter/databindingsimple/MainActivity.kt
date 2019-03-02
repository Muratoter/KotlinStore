package com.moter.databindingsimple

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil

class MainActivity : AppCompatActivity() {
    private val user = User("Murat Öter", "oter.mmurat@gmail.com", 24)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding: com.moter.databindingsimple.databinding.ActivityMainBinding =
            DataBindingUtil.setContentView(this, R.layout.activity_main)

        binding.user = user

    }
}
