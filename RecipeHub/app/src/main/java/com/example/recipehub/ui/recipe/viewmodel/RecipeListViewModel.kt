package com.example.recipehub.ui.recipe.viewmodel

import android.content.Context
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.recipehub.repository.recipe.RecipeRepository
import com.example.recipehub.repository.recipe.model.RecipeModel
import kotlinx.coroutines.launch

class RecipeListViewModel(val repository: RecipeRepository) : ViewModel() {
    private val _recipeModels = MutableLiveData<List<RecipeModel>>()
    val recipeModels: LiveData<List<RecipeModel>> =
        _recipeModels

    fun loadRecipeData(context: Context) {
        _recipeModels.value = repository.getAll(context)
    }

    fun loadRecipeDataFromApi() {
        viewModelScope.launch {
            val recipes = repository.getAllFromApi()
            recipes.forEach {
                Log.d("RECIPE_API", it.toString())
            }
            _recipeModels.value = recipes
        }
    }
}