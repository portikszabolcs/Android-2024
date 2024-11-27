package com.example.recipehub.ui.recipe

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.recipehub.App
import com.example.recipehub.R
import com.example.recipehub.repository.recipe.model.RecipeModel
import com.example.recipehub.ui.recipe.adapter.RecipesListAdapter
import com.example.recipehub.ui.recipe.factory.RecipeListFactory
import com.example.recipehub.ui.recipe.viewmodel.RecipeListViewModel

class RecipesFragment: Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val myApp = this.activity?.application as App
        val factory = RecipeListFactory(myApp.repository)
        val viewModel = ViewModelProvider(this, factory)[RecipeListViewModel::class.java]
        viewModel.loadRecipeDataFromApi()

        viewModel.recipeModels.observe(viewLifecycleOwner) {recipes ->
            val recipeAdapter = context?.let { RecipesListAdapter(recipes, it, ::navigateToRecipeDetail) }
            val recyclerView : RecyclerView? = container?.findViewById(R.id.recipeListRecycleView)
            val layoutManager = LinearLayoutManager(context)
            recyclerView?.layoutManager = layoutManager
            recyclerView?.addItemDecoration(DividerItemDecoration(context, layoutManager.orientation))
            recyclerView?.adapter = recipeAdapter
        }
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_recipes, container, false)
    }

    private fun navigateToRecipeDetail(recipe: RecipeModel) {
        Log.d("REC", recipe.toString())
        findNavController().navigate(
            R.id.action_recipesFragment_to_recipeDetailFragment,
            bundleOf("recipeId" to recipe.id)
        )
    }
}