package com.example.recipehub.ui.profile.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.recipehub.database.recipe.RecipeEntity
import com.example.recipehub.repository.recipe.RecipeRepository
import com.example.recipehub.repository.recipe.model.RecipeModel
import kotlinx.coroutines.launch

class MyRecipeListViewModel(val repository: RecipeRepository): ViewModel() {
    private val _recipeModels = MutableLiveData<List<RecipeModel>>()
    val recipeModels: LiveData<List<RecipeModel>> =
        _recipeModels

    fun loadRecipeData() {
        viewModelScope.launch {
            _recipeModels.value = repository.getAllMyRecipes()
        }
    }

    fun insertRecipe(recipe: RecipeEntity) {
        viewModelScope.launch {
            repository.insertRecipe(recipe)
        }
    }

    fun deleteRecipeById(recipeId: Int) {
        viewModelScope.launch {
            repository.deleteRecipeById(recipeId)
            loadRecipeData()
        }
    }
}