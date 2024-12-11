package com.example.recipehub.repository.recipe.model

data class ComponentModel(
    val rawText: String,
    val ingredient: IngredientModel,
    val measurement: MeasurementModel
)

data class IngredientModel(
    val name: String,
)

data class MeasurementModel(
    val quantity: String,
    val unit: UnitModel,
)

data class UnitModel(
    val name: String,
    val displaySingular: String?,
    val displayPlural: String?,
    val abbreviation: String?,
)
