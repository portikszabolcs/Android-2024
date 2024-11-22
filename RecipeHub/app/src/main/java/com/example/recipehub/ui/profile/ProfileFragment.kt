package com.example.recipehub.ui.profile

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
import com.example.recipehub.databinding.FragmentProfileBinding
import com.example.recipehub.repository.recipe.model.RecipeModel
import com.example.recipehub.ui.profile.factory.MyRecipeListFactory
import com.example.recipehub.ui.profile.viewmodel.MyRecipeListViewModel
import com.example.recipehub.ui.recipe.adapter.RecipesListAdapter

class ProfileFragment : Fragment() {
    private lateinit var binding: FragmentProfileBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentProfileBinding.inflate(inflater, container, false)
        val myApp = this.activity?.application as App
        val factory = MyRecipeListFactory(myApp.repository)
        val viewModel = ViewModelProvider(this, factory)[MyRecipeListViewModel::class.java]
        context?.let {
            viewModel.loadRecipeData(it)
        }

        viewModel.recipeModels.observe(viewLifecycleOwner) {recipes ->
            val recipeAdapter = context?.let { RecipesListAdapter(recipes, it, ::navigateToRecipeDetail) }
            val recyclerView : RecyclerView = binding.recyclerView
            val layoutManager = LinearLayoutManager(context)
            recyclerView.layoutManager = layoutManager
            recyclerView.adapter = recipeAdapter
            recyclerView.addItemDecoration(DividerItemDecoration(context, layoutManager.orientation))
        }

        // Inflate the layout for this fragment
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.floatingAddButton.setOnClickListener {
            findNavController().navigate(R.id.action_profileFragment_to_createRecipeFragment)
        }
    }

    private fun navigateToRecipeDetail(recipe: RecipeModel) {
        Log.d("REC", recipe.toString())
        findNavController().navigate(
            R.id.action_profileFragment_to_recipeDetailFragment,
            bundleOf("myRecipeId" to recipe.id)
        )
    }
}