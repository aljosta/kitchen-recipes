package com.example.recipesapp.home.ui.mapper

import com.example.recipesapp.home.domain.models.RecipeDto
import com.example.recipesapp.home.ui.models.RecipeModel

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