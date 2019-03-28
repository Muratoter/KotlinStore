package com.moter.room.db.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity(tableName = "tasks")
data class Task(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo
    var taskId: Int?,
    @ColumnInfo
    var name: String,
    @ColumnInfo
    var date: Date?
) {
    constructor() : this(null, "", null)
}