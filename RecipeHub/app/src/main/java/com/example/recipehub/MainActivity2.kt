package com.example.recipehub

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import com.example.recipehub.databinding.ActivityMainBinding

class MainActivity2 : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.message.text = intent.extras?.getString("message")
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