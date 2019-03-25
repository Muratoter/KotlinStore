package com.moter.room

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    private var taskViewModel: TaskViewModel? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        taskViewModel= TaskViewModel(application)

        GlobalScope.launch(Dispatchers.Main){
            val response= taskViewModel!!.getAllTasks().await()
            //TODO : show response
        }

    }
}
