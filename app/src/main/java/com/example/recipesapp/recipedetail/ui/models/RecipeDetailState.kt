package com.example.recipesapp.recipedetail.ui.models

sealed class RecipeDetailState {
    data class Success(val data: RecipeDetailModel) : RecipeDetailState()
    data class Error(var exception: Throwable) : RecipeDetailState()
    object Loading : RecipeDetailState()
}