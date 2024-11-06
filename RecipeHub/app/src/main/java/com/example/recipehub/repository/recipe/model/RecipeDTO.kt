package com.example.recipehub.repository.recipe.model

data class RecipeDTO(
    val recipeId: Int,
    val name: String,
    val description: String,
    val thumbnailUrl: String,
    val keywords: String,
    val isPublic: Boolean,
    val userEmail: String,
    val originalVideoUrl: String,
    val country: String,
    val numServings: Long,
    val components: List<ComponentDTO>,
    val instructions: List<InstructionDTO>,
)

fun RecipeDTO.toModel(): RecipeModel
{ return RecipeModel(
    id = this.recipeId,
    name = this.name,
    description = this.description,
    thumbnailUrl = this.thumbnailUrl,
    keywords = this.keywords,
    components = this.components.toModelList(),
    instructions = this.instructions.toModelList()) }

fun List<RecipeDTO>.toModelList(): List<RecipeModel>
{ return this.map { it.toModel() } }
