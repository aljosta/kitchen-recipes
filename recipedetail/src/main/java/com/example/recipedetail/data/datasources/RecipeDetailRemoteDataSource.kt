package com.example.recipedetail.data.datasources

import com.example.recipedetail.data.models.RecipeDetailEntity
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface RecipeDetailRemoteDataSource {
    @GET("recipes/{recipeId}")
    suspend fun getRecipeById(@Path("recipeId") recipeId: String): Response<RecipeDetailEntity>
}