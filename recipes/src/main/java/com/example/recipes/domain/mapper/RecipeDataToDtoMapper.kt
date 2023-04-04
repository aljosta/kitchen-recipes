package com.example.recipes.domain.mapper

import com.example.core.utils.value
import com.example.recipes.data.models.RecipeEntity
import com.example.recipes.domain.models.RecipeDto

object RecipeDataToDtoMapper {
    fun transform(recipe: RecipeEntity) =
        with(recipe) {
            RecipeDto(
                id = id.value(),
                title = title.value(),
                thumbnail = thumbnail.value(),
                ingredients = ingredients.value(),
            )
        }
}
