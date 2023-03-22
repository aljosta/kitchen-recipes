package com.example.recipes.domain.mapper

import com.example.recipes.mocks.RecipesMocks
import org.junit.Assert.assertEquals
import org.junit.Test

class RecipeDataToDtoMapperTest {
    @Test
    fun `test recipe data transform to recipe dto`() {
        val recipeData = RecipesMocks.getRecipeEntity()

        val recipeDto = RecipeDataToDtoMapper.transform(recipeData)

        with(RecipesMocks.getRecipeDto()) {
            assertEquals(id, recipeDto.id)
            assertEquals(title, recipeDto.title)
            assertEquals(thumbnail, recipeDto.thumbnail)
            assertEquals(description, recipeDto.description)
            assertEquals(ingredients, recipeDto.ingredients)
            assertEquals(preparation, recipeDto.preparation)
            assertEquals(location, recipeDto.location)
        }
    }
}
