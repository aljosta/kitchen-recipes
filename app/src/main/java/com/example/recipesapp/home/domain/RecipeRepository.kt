package com.example.recipesapp.home.domain

import com.example.recipesapp.home.data.models.RecipeEntity

interface RecipeRepository {
    suspend fun getRecipeList(): List<RecipeEntity>
    suspend fun getRecipeDetail(recipeId: String): RecipeEntity
}