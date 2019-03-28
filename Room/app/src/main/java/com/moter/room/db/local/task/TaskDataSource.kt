package com.moter.room.db.local.task

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.moter.room.db.entity.Task


interface TaskDataSource {
    suspend fun getAllTasks(): List<Task>

    suspend fun insertTask(task: Task)
}