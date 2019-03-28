package com.moter.room.db.converter

import androidx.room.TypeConverter
import java.util.*


object DateTypeConverter {

    @TypeConverter
    @JvmStatic
    fun toDate(value: Long?): Date? {
        return if (value == null) null else Date(value)
    }

    @TypeConverter
    @JvmStatic
    fun toLong(date: Date?): Long? {
        return date?.time
    }


}