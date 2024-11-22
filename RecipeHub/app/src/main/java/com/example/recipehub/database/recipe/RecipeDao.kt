package com.example.recipehub.database.recipe

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface RecipeDao {
    @Insert
    suspend fun insertRecipe(recipe: RecipeEntity)
    @Query("SELECT * FROM recipe WHERE internalId = :id")
    suspend fun getRecipeById(id: Int): RecipeEntity?
    @Query("SELECT * FROM recipe")
    suspend fun getAllRecipes(): List<RecipeEntity>
    @Query("DELETE FROM recipe WHERE internalId = :recipeId")
    suspend fun deleteRecipeById(recipeId: Int)
    @Delete
    suspend fun deleteRecipe(recipe: RecipeEntity)
}