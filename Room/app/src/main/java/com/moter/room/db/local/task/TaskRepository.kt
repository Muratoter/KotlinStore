package com.moter.room.db.local.task

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.moter.room.db.entity.Task
import com.moter.room.db.local.task.TaskDao
import com.moter.room.db.local.task.TaskDataSource


class TaskRepository(private val taskDao: TaskDao) : TaskDataSource {
    override suspend fun insertTask(task: Task) {
        taskDao.insertTask(task)
    }

    override suspend fun getAllTasks(): List<Task> {
        return taskDao.getAllTasks()
    }
}