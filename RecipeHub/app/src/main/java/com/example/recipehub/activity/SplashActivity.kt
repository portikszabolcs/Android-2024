package com.example.recipehub.activity

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.recipehub.R

class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_splash)
        Handler(Looper.getMainLooper()).postDelayed({
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }, 1500)
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