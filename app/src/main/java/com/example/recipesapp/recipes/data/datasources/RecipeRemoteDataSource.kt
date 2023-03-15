package com.example.recipesapp.recipes.data.datasources

import com.example.recipesapp.recipes.data.models.RecipeEntity
import com.example.recipesapp.recipes.data.models.RecipeListResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface RecipeRemoteDataSource {
    @GET("recipes")
    suspend fun getRecipeList(): Response<RecipeListResponse>

    @GET("recipes/{recipeId}")
    suspend fun getRecipeById(@Path("recipeId") recipeId: String): Response<RecipeEntity>
}
