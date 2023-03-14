package com.example.recipesapp.home.domain.usecases

import com.example.recipesapp.home.domain.models.RecipeDto
import javax.inject.Inject

class FilterRecipesByKeywordUseCase @Inject constructor() {
    fun execute(keyword: String, recipeList: List<RecipeDto>): List<RecipeDto> {
        return recipeList.filter { recipe ->
            recipe.title.contains(keyword, ignoreCase = true)
        }
    }
}
