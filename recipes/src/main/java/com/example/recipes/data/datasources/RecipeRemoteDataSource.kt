package com.example.recipes.data.datasources

import com.example.recipes.data.models.RecipeEntity
import com.example.recipes.data.models.RecipeListResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface RecipeRemoteDataSource {
    @GET("recipes")
    suspend fun getRecipeList(): Response<RecipeListResponse>

    @GET("recipes/{recipeId}")
    suspend fun getRecipeById(@Path("recipeId") recipeId: String): Response<RecipeEntity>
}
