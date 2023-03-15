package com.example.recipesapp.recipedetail.ui.models

import com.example.recipesapp.recipes.ui.models.RecipeModel

sealed class RecipeDetailState {
    data class Success(val data: RecipeModel) : RecipeDetailState()
    data class Error(var exception: Throwable) : RecipeDetailState()
    object Loading : RecipeDetailState()
}