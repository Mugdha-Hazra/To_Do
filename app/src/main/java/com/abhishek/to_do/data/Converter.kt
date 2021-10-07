package com.abhishek.to_do.data

import android.renderscript.RenderScript
import androidx.room.TypeConverter

class Converter {

    @TypeConverter
    fun fromPriority(priority: RenderScript.Priority): String {
        return priority.name
    }

    @TypeConverter
    fun toPriority(priority: String): RenderScript.Priority {
        return RenderScript.Priority.valueOf(priority)
    }

}