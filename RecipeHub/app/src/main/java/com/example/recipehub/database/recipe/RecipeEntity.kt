package com.example.recipehub.database.recipe

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "recipe")
data class RecipeEntity(
    @PrimaryKey(autoGenerate = true)
    val internalId: Int = 0,
    @SerializedName("json_data")
    val json: String
)
