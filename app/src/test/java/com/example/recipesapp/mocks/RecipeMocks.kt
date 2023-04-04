package com.example.recipesapp.mocks

import com.example.recipedetail.domain.models.RecipeDetailDto
import com.example.recipes.domain.models.RecipeDto
import com.example.recipesapp.recipedetail.ui.models.RecipeDetailModel
import com.example.recipesapp.recipes.ui.models.RecipeModel

object RecipeMocks {
    const val DEFAULT_RECIPE_ID = "productId"

    fun getRecipeDtoList() = arrayListOf(
        getRecipeDto(),
        RecipeDto(
            id = "2",
            title = "title 2",
            thumbnail = "thumbnail/2.webp",
            ingredients = "ingredients 2",
        ),
        RecipeDto(
            id = "3",
            title = "title recipe 3",
            thumbnail = "thumbnail/3.webp",
            ingredients = "ingredients 3",
        ),
        RecipeDto(
            id = "4",
            title = "title 4",
            thumbnail = "thumbnail/4.webp",
            ingredients = "ingredients 4",
        ),
    )

    fun getRecipeDto() = RecipeDto(
        id = "1",
        title = "title 1",
        thumbnail = "thumbnail/1.webp",
        ingredients = "ingredients 1",
    )

    fun getRecipeDetailDto() = RecipeDetailDto(
        id = "1",
        title = "title 1",
        thumbnail = "thumbnail/1.webp",
        description = "description 1",
        ingredients = "ingredients 1",
        preparation = "preparation 1",
        location = listOf(1.0, 2.0),
    )

    fun getRecipeListModel() = listOf(
        getRecipeModel(),
        RecipeModel(
            id = "2",
            title = "title 2",
            thumbnail = "thumbnail/2.webp",
            ingredients = "ingredients 2",
        ),
        RecipeModel(
            id = "3",
            title = "title recipe 3",
            thumbnail = "thumbnail/3.webp",
            ingredients = "ingredients 3",
        ),
        RecipeModel(
            id = "4",
            title = "title 4",
            thumbnail = "thumbnail/4.webp",
            ingredients = "ingredients 4",
        ),
    )

    fun getRecipeModel() = RecipeModel(
        id = "1",
        title = "title 1",
        thumbnail = "thumbnail/1.webp",
        ingredients = "ingredients 1",
    )

    fun getRecipeDetailModel() = RecipeDetailModel(
        id = "1",
        title = "title 1",
        thumbnail = "thumbnail/1.webp",
        description = "description 1",
        ingredients = "ingredients 1",
        preparation = "preparation 1",
        location = listOf(1.0, 2.0),
    )
}
