package com.moter.room.view

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.moter.room.R
import com.moter.room.db.entity.Task
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {
    private lateinit var taskViewModel: TaskViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        taskViewModel = ViewModelProviders.of(this).get(TaskViewModel::class.java)

        taskViewModel.getAllTasks()

        taskViewModel.tasks?.observe(this, Observer {
            tvTasks.text = it.toString()
        })

        btnAdd.setOnClickListener {
            val task = Task()
            task.name = "Hey"
            task.date = Calendar.getInstance().time

            taskViewModel.insertTask(task)
        }

    }
}
