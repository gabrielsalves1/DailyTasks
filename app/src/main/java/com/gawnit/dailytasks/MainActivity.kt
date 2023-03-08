package com.gawnit.dailytasks

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.gawnit.dailytasks.databinding.ActivityMainBinding
import com.gawnit.dailytasks.ui.TaskFormActivity
import java.io.File
import java.io.FileInputStream

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnCreateTask.setOnClickListener {
            startActivity(Intent(this, TaskFormActivity::class.java))
        }

        println("Lendo o arquivo ${readFile("daily_tasks_070323")}")
    }

    fun readFile(fileName: String): String {
        val path: File = applicationContext.filesDir
        val readFrom = File(path, fileName)
        val content = readFrom.readBytes()

        try {
            val stream = FileInputStream(readFrom)
            stream.read(content)

            return String(content)
        } catch (e: Exception) {
            e.printStackTrace()

            return e.toString()
        }
    }
}