package com.moter.navigationcomponent

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.design.widget.NavigationView
import android.support.v4.widget.DrawerLayout
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.Navigation.findNavController
import androidx.navigation.ui.NavigationUI.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController

import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupNavigation()

    }

    override fun onSupportNavigateUp()= findNavController(this,R.id.my_nav_host).navigateUp()

    private fun setupNavigation(){
        val navController= Navigation.findNavController(this,R.id.my_nav_host)
        setupActionBarWithNavController(this,navController)
        bottomNavView.setupWithNavController(navController)
    }


}
