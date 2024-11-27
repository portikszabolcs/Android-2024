package com.example.recipehub.api

import android.util.Log
import com.example.recipehub.repository.recipe.model.RecipeDTO
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RecipeApiClient {
    companion object {
        private const val BASE_URL =
            "https://recipe-appservice-cthjbdfafnhfdtes.germanywestcentral-01.azurewebsites.net/"
    }
    private val recipeService: RecipeApiService
    init {
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        recipeService = retrofit.create(RecipeApiService::class.java)
    }

    suspend fun getRecipes(): List<RecipeDTO>? {
        return withContext(Dispatchers.IO) {
            try {
                recipeService.getRecipes()
            } catch (e: Exception) {
                Log.d("REC", e.toString())
                null
            }
        }
    }

    suspend fun getRecipeById(id: Int): RecipeDTO? {
        return withContext(Dispatchers.IO) {
            try {
                recipeService.getRecipeById(id.toString())
            } catch (e: Exception) {
                Log.d("REC", e.toString())
                null
            }
        }
    }
}