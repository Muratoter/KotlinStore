package com.moter.recyclerview

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.widget.LinearLayout
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val myList= listOf("ListItem1","ListItem2","ListItem3","ListItem4","ListItem5",
        "ListItem6","ListItem7","ListItem8","ListItem9","ListItem10")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rvList.layoutManager = LinearLayoutManager(this, LinearLayout.VERTICAL, false)
        rvList.adapter = Adapter(myList, this)
    }
}
