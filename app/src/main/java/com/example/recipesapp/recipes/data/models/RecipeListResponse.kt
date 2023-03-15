package com.example.recipesapp.recipes.data.models

data class RecipeListResponse(
    val results: ArrayList<RecipeEntity> = arrayListOf(),
)
