package com.gawnit.dailytasks.ui.main

import android.app.Application
import android.content.Context
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.gawnit.dailytasks.database.DailyTaskDatabase
import com.gawnit.dailytasks.model.Task
import com.gawnit.dailytasks.repository.TaskRepository
import com.gawnit.dailytasks.util.FileUtil
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel(application: Application): AndroidViewModel(application) {
    val findAll: LiveData<List<Task>>
    private val repository: TaskRepository

    init {
        val taskDao = DailyTaskDatabase.getDatabase(application).taskDao()
        repository = TaskRepository(taskDao)
        findAll = repository.findAll
    }
}