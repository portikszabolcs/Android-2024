package com.example.recipehub.repository.recipe.model

data class ComponentDTO(
    val rawText: String,
    val extraComment: String,
    val ingredient: IngredientDTO,
    val measurement: MeasurementDTO,
    val position: Int,
)

fun ComponentDTO.toModel(): ComponentModel
{ return ComponentModel(
    rawText = this.rawText,
    ingredient = this.ingredient.toModel(),
    measurement = this.measurement.toModel()) }

fun List<ComponentDTO>.toModelList(): List<ComponentModel>
{ return this.map { it.toModel() } }

data class IngredientDTO(
    val name: String,
)

fun IngredientDTO.toModel(): IngredientModel{
    return IngredientModel(
        name = this.name
    )
}

data class MeasurementDTO(
    val quantity: String,
    val unit: UnitDTO,
)

fun MeasurementDTO.toModel(): MeasurementModel{
    return MeasurementModel(
        quantity = this.quantity,
        unit = this.unit.toModel()
    )
}

data class UnitDTO(
    val name: String,
    val displaySingular: String?,
    val displayPlural: String?,
    val abbreviation: String?,
)

fun UnitDTO.toModel(): UnitModel{
    return UnitModel(
        name = this.name,
        displaySingular = this.displaySingular,
        displayPlural = this.displayPlural,
        abbreviation = this.abbreviation
    )
}
