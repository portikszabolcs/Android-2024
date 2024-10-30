package com.example.recipehub.activity

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.example.recipehub.R
import com.example.recipehub.databinding.ActivityMainBinding
import com.example.recipehub.ui.HomeFragment
import com.example.recipehub.ui.ProfileFragment
import com.example.recipehub.ui.RecipesFragment


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.bottomNavigationView.setOnItemSelectedListener{
            val id = it.itemId
            when(id) {
                R.id.homeFragment -> replaceFragment(HomeFragment())
                R.id.recipesFragment -> replaceFragment(RecipesFragment())
                R.id.profileFragment -> replaceFragment(ProfileFragment())
            }
            true
        }
    }

    private fun replaceFragment(fragment: Fragment) {
        val binding = ActivityMainBinding.inflate(layoutInflater)
        val fragmentManager: FragmentManager = supportFragmentManager
        val transaction: FragmentTransaction = fragmentManager.beginTransaction()
        transaction.replace(binding.navHostFragment.id, fragment)
        transaction.commit()
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