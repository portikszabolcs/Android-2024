package com.example.recipehub

import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.recipehub.databinding.ActivitySplashBinding

class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_splash)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val binding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.button.setOnClickListener { launchMain(binding.editTextText.text) }
    }

    fun launchMain(message: Editable) {
        Log.d("RH", message.length.toString())
        val intent = Intent(this, MainActivity2::class.java)
        intent.putExtra("message", message)
        startActivity(intent)
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