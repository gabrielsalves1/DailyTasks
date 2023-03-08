package com.gawnit.dailytasks.ui

import android.os.Bundle
import android.widget.Button
import android.widget.RadioButton
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.gawnit.dailytasks.R
import com.gawnit.dailytasks.databinding.ActivityTaskFormBinding
import java.io.File
import java.io.FileOutputStream

class TaskFormActivity : AppCompatActivity() {
    private lateinit var binding: ActivityTaskFormBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTaskFormBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnSaveTask.setOnClickListener {
            val name = binding.editTaskName.text.toString()
            val description = binding.editTaskDescription.text.toString()
            val taskDate = binding.editTaskDate.text.toString()
            val taskEndDate = binding.editTaskEndDate.text.toString()
            val statusId = binding.rgStatus.checkedRadioButtonId
            val status = findViewById<RadioButton>(statusId).text.toString()

            val data = "$name, $description, $taskDate, $taskEndDate, $status"
            writeFile("daily_tasks_070323", data)
        }
    }

    fun writeFile(fileName: String, content: String) {
        val path: File = applicationContext.filesDir

        try {
            val writer = FileOutputStream(File(path, fileName))
            writer.write(content.toByteArray())
            writer.close()

            Toast.makeText(applicationContext, "Salvo com sucesso! $path", Toast.LENGTH_SHORT).show()
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }
}
