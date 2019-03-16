package com.moter.retrofit.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.moter.retrofit.R
import com.moter.retrofit.model.Post
import kotlinx.android.synthetic.main.custom_post_item.view.*

class PostAdapter(val context: Context, val postList: List<Post>) : RecyclerView.Adapter<PostAdapter.MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, p1: Int): MyViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.custom_post_item, parent, false)
        return MyViewHolder(view)
    }

    override fun getItemCount(): Int {
        return postList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.tvPostTitle.text = postList[position].title
        holder.tvPostContent.text = StringBuilder(postList[position].body.substring(0, 30)).append("..")
        holder.tvPostAuthor.text = postList[position].userId.toString()
    }

    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvPostTitle = itemView.tvPostTitle
        val tvPostContent = itemView.tvPostContent
        val tvPostAuthor = itemView.tvPostAuthor

    }
}