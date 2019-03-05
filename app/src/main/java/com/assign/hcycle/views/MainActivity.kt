package com.assign.hcycle.views

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.ui.NavigationUI
import com.assign.hcycle.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var navigationController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        setTheme(R.style.NoActionBar)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setupNavigationController()
    }

    private fun setupNavigationController() {

        navigationController = Navigation.findNavController(this, R.id.fragment)

        NavigationUI.setupWithNavController(bottomNavigation, navigationController)
    }
}
