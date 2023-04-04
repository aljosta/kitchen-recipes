package com.example.recipedetail.domain.mapper

import com.example.core.utils.value
import com.example.recipedetail.data.models.RecipeDetailEntity
import com.example.recipedetail.domain.models.RecipeDetailDto

object RecipeDetailDataToDtoMapper {
    fun transform(recipe: RecipeDetailEntity) =
        with(recipe) {
            RecipeDetailDto(
                id = id.value(),
                title = title.value(),
                thumbnail = thumbnail.value(),
                description = description.value(),
                preparation = preparation.value(),
                ingredients = ingredients.value(),
                location = location.value(),
            )
        }
}