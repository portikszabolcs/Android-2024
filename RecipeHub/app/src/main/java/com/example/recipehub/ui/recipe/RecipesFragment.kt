package com.example.recipehub.ui.recipe

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.recipehub.R
import com.example.recipehub.ui.recipe.viewmodel.RecipeListViewModel

class RecipesFragment: Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val viewModel = ViewModelProvider(this)[RecipeListViewModel::class.java]
        context?.let {
            viewModel.loadRecipeData(it)
        }

        viewModel.recipeModels.observe(viewLifecycleOwner) {recipes ->
            for(recipe in recipes) {
                Log.d("REC", recipe.toString())
            }
        }
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_recipes, container, false)
    }
}