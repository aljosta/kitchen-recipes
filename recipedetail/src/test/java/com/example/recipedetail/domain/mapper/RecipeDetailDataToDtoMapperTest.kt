package com.example.recipedetail.domain.mapper

import com.example.recipedetail.mocks.RecipeDetailMocks
import org.junit.Assert.assertEquals
import org.junit.Test

class RecipeDetailDataToDtoMapperTest {
    @Test
    fun `test recipe detail data transform to recipe detail dto`() {
        val recipeData = RecipeDetailMocks.getRecipeDetailEntity()

        val recipeDto = RecipeDetailDataToDtoMapper.transform(recipeData)

        with(RecipeDetailMocks.getRecipeDetailDto()) {
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