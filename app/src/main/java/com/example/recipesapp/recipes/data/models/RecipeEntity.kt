package com.example.recipesapp.recipes.data.models

data class RecipeEntity(
    val id: String? = null,
    val title: String? = null,
    val thumbnail: String? = null,
    val description: String? = null,
    val preparation: String? = null,
    val ingredients: String? = null,
    val location: List<Double>? = null,
)
