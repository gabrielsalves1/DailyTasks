package com.gawnit.dailytasks.util

import android.content.Context
import android.widget.Toast
import com.gawnit.dailytasks.model.Task
import com.google.gson.GsonBuilder
import org.json.JSONObject
import java.io.File
import java.io.FileOutputStream
import kotlin.collections.ArrayList

class FileUtil {
    companion object {
        private lateinit var data: ArrayList<Task>

        fun readFile(context: Context, fileName: String): List<Task> {
            val path: File = context.filesDir
            val readerFile = File(path, fileName)
            data = ArrayList()
            val gson = GsonBuilder().setDateFormat("dd/mm/yyyy").create()

            try {
                readerFile.readLines().forEach {
                    data.add(gson.fromJson(it, Task::class.java))
                }

                return data
            } catch (e: Exception) {
                e.cause?.printStackTrace()
                data.add(gson.fromJson(
                    "{\n" +
                            "\"name\": \"Cadastre uma tarefa! :)\"," +
                            "\"description\": \"Cadastre uma nova tarefa para utilizar os recursos do app.\"," +
                            "\"date\": \"06/03/2023\"," +
                            "\"status\": \"Fazendo\"" +
                    "\n}", Task::class.java)
                )

                return data
            }
        }

        fun writeFile(context: Context, fileName: String, content: JSONObject) {
            val path: File = context.filesDir

            try {
                val writer = FileOutputStream(File(path, fileName), true)
                writer.write("$content\n".toByteArray())
                writer.close()

                Toast.makeText(context, "Salvo com sucesso! $path", Toast.LENGTH_SHORT).show()
            } catch (e: Exception) {
                e.cause?.printStackTrace()
            }
        }
    }
}