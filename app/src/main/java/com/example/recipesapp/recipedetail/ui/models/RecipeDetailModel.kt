package com.example.recipesapp.recipedetail.ui.models

data class RecipeDetailModel(
    val id: String,
    val title: String,
    val thumbnail: String,
    val description: String,
    val preparation: String,
    val ingredients: String,
    val location: List<Double>,
)
