package com.moter.room

import kotlinx.coroutines.Deferred


class TaskRepository(private val taskDao: TaskDao) : TaskDataSource {
    override fun getAllTasks(): Deferred<List<Task>> {
        return taskDao.getAllTasks()
    }
}