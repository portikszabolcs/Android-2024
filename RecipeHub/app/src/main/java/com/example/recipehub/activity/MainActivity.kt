package com.example.recipehub.activity

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.recipehub.R
import com.example.recipehub.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment?
        if (navHostFragment != null) {
            val navController = navHostFragment.navController
            val navView = binding.bottomNavigationView
            val appBarConfiguration = AppBarConfiguration(
                setOf(R.id.homeFragment, R.id.recipesFragment, R.id.profileFragment)
            )
            setupActionBarWithNavController(navController, appBarConfiguration)
            navView.setupWithNavController(navController)
        }
    }

    override fun onStart() {
        Log.d("RecipeHub", "MainActivity started")
        super.onStart()
    }

    override fun onResume() {
        Log.d("RecipeHub", "MainActivity resumed")
        super.onResume()
    }

    override fun onPause() {
        Log.d("RecipeHub", "MainActivity paused")
        super.onPause()
    }

    override fun onStop() {
        Log.d("RecipeHub", "MainActivity stopped")
        super.onStop()
    }

    override fun onDestroy() {
        Log.d("RecipeHub", "MainActivity destroyed")
        super.onDestroy()
    }
}