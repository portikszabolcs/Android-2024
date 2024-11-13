package com.example.recipehub

import android.app.Application
import com.example.recipehub.repository.recipe.RecipeRepository

class App: Application() {
    val repository: RecipeRepository by lazy { RecipeRepository() }
}