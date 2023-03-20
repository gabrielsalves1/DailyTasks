package com.gawnit.dailytasks.ui.taskform

import android.app.Application
import android.content.Context
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.gawnit.dailytasks.database.DailyTaskDatabase
import com.gawnit.dailytasks.model.Task
import com.gawnit.dailytasks.repository.TaskRepository
import com.gawnit.dailytasks.util.FileUtil
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.json.JSONObject

class TaskFormViewModel(application: Application): AndroidViewModel(application) {
    private val repository: TaskRepository

    init {
        val taskDao = DailyTaskDatabase.getDatabase(application).taskDao()
        repository = TaskRepository(taskDao)
    }

    fun insert(task: Task) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.insert(task)
        }
    }
}