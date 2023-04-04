package com.example.recipedetail.mocks

import com.example.recipedetail.data.models.RecipeDetailEntity
import com.example.recipedetail.domain.models.RecipeDetailDto

object RecipeDetailMocks {
    const val DEFAULT_RECIPE_ID = "productId"

    fun getRecipeDetailDto() = RecipeDetailDto(
        id = "1",
        title = "title 1",
        thumbnail = "thumbnail/1.webp",
        description = "description 1",
        ingredients = "ingredients 1",
        preparation = "preparation 1",
        location = listOf(1.0, 2.0),
    )

    fun getRecipeDetailEntity() = RecipeDetailEntity(
        id = "1",
        title = "title 1",
        thumbnail = "thumbnail/1.webp",
        description = "description 1",
        ingredients = "ingredients 1",
        preparation = "preparation 1",
        location = listOf(1.0, 2.0),
    )
}
