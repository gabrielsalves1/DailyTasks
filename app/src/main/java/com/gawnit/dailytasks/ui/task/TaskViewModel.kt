package com.gawnit.dailytasks.ui.task

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.gawnit.dailytasks.database.DailyTaskDatabase
import com.gawnit.dailytasks.model.Task
import com.gawnit.dailytasks.repository.TaskRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class TaskViewModel(application: Application) : AndroidViewModel(application) {
    private val repository: TaskRepository

    init {
        val taskDao = DailyTaskDatabase.getDatabase(application).taskDao()
        repository = TaskRepository(taskDao)
    }

    fun findById(id: Int): LiveData<Task> {
        return repository.findById(id)
    }
}