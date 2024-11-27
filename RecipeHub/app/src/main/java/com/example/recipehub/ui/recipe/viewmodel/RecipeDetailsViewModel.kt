package com.example.recipehub.ui.recipe.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.recipehub.repository.recipe.RecipeRepository
import com.example.recipehub.repository.recipe.model.RecipeModel
import kotlinx.coroutines.launch

class RecipeDetailsViewModel(val repository: RecipeRepository): ViewModel() {
    private val _recipeModel = MutableLiveData<RecipeModel?>()
    val recipeModel: LiveData<RecipeModel?> = _recipeModel

    fun loadRecipeData(id: Int) {
        _recipeModel.value = repository.getById(id)
    }

    fun loadMyRecipeData(id: Int) {
        viewModelScope.launch {
            _recipeModel.value = repository.getMyRecipeById(id)
        }
    }

    fun loadRecipeDataFromApi(id: Int) {
        viewModelScope.launch {
            _recipeModel.value = repository.getRecipeByIdFromApi(id)
        }
    }
}
