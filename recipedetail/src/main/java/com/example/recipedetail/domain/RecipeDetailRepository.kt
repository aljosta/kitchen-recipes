package com.example.recipedetail.domain

import com.example.recipedetail.data.models.RecipeDetailEntity

interface RecipeDetailRepository {
    suspend fun getRecipeDetail(recipeId: String): RecipeDetailEntity
}