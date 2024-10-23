package com.example.recipehub

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.recipehub.databinding.ActivitySplashBinding

class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.button.setOnClickListener {
            val intent = Intent(this, MainActivity2::class.java)
            intent.putExtra("message", binding.editTextText.text.toString())
            startActivity(intent)
        }
    }

    override fun onStart() {
        Log.d("RecipeHub", "SplashActivity started")
        super.onStart()
    }

    override fun onResume() {
        Log.d("RecipeHub", "SplashActivity resumed")
        super.onResume()
    }

    override fun onPause() {
        Log.d("RecipeHub", "SplashActivity paused")
        super.onPause()
    }

    override fun onStop() {
        Log.d("RecipeHub", "SplashActivity stopped")
        super.onStop()
    }

    override fun onDestroy() {
        Log.d("RecipeHub", "SplashActivity destroyed")
        super.onDestroy()
    }
}