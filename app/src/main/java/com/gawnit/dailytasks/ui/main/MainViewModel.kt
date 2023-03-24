package com.gawnit.dailytasks.ui.main

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.gawnit.dailytasks.database.DailyTaskDatabase
import com.gawnit.dailytasks.model.Task
import com.gawnit.dailytasks.repository.TaskRepository

class MainViewModel(application: Application): AndroidViewModel(application) {
    val findAll: LiveData<List<Task>>
    private val repository: TaskRepository

    init {
        val taskDao = DailyTaskDatabase.getDatabase(application).taskDao()
        repository = TaskRepository(taskDao)
        findAll = repository.findAll
    }
}