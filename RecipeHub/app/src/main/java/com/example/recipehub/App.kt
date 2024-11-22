package com.example.recipehub

import android.app.Application
import androidx.room.Room
import com.example.recipehub.database.recipe.RecipeDatabase
import com.example.recipehub.repository.recipe.RecipeRepository

class App: Application() {
    lateinit var repository: RecipeRepository

    override fun onCreate() {
        super.onCreate()
        val recipeDatabase = Room.databaseBuilder(this, RecipeDatabase::class.java, "recipe_database").build()
        repository = RecipeRepository(recipeDatabase.recipeDao())
    }
}