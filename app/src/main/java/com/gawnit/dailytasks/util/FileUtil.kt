package com.gawnit.dailytasks.util

import android.content.Context
import android.os.Build
import androidx.annotation.RequiresApi
import com.gawnit.dailytasks.models.Task
import com.google.gson.Gson
import java.io.File
import java.io.FileInputStream
import java.time.LocalDate
import java.util.Date

class FileUtil {
    companion object {
        private lateinit var data: MutableList<Task>

        @RequiresApi(Build.VERSION_CODES.O)
        fun readFile(context: Context, fileName: String): List<Task> {
            val path: File = context.filesDir
            val readFrom = File(path, fileName)

            try {
                // Ajustar leitura de arquivo, retornando erro
                println("ReadFrom: ${readFrom.canWrite()} ${readFrom.canRead()}")
                readFrom.bufferedReader().forEachLine {
                    data.add(Gson().fromJson(it, Task::class.java))
                    println("Reading data: $data, it: $it")
                }

                return data
            } catch (e: Exception) {
                e.cause?.printStackTrace()

                data = ArrayList()
                data.add(Gson().fromJson("{\n" +
                                "\"name\": \"Cadastrar tarefa\"," +
                                "\"description\": \"Cadastre uma nova tarefa para utilizar...\"," +
                                "\"date\": \"${LocalDate.now()}\"," +
                                "\"endDate\": \"${LocalDate.now()}\"," +
                                "\"status\": \"Fazendo\"" +
                                "\n}", Task::class.java))
                return data
            }
        }
    }
}