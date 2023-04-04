package com.example.recipedetail.domain.models

data class RecipeDetailDto(
    val id: String,
    val title: String,
    val thumbnail: String,
    val description: String,
    val preparation: String,
    val ingredients: String,
    val location: List<Double>,
)