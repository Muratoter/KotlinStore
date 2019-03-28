package com.moter.firestore.ui

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.moter.firestore.R
import com.moter.firestore.entity.Task
import com.moter.firestore.ui.adapter.TaskAdapter
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.androidx.viewmodel.ext.android.viewModel
import java.util.*

class MainActivity : AppCompatActivity() {
    private val viewModel: MainViewModel by viewModel()
    private var taskAdapter: TaskAdapter? = null
    private lateinit var taskList: List<Task>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rvList.setHasFixedSize(true)
        rvList.layoutManager = LinearLayoutManager(this)

        taskAdapter
        viewModel.liveDataTasks.observe(this, Observer {
            //            val date: Date = it[0].schedule.toDate()
            taskList = it
            loadTask()
        })
    }

    private fun loadTask() {
        taskAdapter = TaskAdapter(this, taskList)
        rvList.adapter = taskAdapter
    }
}
