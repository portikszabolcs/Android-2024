package com.example.recipehub.ui.recipe.viewmodel

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.recipehub.repository.recipe.RecipeRepository
import com.example.recipehub.repository.recipe.model.RecipeModel

class RecipeListViewModel() : ViewModel() {
    private val _recipeModels = MutableLiveData<List<RecipeModel>>()
    val recipeModels: LiveData<List<RecipeModel>> =
        _recipeModels

    fun loadRecipeData(context: Context) {
        val repo = RecipeRepository()
        _recipeModels.value = repo.getAll(context)
    }
}