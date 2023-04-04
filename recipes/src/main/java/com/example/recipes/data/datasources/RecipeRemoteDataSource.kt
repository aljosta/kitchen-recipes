package com.example.recipes.data.datasources

import com.example.recipes.data.models.RecipeListResponse
import retrofit2.Response
import retrofit2.http.GET

interface RecipeRemoteDataSource {
    @GET("recipes")
    suspend fun getRecipeList(): Response<RecipeListResponse>
}
