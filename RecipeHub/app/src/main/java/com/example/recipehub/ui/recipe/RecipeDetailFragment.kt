package com.example.recipehub.ui.recipe

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.ViewGroup.MarginLayoutParams
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.example.recipehub.App
import com.example.recipehub.R
import com.example.recipehub.databinding.FragmentRecipeDetailBinding
import com.example.recipehub.ui.recipe.factory.RecipeDetailsFactory
import com.example.recipehub.ui.recipe.viewmodel.RecipeDetailsViewModel
import com.google.android.material.chip.Chip

class RecipeDetailFragment : Fragment() {
    private var recipeId: Int = 0
    private var myRecipeId: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            recipeId = it.getInt("recipeId")
            myRecipeId = it.getInt("myRecipeId")
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val myApp = this.activity?.application as App
        val factory = RecipeDetailsFactory(myApp.repository)
        val viewModel = ViewModelProvider(this, factory)[RecipeDetailsViewModel::class]
        if(recipeId > 0) viewModel.loadRecipeData(recipeId)
        else viewModel.loadMyRecipeData(myRecipeId)

        val binding = FragmentRecipeDetailBinding.inflate(inflater)
        viewModel.recipeModel.observe(viewLifecycleOwner) {
            Glide.with(this)
                .load(it?.thumbnailUrl)
                .fallback(R.drawable.pexels_goumbik_616401)
                .error(R.drawable.pexels_goumbik_616401)
                .into(binding.image)
            binding.title.text = it?.name
            binding.description.text = it?.description

            val keywords = it?.keywords?.split(", ")
            val mlp = MarginLayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT)
            mlp.setMargins(16, 0, 0, 0)
            keywords?.forEach { keyword ->
                val chip = Chip(context)
                chip.text = keyword
                chip.layoutParams = mlp
                binding.keywordsContainer.addView(chip)
            }
        }
        // Inflate the layout for this fragment
        return binding.root
    }
}