package com.app.targsoft.test.presentation

import android.os.Bundle
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.app.targsoft.test.R

class MainActivity : AppCompatActivity() {

    private val appBarList = setOf(
        R.id.navigation_home,
        R.id.navigation_dashboard,
        R.id.navigation_notifications
    )
    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val navView: BottomNavigationView = findViewById(R.id.nav_view)

        navController = findNavController(R.id.nav_host_fragment)
        setupActionBarWithNavController(navController, AppBarConfiguration(appBarList))
        navView.setupWithNavController(navController)
    }
}