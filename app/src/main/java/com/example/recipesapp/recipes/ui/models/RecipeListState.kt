package com.example.recipesapp.recipes.ui.models

sealed class RecipeListState {
    data class Success(val data: List<RecipeModel>) : RecipeListState()
    data class Error(var exception: Throwable) : RecipeListState()
    object Loading : RecipeListState()
}
