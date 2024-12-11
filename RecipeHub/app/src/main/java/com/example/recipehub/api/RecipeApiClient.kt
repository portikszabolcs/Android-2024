package com.example.recipehub.api

import android.util.Log
import com.example.recipehub.repository.recipe.model.RecipeDTO
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import okhttp3.OkHttpClient
import org.json.JSONObject
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RecipeApiClient {
    companion object {
        private const val BASE_URL =
            "https://recipe-appservice-cthjbdfafnhfdtes.germanywestcentral-01.azurewebsites.net/"
        private const val TOKEN =
            "eyJhbGciOiJSUzI1NiIsImtpZCI6IjM2MjgyNTg2MDExMTNlNjU3NmE0NTMzNzM2NWZlOGI4OTczZDE2NzEiLCJ0eXAiOiJKV1QifQ.eyJpc3MiOiJodHRwczovL2FjY291bnRzLmdvb2dsZS5jb20iLCJhenAiOiIxNjI1ODkxMzM3NDgtcWpndWZzNnJ2NDRmY3J0NHE4ZHN0cmU2djFlbG80Y3MuYXBwcy5nb29nbGV1c2VyY29udGVudC5jb20iLCJhdWQiOiIxNjI1ODkxMzM3NDgtcWpndWZzNnJ2NDRmY3J0NHE4ZHN0cmU2djFlbG80Y3MuYXBwcy5nb29nbGV1c2VyY29udGVudC5jb20iLCJzdWIiOiIxMDc2MDMyNjMxNjUxNDQxMDU5OTEiLCJlbWFpbCI6InBvcnRpay5zemFib2xjcy4wMkBnbWFpbC5jb20iLCJlbWFpbF92ZXJpZmllZCI6dHJ1ZSwiYXRfaGFzaCI6InRoYkNXMU9ZVmY4SzJlTzA2NEE3U2ciLCJuYW1lIjoiUG9ydGlrIFN6YWJvbGNzIiwicGljdHVyZSI6Imh0dHBzOi8vbGgzLmdvb2dsZXVzZXJjb250ZW50LmNvbS9hL0FDZzhvY0szSmhzSVl6M1dfNERKQWRmMjYyOWtFb3ItMW9hRkszY0p5SlR0RlRBZ08wRHlvRUNWPXM5Ni1jIiwiZ2l2ZW5fbmFtZSI6IlBvcnRpayIsImZhbWlseV9uYW1lIjoiU3phYm9sY3MiLCJpYXQiOjE3MzI3MTg3MzgsImV4cCI6MTczMjcyMjMzOH0.RfwCIP7WOZcVK0xsnyzT3fwXZX4WWqhDhzVh12r8i9LUVcQ2nLNiOjglRsqW87erLFRVptd87fJT5fI66qBWWzjGyaU5ZdLnW0e5ffTv2G5pkw4qicUKQF_eIhjKx20cP57HXU7xVPpoeS7IZg2FLACSUc-n7l-JkXKqV3vqPI1qk8nCwMbFLffUivlP1w19ew-CqwTTYqszvK7VWOyW4aZ8DN-ayxltBlvnWTjIo8pQE8e-KN8RD-kwlaosjmD1l2s-8B6leePDjskFJ6yRwIvlfxXMiSrDxaoJpGlCy0IAXRQBxvvo0h3SEp-ED7yHPUhY6jTvTwAuxnYREMiGTg"
    }

    private val okHttpClient = OkHttpClient.Builder()
        .addInterceptor(AuthInterceptor(TOKEN))
        .build()
    private val recipeService: RecipeApiService

    init {
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient)
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

    fun getUserData(): JSONObject {
        val tokenPayload = TOKEN.split(".")[1]
        val decodedPayload = String(android.util.Base64.decode(tokenPayload, android.util.Base64.URL_SAFE))
        return JSONObject(decodedPayload)
    }
}