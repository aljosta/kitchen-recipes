package com.example.recipesapp.home.domain.usecases

import com.example.recipesapp.home.domain.RecipeRepository
import com.example.recipesapp.home.domain.mapper.RecipeDataToDtoMapper
import javax.inject.Inject

class GetAllRecipesUseCase @Inject constructor(
    private val repository: RecipeRepository
) {
    suspend fun execute() = repository.getRecipeList().map(RecipeDataToDtoMapper::transform)
}