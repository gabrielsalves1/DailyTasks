package com.gawnit.dailytasks

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.LinearLayoutManager
import com.gawnit.dailytasks.databinding.ActivityMainBinding
import com.gawnit.dailytasks.ui.TaskFormActivity
import com.gawnit.dailytasks.util.FileUtil
import com.gawnit.dailytasks.util.TaskAdapter
import java.io.File
import java.io.FileInputStream

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnCreateTask.setOnClickListener {
            startActivity(Intent(this, TaskFormActivity::class.java))
        }

        binding.rcTasks.layoutManager = LinearLayoutManager(this)
        binding.rcTasks.setHasFixedSize(true)

        var listTask = FileUtil.readFile(applicationContext, "daily_tasks_070323")
        var adapter = TaskAdapter(this, listTask)
        binding.rcTasks.adapter = adapter
    }
}