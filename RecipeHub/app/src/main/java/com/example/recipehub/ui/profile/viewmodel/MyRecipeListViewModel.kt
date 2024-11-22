package com.example.recipehub.ui.profile.viewmodel

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.recipehub.repository.recipe.RecipeRepository
import com.example.recipehub.repository.recipe.model.ComponentModel
import com.example.recipehub.repository.recipe.model.InstructionModel
import com.example.recipehub.repository.recipe.model.RecipeModel

class MyRecipeListViewModel(val repository: RecipeRepository): ViewModel() {
    private val _recipeModels = MutableLiveData<List<RecipeModel>>()
    val recipeModels: LiveData<List<RecipeModel>> =
        _recipeModels

    fun loadRecipeData(context: Context) {
        _recipeModels.value = repository.getAllMyRecipes(context)
    }

    fun insertRecipe(name: String,
                     description: String,
                     thumbnailUrl: String,
                     keywords: String,
                     components: List<ComponentModel>,
                     instructions: List<InstructionModel>) {
        repository.insertRecipe(name, description, thumbnailUrl, keywords, components, instructions)
    }
}