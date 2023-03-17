package com.example.recipesapp.recipes.data.repositories

import com.example.recipesapp.recipes.data.datasources.RecipeRemoteDataSource
import com.example.recipesapp.recipes.data.models.RecipeEntity
import com.example.recipesapp.recipes.domain.RecipeRepository
import javax.inject.Inject

class RecipeDataRepository @Inject constructor(
    private val productRemoteDataSource: RecipeRemoteDataSource,
) : RecipeRepository {

    override suspend fun getRecipeList(): List<RecipeEntity> {
        val response = productRemoteDataSource.getRecipeList()
        if (!response.isSuccessful) {
            throw Exception(response.message())
        }
        return response.body()?.results ?: throw Exception(response.message())
    }

    override suspend fun getRecipeDetail(recipeId: String): RecipeEntity {
        val response = productRemoteDataSource.getRecipeById(recipeId)
        if (!response.isSuccessful) {
            throw Exception(response.message())
        }
        return response.body() ?: throw Exception(response.message())
    }
}
