package com.example.recipesapp.home.ui.mapper

import com.example.recipesapp.home.domain.models.RecipeDto
import com.example.recipesapp.home.ui.models.RecipeModel

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
