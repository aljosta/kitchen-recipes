package com.example.recipedetail.data.repositories

import com.example.recipedetail.data.datasources.RecipeDetailRemoteDataSource
import com.example.recipedetail.data.models.RecipeDetailEntity
import com.example.recipedetail.domain.RecipeDetailRepository
import javax.inject.Inject

class RecipeDetailDataRepository @Inject constructor(
    private val recipeDetailRemoteDataSource: RecipeDetailRemoteDataSource,
) : RecipeDetailRepository {
    override suspend fun getRecipeDetail(recipeId: String): RecipeDetailEntity {
        val response = recipeDetailRemoteDataSource.getRecipeById(recipeId)
        if (!response.isSuccessful) {
            throw Exception(response.message())
        }
        return response.body() ?: throw Exception(response.message())
    }
}