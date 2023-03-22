package com.example.recipedetail.usescases

import com.example.recipes.domain.RecipeRepository
import com.example.recipes.domain.mapper.RecipeDataToDtoMapper
import com.example.recipes.domain.models.RecipeDto
import javax.inject.Inject

class GetRecipeDetailUseCase @Inject constructor(
    private val repository: RecipeRepository,
) {
    suspend fun execute(recipeId: String): RecipeDto =
        RecipeDataToDtoMapper.transform(repository.getRecipeDetail(recipeId))
}
