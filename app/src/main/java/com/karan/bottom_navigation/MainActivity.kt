package com.karan.bottom_navigation

import android.os.Bundle
import android.view.Menu
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.replace
import androidx.navigation.NavController
import androidx.navigation.findNavController
import com.karan.bottom_navigation.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    lateinit var binding:ActivityMainBinding
    lateinit var navController: NavController
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        navController = findNavController(R.id.navController)

        navController.addOnDestinationChangedListener { navController, destination, argument -> }
        binding.bottomNavigation.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.first -> navController.navigate(R.id.fragement1)
                R.id.second -> navController.navigate(R.id.fragment2)
                R.id.third -> navController.navigate(R.id.fragment3)

            }
            return@setOnItemSelectedListener true
        }
    }
}

