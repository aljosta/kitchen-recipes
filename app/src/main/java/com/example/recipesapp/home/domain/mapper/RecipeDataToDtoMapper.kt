package com.example.recipesapp.home.domain.mapper

import com.example.recipesapp.home.data.models.RecipeEntity
import com.example.recipesapp.home.domain.models.RecipeDto
import com.example.recipesapp.utils.value

object RecipeDataToDtoMapper {
    fun transform(recipe: RecipeEntity) =
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
