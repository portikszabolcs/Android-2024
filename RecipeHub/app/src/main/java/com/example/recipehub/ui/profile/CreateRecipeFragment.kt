package com.example.recipehub.ui.profile

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.recipehub.App
import com.example.recipehub.database.recipe.RecipeEntity
import com.example.recipehub.databinding.FragmentCreateRecipeBinding
import com.example.recipehub.repository.recipe.model.NutritionModel
import com.example.recipehub.repository.recipe.model.RecipeModel
import com.example.recipehub.ui.profile.factory.MyRecipeListFactory
import com.example.recipehub.ui.profile.viewmodel.MyRecipeListViewModel
import com.google.gson.Gson

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
        binding.nutritionCheckBox.setOnCheckedChangeListener{ _, isChecked ->
            if (isChecked) binding.nutritionInputList.visibility = View.VISIBLE
            else binding.nutritionInputList.visibility = View.GONE
        }
        binding.saveButton.setOnClickListener {
            if(binding.recipeTitle.text == null || binding.recipeTitle.text!!.isEmpty()) {
                binding.recipeTitle.error = "This field is required!"
                return@setOnClickListener
            }
            var nutrition: NutritionModel? = null
            val list = arrayOf(binding.recipeCalories.text.toString().toIntOrNull(),
                binding.recipeProtein.text.toString().toIntOrNull(),
                binding.recipeFat.text.toString().toIntOrNull(),
                binding.recipeCarbohydrates.text.toString().toIntOrNull(),
                binding.recipeSugar.text.toString().toIntOrNull(),
                binding.recipeFiber.text.toString().toIntOrNull())

            if (list.all { it != null }) nutrition = NutritionModel(list[0]!!, list[1]!!, list[2]!!, list[3]!!, list[4]!!, list[5]!!)
            val recipeModel = RecipeModel(
                1,
                binding.recipeTitle.text.toString(),
                binding.recipeDescription.text.toString(),
                binding.recipeImageUrl.text.toString(),
                binding.recipeKeywords.text.toString(),
                components = emptyList(),
                instructions = emptyList(),
                nutrition = nutrition
            )
            val recipe = RecipeEntity(json=Gson().toJson(recipeModel))
            viewModel.insertRecipe(recipe)
            findNavController().popBackStack()
        }
    }
}