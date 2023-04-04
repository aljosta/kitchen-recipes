package com.example.recipesapp.recipedetail.ui.mapper

import com.example.recipedetail.domain.models.RecipeDetailDto
import com.example.recipesapp.recipedetail.ui.models.RecipeDetailModel

object RecipeDetailDtoToModelMapper {
    fun transform(recipe: RecipeDetailDto) = with(recipe) {
        RecipeDetailModel(
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