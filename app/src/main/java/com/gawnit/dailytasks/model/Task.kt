package com.gawnit.dailytasks.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.gawnit.dailytasks.util.Converters
import java.util.Date

@Entity(tableName = "task_table")
data class Task(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val name: String,
    val description: String,
    @field:TypeConverters(Converters::class)
    val date: Date,
    var status: String
)