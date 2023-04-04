package com.example.recipesapp.recipes.ui.mapper

import com.example.recipes.domain.models.RecipeDto
import com.example.recipesapp.recipes.ui.models.RecipeModel

object RecipeDtoToModelMapper {
    fun transform(recipe: RecipeDto) = with(recipe) {
        RecipeModel(
            id = id,
            title = title,
            thumbnail = thumbnail,
            ingredients = ingredients,
        )
    }
}
