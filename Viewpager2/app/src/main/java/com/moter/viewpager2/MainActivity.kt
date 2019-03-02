package com.moter.viewpager2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager2.widget.ViewPager2
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val items= listOf(
        Item("item1",android.R.color.holo_red_light),
        Item("item2",android.R.color.holo_blue_light),
        Item("item3",android.R.color.holo_green_light),
        Item("item4",android.R.color.holo_orange_light))

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        viewpager2.adapter=ViewPagerAdapter(items,this)

        //DEFAULT: HORIZONTAL
        viewpager2.orientation=ViewPager2.ORIENTATION_VERTICAL
    }
}
