package com.moter.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.Deferred


@Dao
interface TaskDao {
    @Query("SELECT * FROM tasks")
    fun getAllTasks(): Deferred<List<Task>>

    @Insert
    fun insertTask(task: Task)

}