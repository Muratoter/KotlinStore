package com.moter.room.view

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.moter.room.db.entity.Task
import com.moter.room.db.local.TaskDatabase
import com.moter.room.db.local.task.TaskRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class TaskViewModel(application: Application) : AndroidViewModel(application) {
    private val repository: TaskRepository
    var tasks= MutableLiveData<List<Task>>()

    init {
        val taskDao = TaskDatabase.getDatabase(application).getTaskDao()
        repository = TaskRepository(taskDao)

    }

    fun getAllTasks() {
        GlobalScope.launch(Dispatchers.Main) {
            val response = repository.getAllTasks()
            tasks.value=response
        }
    }

    fun insertTask(task: Task) {
        GlobalScope.launch(Dispatchers.Main) {
            repository.insertTask(task)
            getAllTasks()
        }
    }

    override fun onCleared() {
        super.onCleared()
    }
}