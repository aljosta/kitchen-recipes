package com.example.recipesapp.recipes.ui.mapper

import com.example.recipes.domain.models.RecipeDto
import com.example.recipesapp.recipes.ui.models.RecipeModel

object RecipeModelToDtoMapper {
    fun transform(recipe: RecipeModel) = with(recipe) {
        RecipeDto(
            id = id,
            title = title,
            thumbnail = thumbnail,
            description = description,
            preparation = preparation,
            ingredients = ingredients,
            location = location,
        )
    }
}
