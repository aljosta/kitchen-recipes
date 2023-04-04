package com.example.recipedetail.data.models

data class RecipeDetailEntity(
    val id: String? = null,
    val title: String? = null,
    val thumbnail: String? = null,
    val description: String? = null,
    val preparation: String? = null,
    val ingredients: String? = null,
    val location: List<Double>? = null,
)
