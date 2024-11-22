package com.example.recipehub.ui.profile.factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.recipehub.repository.recipe.RecipeRepository
import com.example.recipehub.ui.profile.viewmodel.MyRecipeListViewModel

class MyRecipeListFactory(private val repository: RecipeRepository): ViewModelProvider.Factory {
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MyRecipeListViewModel::class.java)) {
            return MyRecipeListViewModel(repository) as T
        }
        return super.create(modelClass)
    }
}