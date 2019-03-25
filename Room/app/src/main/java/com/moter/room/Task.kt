package com.moter.room

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity(tableName = "tasks")
data class Task(
    @PrimaryKey
    @ColumnInfo
    val id: String,
    @ColumnInfo
    val name: String,
    @ColumnInfo
    val date: Date
)