package com.gawnit.dailytasks.ui.main

import android.content.Context
import androidx.lifecycle.ViewModel
import com.gawnit.dailytasks.model.Task
import com.gawnit.dailytasks.util.FileUtil

class MainViewModel: ViewModel() {
    private var listTask: MutableList<Task> = mutableListOf()

    fun readFile(applicationContext: Context): List<Task> {
        listTask = FileUtil.readFile(applicationContext, "daily_tasks.json") as MutableList<Task>
        return listTask
    }
}