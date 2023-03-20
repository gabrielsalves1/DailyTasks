package com.gawnit.dailytasks.repository

import androidx.lifecycle.LiveData
import com.gawnit.dailytasks.dao.TaskDao
import com.gawnit.dailytasks.model.Task

class TaskRepository(
    private val taskDao: TaskDao
) {
    val findAll: LiveData<List<Task>> = taskDao.findAll()

    suspend fun insert(task: Task) {
        taskDao.insert(task)
    }
}