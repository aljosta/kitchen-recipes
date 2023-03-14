package com.example.recipesapp.recipedetail.domain.usescases

import com.example.recipesapp.home.domain.RecipeRepository
import com.example.recipesapp.home.domain.mapper.RecipeDataToDtoMapper
import com.example.recipesapp.home.domain.models.RecipeDto
import javax.inject.Inject

class GetRecipeDetailUseCase @Inject constructor(
    private val repository: RecipeRepository,
) {
    suspend fun execute(recipeId: String): RecipeDto =
        RecipeDataToDtoMapper.transform(repository.getRecipeDetail(recipeId))
}
