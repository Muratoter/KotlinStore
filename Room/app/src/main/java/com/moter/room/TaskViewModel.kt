package com.moter.room

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import kotlinx.coroutines.Deferred

class TaskViewModel(application: Application) : AndroidViewModel(application) {
    private val repository: TaskRepository

    init {
        val taskDao = TaskDatabase.getDatabase(application).getTaskDao()
        repository = TaskRepository(taskDao)
    }

    fun getAllTasks(): Deferred<List<Task>> {
        return repository.getAllTasks()
    }

    override fun onCleared() {
        super.onCleared()
    }
}