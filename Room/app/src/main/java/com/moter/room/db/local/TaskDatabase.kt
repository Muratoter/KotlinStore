package com.moter.room.db.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.moter.room.db.entity.Task
import com.moter.room.db.converter.DateTypeConverter
import com.moter.room.db.local.task.TaskDao


@Database(entities = [Task::class], version = 3, exportSchema = false)
@TypeConverters(DateTypeConverter::class)
public abstract class TaskDatabase : RoomDatabase() {
    abstract fun getTaskDao(): TaskDao

    companion object {
        @Volatile
        private var INSTANCE: com.moter.room.db.local.TaskDatabase? = null

        fun getDatabase(context: Context): com.moter.room.db.local.TaskDatabase {
            val tempInstance = INSTANCE
            if (tempInstance != null)
                return tempInstance
            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    TaskDatabase::class.java,
                    "taskdb"
                ).build()
                INSTANCE = instance
                return instance
            }
        }
    }
}