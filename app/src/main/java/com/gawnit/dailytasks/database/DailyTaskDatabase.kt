package com.gawnit.dailytasks.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.gawnit.dailytasks.dao.TaskDao
import com.gawnit.dailytasks.model.Task

@Database(entities = [Task::class], version = 1, exportSchema = false)
abstract class DailyTaskDatabase: RoomDatabase() {
    abstract fun taskDao(): TaskDao

    companion object {
        @Volatile
        private var INSTANCE: DailyTaskDatabase? = null

        fun getDatabase(context: Context): DailyTaskDatabase {
            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }

            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    DailyTaskDatabase::class.java,
                    "daily_task_database"
                ).build()

                INSTANCE = instance
                return instance
            }
        }
    }
}