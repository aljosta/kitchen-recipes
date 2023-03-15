package com.example.recipesapp.recipes.ui.mapper

import com.example.recipesapp.recipes.domain.models.RecipeDto
import com.example.recipesapp.recipes.ui.models.RecipeModel

object RecipeDtoToModelMapper {
    fun transform(product: RecipeDto) = with(product) {
        RecipeModel(
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
