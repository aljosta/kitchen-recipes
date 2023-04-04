package com.example.recipes.domain

import com.example.recipes.data.models.RecipeEntity

interface RecipeRepository {
    suspend fun getRecipeList(): List<RecipeEntity>
}