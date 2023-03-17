package com.example.recipesapp.mocks

import com.example.recipesapp.recipes.data.models.RecipeEntity
import com.example.recipesapp.recipes.data.models.RecipeListResponse
import com.example.recipesapp.recipes.domain.models.RecipeDto
import com.example.recipesapp.recipes.ui.models.RecipeModel

object RecipeMocks {
    const val DEFAULT_RECIPE_ID = "productId"

    fun getRecipeResponse() =
        RecipeListResponse(
            results = getRecipeListResponse(),
        )

    fun getRecipeListResponse() = arrayListOf(
        getRecipeEntity(),
        RecipeEntity(
            id = "2",
            title = "title 2",
            thumbnail = "thumbnail/2.webp",
        ),
        RecipeEntity(
            id = "3",
            title = "title 3",
            thumbnail = "thumbnail/3.webp",
        ),
        RecipeEntity(
            id = "4",
            title = "title 4",
            thumbnail = "thumbnail/4.webp",
        ),
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

    fun getRecipeDtoList() = arrayListOf(
        getRecipeDto(),
        RecipeDto(
            id = "2",
            title = "title 2",
            thumbnail = "thumbnail/2.webp",
            description = "description 2",
            ingredients = "ingredients 2",
            preparation = "preparation 2",
            location = listOf(1.0, 2.0),
        ),
        RecipeDto(
            id = "3",
            title = "title recipe 3",
            thumbnail = "thumbnail/3.webp",
            description = "description 3",
            ingredients = "ingredients 3",
            preparation = "preparation 3",
            location = listOf(1.0, 2.0),
        ),
        RecipeDto(
            id = "4",
            title = "title 4",
            thumbnail = "thumbnail/4.webp",
            description = "description 4",
            ingredients = "ingredients 4",
            preparation = "preparation 4",
            location = listOf(1.0, 2.0),
        ),
    )

    fun getRecipeDto() = RecipeDto(
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
            description = "description 2",
            ingredients = "ingredients 2",
            preparation = "preparation 2",
            location = listOf(1.0, 2.0),
        ),
        RecipeModel(
            id = "3",
            title = "title recipe 3",
            thumbnail = "thumbnail/3.webp",
            description = "description 3",
            ingredients = "ingredients 3",
            preparation = "preparation 3",
            location = listOf(1.0, 2.0),
        ),
        RecipeModel(
            id = "4",
            title = "title 4",
            thumbnail = "thumbnail/4.webp",
            description = "description 4",
            ingredients = "ingredients 4",
            preparation = "preparation 4",
            location = listOf(1.0, 2.0),
        ),
    )

    fun getRecipeModel() = RecipeModel(
        id = "1",
        title = "title 1",
        thumbnail = "thumbnail/1.webp",
        description = "description 1",
        ingredients = "ingredients 1",
        preparation = "preparation 1",
        location = listOf(1.0, 2.0),
    )
}
