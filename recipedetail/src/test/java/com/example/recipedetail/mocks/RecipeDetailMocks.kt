package com.example.recipedetail.mocks

import com.example.recipes.data.models.RecipeEntity
import com.example.recipes.domain.models.RecipeDto

object RecipeDetailMocks {
    const val DEFAULT_RECIPE_ID = "productId"

    fun getRecipeDto() = RecipeDto(
        id = "1",
        title = "title 1",
        thumbnail = "thumbnail/1.webp",
        description = "description 1",
        ingredients = "ingredients 1",
        preparation = "preparation 1",
        location = listOf(1.0, 2.0),
    )

    fun getRecipeEntity() = RecipeEntity(
        id = "1",
        title = "title 1",
        thumbnail = "thumbnail/1.webp",
        description = "description 1",
        ingredients = "ingredients 1",
        preparation = "preparation 1",
        location = listOf(1.0, 2.0),
    )
}
