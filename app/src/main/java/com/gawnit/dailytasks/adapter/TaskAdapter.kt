package com.gawnit.dailytasks.adapter

import android.content.Context
import android.graphics.Color
import android.graphics.drawable.Drawable
import android.text.format.DateFormat
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.gawnit.dailytasks.R
import com.gawnit.dailytasks.model.Task

class TaskAdapter(private val context: Context, private val tasks: List<Task>):
    RecyclerView.Adapter<TaskAdapter.TaskViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskViewHolder {
        val taskItem = LayoutInflater.from(context).inflate(R.layout.task_item, parent, false)

        return TaskViewHolder(taskItem)
    }

    override fun onBindViewHolder(holder: TaskViewHolder, position: Int) {
        holder.name.text = tasks[position].name
        holder.description.text = tasks[position].description

        when(tasks[position].status) {
            "Fazer" -> setDateAndIcon(holder, position, "#94DEEE", R.drawable.ic_playlist_add)
            "Fazendo" -> setDateAndIcon(holder, position, "#FFD276", R.drawable.ic_double_arrow_up)
            "Feito" -> setDateAndIcon(holder, position, "#9DE2C0", R.drawable.ic_done)
        }
    }

    override fun getItemCount(): Int = tasks.size

    private fun setDateAndIcon(holder: TaskViewHolder, position: Int, color: String, icon: Int) {
        holder.date.text = DateFormat.format("dd/mm/yyyy", tasks[position].date).toString()
        holder.date.setTextColor(Color.parseColor(color))
        holder.status.setImageResource(icon)
    }

    inner class TaskViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val name: TextView = itemView.findViewById(R.id.txt_name)
        val description: TextView = itemView.findViewById(R.id.txt_description)
        val date: TextView = itemView.findViewById(R.id.txt_date)
        val status: ImageView = itemView.findViewById(R.id.img_status)
    }
}