package com.example.recipes.domain.mapper

import com.example.recipes.data.models.RecipeEntity
import com.example.recipes.domain.models.RecipeDto
import com.example.core.utils.value

object RecipeDataToDtoMapper {
    fun transform(recipe: com.example.recipes.data.models.RecipeEntity) =
        with(recipe) {
            RecipeDto(
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
