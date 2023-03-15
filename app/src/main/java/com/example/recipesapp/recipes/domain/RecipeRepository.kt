package com.example.recipesapp.recipes.domain

import com.example.recipesapp.recipes.data.models.RecipeEntity

interface RecipeRepository {
    suspend fun getRecipeList(): List<RecipeEntity>
    suspend fun getRecipeDetail(recipeId: String): RecipeEntity
}