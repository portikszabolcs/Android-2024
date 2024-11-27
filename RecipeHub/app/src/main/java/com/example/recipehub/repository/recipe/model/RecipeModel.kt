package com.example.recipehub.repository.recipe.model

data class RecipeModel(
    val id: Int,
    val name: String,
    val description: String,
    val thumbnailUrl: String? = "",
    val keywords: String? = "",
    val components: List<ComponentModel>,
    val instructions: List<InstructionModel>,
    val nutrition: NutritionModel?,
)
