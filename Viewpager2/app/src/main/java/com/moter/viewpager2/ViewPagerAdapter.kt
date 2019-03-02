package com.moter.viewpager2

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.custom_viewpager2_item.view.*

class ViewPagerAdapter(private val items: List<Item>, private val ctx: Context) :
    RecyclerView.Adapter<ViewPagerAdapter.PagerViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PagerViewHolder {
        val v = LayoutInflater.from(ctx).inflate(R.layout.custom_viewpager2_item, parent, false)
        return PagerViewHolder(v)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: PagerViewHolder, position: Int) {
        holder.itemView.run {
            tvTitle.text= items[position].txt
            itemContainer.setBackgroundResource(items[position].color)

        }
    }

    class PagerViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
}
