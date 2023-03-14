package com.gawnit.dailytasks

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.gawnit.dailytasks.databinding.ActivityMainBinding
import com.gawnit.dailytasks.ui.TaskFormActivity
import com.gawnit.dailytasks.util.FileUtil
import com.gawnit.dailytasks.adapter.TaskAdapter

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnCreateTask.setOnClickListener {
            startActivity(Intent(this, TaskFormActivity::class.java))
        }

        binding.rcTasks.layoutManager = LinearLayoutManager(this)
        binding.rcTasks.setHasFixedSize(true)

        val listTask = FileUtil.readFile(applicationContext, "daily_tasks.json")
        val adapter = TaskAdapter(this, listTask)
        binding.rcTasks.adapter = adapter
    }
}