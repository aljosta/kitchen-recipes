package com.example.recipes.data.repositories

import com.example.recipes.data.datasources.RecipeRemoteDataSource
import com.example.recipes.data.models.RecipeEntity
import com.example.recipes.domain.RecipeRepository
import javax.inject.Inject

class RecipeDataRepository @Inject constructor(
    private val recipeRemoteDataSource: RecipeRemoteDataSource,
) : RecipeRepository {

    override suspend fun getRecipeList(): List<RecipeEntity> {
        val response = recipeRemoteDataSource.getRecipeList()
        if (!response.isSuccessful) {
            throw Exception(response.message())
        }
        return response.body()?.results ?: throw Exception(response.message())
    }
}
