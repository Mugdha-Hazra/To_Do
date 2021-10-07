package com.abhishek.to_do.data.models

import android.os.Parcelable
import android.renderscript.RenderScript
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Entity(tableName = "todo_table")
@Parcelize
data class ToDoData(
    @PrimaryKey(autoGenerate = true)
    var id: Int,
    var title: String,
    var priority: RenderScript.Priority,
    var description: String
): Parcelable