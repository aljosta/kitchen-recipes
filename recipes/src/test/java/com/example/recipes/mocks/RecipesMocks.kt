package com.example.recipes.mocks

import com.example.recipes.data.models.RecipeEntity
import com.example.recipes.data.models.RecipeListResponse
import com.example.recipes.domain.models.RecipeDto

object RecipesMocks {

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
        ingredients = "ingredients 1",
    )

    fun getRecipeDto() = RecipeDto(
        id = "1",
        title = "title 1",
        thumbnail = "thumbnail/1.webp",
        ingredients = "ingredients 1",
    )

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
}
