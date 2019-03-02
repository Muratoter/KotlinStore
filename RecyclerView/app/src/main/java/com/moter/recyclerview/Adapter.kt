package com.moter.recyclerview

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.custom_list_item.view.*

/**
 * Created by moter on 02.03.2019.
 */
class Adapter(private val myList: List<String>,private val ctx: Context) : RecyclerView.Adapter<Adapter.MyViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, p1: Int): MyViewHolder {
        val v = LayoutInflater.from(ctx).inflate(R.layout.custom_list_item, parent, false)
        return MyViewHolder(v)
    }

    override fun getItemCount(): Int {
        return myList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bindItems(myList[position])
    }

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bindItems(listItemText: String) {
            itemView.tvItem.text = listItemText
        }
    }
}