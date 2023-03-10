package com.gawnit.dailytasks.ui

import android.content.Intent
import android.os.Bundle
import android.widget.RadioButton
import androidx.appcompat.app.AppCompatActivity
import com.gawnit.dailytasks.MainActivity
import com.gawnit.dailytasks.databinding.ActivityTaskFormBinding
import com.gawnit.dailytasks.util.FileUtil
import org.json.JSONObject
import java.time.LocalDate

class TaskFormActivity : AppCompatActivity() {
    private lateinit var binding: ActivityTaskFormBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTaskFormBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnSaveTask.setOnClickListener {
            val name = binding.editTaskName.text.toString()
            val description = binding.editTaskDescription.text.toString()
//          val taskDate = binding.editTaskDate.text.toString()
            val statusId = binding.rgStatus.checkedRadioButtonId
            val status = findViewById<RadioButton>(statusId).text.toString()

            val data = JSONObject(
                "{\n" +
                    "\"name\": \"$name\"," +
                    "\"description\": \"$description\"," +
//                  "\"date\": \"${LocalDate.now()}\"," +
                    "\"status\": \"$status\"" +
                    "\n}"
            )

            FileUtil.writeFile(applicationContext, "daily_tasks.json", data)
            startActivity(Intent(this, MainActivity::class.java))
        }
    }
}
