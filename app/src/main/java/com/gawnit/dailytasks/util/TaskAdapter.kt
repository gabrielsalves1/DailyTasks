package com.gawnit.dailytasks.util

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.gawnit.dailytasks.R
import com.gawnit.dailytasks.models.Task

class TaskAdapter(private val context: Context, private val tasks: List<Task>):
    RecyclerView.Adapter<TaskAdapter.TaskViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskViewHolder {
        val taskItem = LayoutInflater.from(context).inflate(R.layout.task_item, parent, false)

        return TaskViewHolder(taskItem)
    }

    override fun onBindViewHolder(holder: TaskViewHolder, position: Int) {
        holder.name.text = tasks[position].name
        holder.description.text = tasks[position].description
    }

    override fun getItemCount(): Int = tasks.size

    inner class TaskViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val name: TextView = itemView.findViewById<TextView>(R.id.txt_name)
        val description: TextView = itemView.findViewById<TextView>(R.id.txt_description)
    }
}