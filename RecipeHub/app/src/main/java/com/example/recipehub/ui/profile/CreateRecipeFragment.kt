package com.example.recipehub.ui.profile

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.recipehub.App
import com.example.recipehub.R
import com.example.recipehub.databinding.FragmentCreateRecipeBinding
import com.example.recipehub.repository.recipe.model.RecipeModel
import com.example.recipehub.ui.profile.factory.MyRecipeListFactory
import com.example.recipehub.ui.profile.viewmodel.MyRecipeListViewModel

class CreateRecipeFragment : Fragment() {
    private lateinit var binding: FragmentCreateRecipeBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentCreateRecipeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val myApp = this.activity?.application as App
        val viewModel: MyRecipeListViewModel by activityViewModels(factoryProducer = {
             MyRecipeListFactory(myApp.repository)
        })
        binding.saveButton.setOnClickListener {
            viewModel.insertRecipe(
                binding.recipeTitle.text.toString(),
                binding.recipeDescription.text.toString(),
                binding.recipeImageUrl.text.toString(),
                binding.recipeKeywords.text.toString(),
                components = emptyList(),
                instructions = emptyList())
            findNavController().popBackStack()
        }
    }
}