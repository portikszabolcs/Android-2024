package com.example.recipehub.ui.recipe.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.recipehub.repository.recipe.RecipeRepository
import com.example.recipehub.repository.recipe.model.RecipeModel

class RecipeDetailsViewModel(val repository: RecipeRepository): ViewModel() {
    private val _recipeModel = MutableLiveData<RecipeModel?>()
    val recipeModel: LiveData<RecipeModel?> = _recipeModel

    fun loadRecipeData(id: Int) {
        Log.d("REC", id.toString())
        _recipeModel.value = repository.getById(id)
    }
}
