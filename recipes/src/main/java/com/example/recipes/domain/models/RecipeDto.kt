package com.example.recipes.domain.models

data class RecipeDto(
    val id: String,
    val title: String,
    val thumbnail: String,
    val ingredients: String,
)
