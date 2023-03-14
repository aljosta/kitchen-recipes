package com.example.recipesapp.home.data.datasources

import com.example.recipesapp.home.data.models.RecipeEntity
import com.example.recipesapp.home.data.models.RecipeListResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface RecipeRemoteDataSource {
    @GET("recipes")
    suspend fun getRecipeList(
        @Query("offset") offset: Int? = null,
        @Query("limit") limit: Int? = null,
    ): RecipeListResponse

    @GET("recipes/{recipeId}")
    suspend fun getRecipeById(@Path("recipeId") recipeId: String): RecipeEntity
}
