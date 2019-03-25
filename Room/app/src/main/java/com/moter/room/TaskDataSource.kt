package com.moter.room

import kotlinx.coroutines.Deferred


interface TaskDataSource {
    fun getAllTasks(): Deferred<List<Task>>
}