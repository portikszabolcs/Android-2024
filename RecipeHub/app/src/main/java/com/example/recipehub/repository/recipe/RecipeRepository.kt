package com.example.recipehub.repository.recipe

import android.content.Context
import com.example.recipehub.database.recipe.RecipeDao
import com.example.recipehub.database.recipe.RecipeEntity
import com.example.recipehub.repository.recipe.model.RecipeDTO
import com.example.recipehub.repository.recipe.model.RecipeModel
import com.example.recipehub.repository.recipe.model.toModel
import com.example.recipehub.repository.recipe.model.toModelList
import com.google.firebase.crashlytics.buildtools.reloc.com.google.common.reflect.TypeToken
import com.google.gson.Gson
import org.json.JSONObject
import java.io.IOException

class RecipeRepository(private val recipeDao: RecipeDao) {
    private var recipeList: List<RecipeModel> = emptyList()
    private val gson = Gson()

    fun getAll(context: Context): List<RecipeModel> {
        recipeList = readAll(context).toModelList()
        return recipeList
    }

    suspend fun getAllMyRecipes(): List<RecipeModel> {
        return recipeDao.getAllRecipes().map {
            val jsonObject = JSONObject(it.json)
            jsonObject.apply { put("recipeID", it.internalId) }
            gson.fromJson(jsonObject.toString(), RecipeDTO::class.java).toModel()
        }
    }

    fun getById(id: Int): RecipeModel? {
        return recipeList.find { it.id == id }
    }

    suspend fun getMyRecipeById(id: Int): RecipeModel? {
        val entity = recipeDao.getRecipeById(id) ?: return null
        val jsonObject = JSONObject(entity.json)
        jsonObject.apply { put("id", entity.internalId) }
        return gson.fromJson(jsonObject.toString(), RecipeDTO::class.java).toModel()
    }

    suspend fun insertRecipe(recipe: RecipeEntity) {
        recipeDao.insertRecipe(recipe)
    }

    suspend fun deleteRecipeById(recipeId: Int) {
        recipeDao.deleteRecipeById(recipeId)
    }

    private fun readAll(context : Context): List<RecipeDTO> {
        var recipeList = listOf<RecipeDTO>()
        val assetManager = context.assets
        try {
            val inputStream = assetManager.open("more_recipes.json")
            val size = inputStream.available()
            val buffer = ByteArray(size)
            inputStream.read(buffer)
            inputStream.close()
            val jsonString = String(buffer, Charsets.UTF_8)
            val type = object : TypeToken<List<RecipeDTO>>() {}.type
            recipeList = gson.fromJson<List<RecipeDTO>>(jsonString, type)
        } catch (e: IOException) {
            e.printStackTrace()
        }
        return recipeList
    }
}