package com.example.recipedetail.domain.usescases

import com.example.recipedetail.domain.RecipeDetailRepository
import com.example.recipedetail.domain.mapper.RecipeDetailDataToDtoMapper
import com.example.recipedetail.domain.models.RecipeDetailDto
import javax.inject.Inject

class GetRecipeDetailUseCase @Inject constructor(
    private val repository: RecipeDetailRepository,
) {
    suspend fun execute(recipeId: String): RecipeDetailDto =
        RecipeDetailDataToDtoMapper.transform(repository.getRecipeDetail(recipeId))
}
