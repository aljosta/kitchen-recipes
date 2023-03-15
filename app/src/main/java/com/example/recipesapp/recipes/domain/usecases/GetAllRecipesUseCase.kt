package com.example.recipesapp.recipes.domain.usecases

import com.example.recipesapp.recipes.domain.RecipeRepository
import com.example.recipesapp.recipes.domain.mapper.RecipeDataToDtoMapper
import javax.inject.Inject

class GetAllRecipesUseCase @Inject constructor(
    private val repository: RecipeRepository
) {
    suspend fun execute() = repository.getRecipeList().map(RecipeDataToDtoMapper::transform)
}