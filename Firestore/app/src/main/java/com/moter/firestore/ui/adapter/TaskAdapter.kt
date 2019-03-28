package com.moter.firestore.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.moter.firestore.R
import com.moter.firestore.entity.Task
import kotlinx.android.synthetic.main.custom_task_item.view.*


class TaskAdapter(val ctx: Context, val taskList: List<Task>) : RecyclerView.Adapter<TaskAdapter.ViewHolder>() {
    override fun getItemCount(): Int {
        return taskList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.tvTaskTitle.text=taskList[position].name
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(ctx).inflate(R.layout.custom_task_item, parent, false)
        return ViewHolder(view)
    }


    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvTaskTitle = itemView.tvTaskTitle
    }
}