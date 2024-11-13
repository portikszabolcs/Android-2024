package com.example.recipehub.ui.recipe.factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.recipehub.repository.recipe.RecipeRepository
import com.example.recipehub.ui.recipe.viewmodel.RecipeDetailsViewModel

class RecipeDetailsFactory(private val repository: RecipeRepository) : ViewModelProvider.Factory {
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(RecipeDetailsViewModel::class.java)) {
            return RecipeDetailsViewModel(repository) as T
        }
        return super.create(modelClass)
    }

}