package com.gawnit.dailytasks.ui.taskform

import android.content.Context
import androidx.lifecycle.ViewModel
import com.gawnit.dailytasks.util.FileUtil
import org.json.JSONObject

class TaskFormViewModel : ViewModel() {
    fun writeFile(applicationContext: Context, data: JSONObject) {
        FileUtil.writeFile(applicationContext, "daily_tasks.json", data)
    }
}