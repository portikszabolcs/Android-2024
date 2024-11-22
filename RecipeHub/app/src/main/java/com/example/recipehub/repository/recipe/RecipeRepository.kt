package com.example.recipehub.repository.recipe

import android.content.Context
import android.util.Log
import com.example.recipehub.repository.recipe.model.ComponentModel
import com.example.recipehub.repository.recipe.model.InstructionModel
import com.example.recipehub.repository.recipe.model.RecipeDTO
import com.example.recipehub.repository.recipe.model.RecipeModel
import com.example.recipehub.repository.recipe.model.toModelList
import com.google.firebase.crashlytics.buildtools.reloc.com.google.common.reflect.TypeToken
import com.google.gson.Gson
import java.io.IOException

class RecipeRepository {
    private var recipeList: List<RecipeModel> = emptyList()
    private var myRecipeList: ArrayList<RecipeModel> = ArrayList()

    fun getAll(context: Context): List<RecipeModel> {
        recipeList = readAll(context).toModelList()
        return recipeList
    }

    fun getAllMyRecipes(context: Context): List<RecipeModel> {
        return myRecipeList
    }

    fun getById(id: Int): RecipeModel? {
        return recipeList.find { it.id == id }
    }

    fun getMyRecipeById(id: Int): RecipeModel? {
        return myRecipeList.find { it.id == id }
    }

    fun insertRecipe(name: String,
                     description: String,
                     thumbnailUrl: String,
                     keywords: String,
                     components: List<ComponentModel>,
                     instructions: List<InstructionModel>) {
        val id = myRecipeList.maxOfOrNull { it.id }
        myRecipeList.add(RecipeModel((id?.plus(1)) ?: 1, name, description, thumbnailUrl, keywords, components, instructions))
    }

    fun deleteRecipe(recipe: RecipeModel) {
        myRecipeList.remove(recipe)
    }

    private fun readAll(context : Context): List<RecipeDTO> {
        val gson = Gson()
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
            Log.i("GSON", recipeList.toString())
        } catch (e: IOException) {
            e.printStackTrace()
        }
        return recipeList
    }
}