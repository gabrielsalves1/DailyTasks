package com.gawnit.dailytasks.models

import java.time.LocalDate

data class Task(
    val name: String,
    val description: String,
//  val date: LocalDate = LocalDate.now(),
    var status: String
)