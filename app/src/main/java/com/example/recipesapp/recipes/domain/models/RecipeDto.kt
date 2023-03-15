package com.example.recipesapp.recipes.domain.models

data class RecipeDto(
    val id: String,
    val title: String,
    val thumbnail: String,
    val description: String,
    val preparation: String,
    val ingredients: String,
    val location: List<Double>,
)
