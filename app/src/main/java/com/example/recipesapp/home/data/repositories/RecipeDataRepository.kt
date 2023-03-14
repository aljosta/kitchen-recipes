package com.example.recipesapp.home.data.repositories

import com.example.recipesapp.home.data.datasources.RecipeRemoteDataSource
import com.example.recipesapp.home.data.models.RecipeEntity
import com.example.recipesapp.home.domain.RecipeRepository
import javax.inject.Inject

class RecipeDataRepository @Inject constructor(
    private val productRemoteDataSource: RecipeRemoteDataSource,
) : RecipeRepository {
    override suspend fun getRecipeList(): List<RecipeEntity> =
        productRemoteDataSource.getRecipeList().results

    override suspend fun getRecipeDetail(recipeId: String): RecipeEntity =
        productRemoteDataSource.getRecipeById(recipeId)
}
