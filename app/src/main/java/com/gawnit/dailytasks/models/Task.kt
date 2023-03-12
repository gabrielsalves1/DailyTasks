package com.gawnit.dailytasks.models

import java.util.Date

data class Task(
    val name: String,
    val description: String,
    val date: Date,
    var status: String
)