package com.example.recipehub

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.recipehub.ui.theme.RecipeHubTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            RecipeHubTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }

    override fun onStart() {
        Log.d("Main", "MainActivity started")
        super.onStart()
    }

    override fun onResume() {
        Log.d("Main", "MainActivity resumed")
        super.onResume()
    }

    override fun onPause() {
        Log.d("Main", "MainActivity paused")
        super.onPause()
    }

    override fun onStop() {
        Log.d("Main", "MainActivity stopped")
        super.onStop()
    }

    override fun onDestroy() {
        Log.d("Main", "MainActivity destroyed")
        super.onDestroy()
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    RecipeHubTheme {
        Greeting("Android")
    }
}