package com.example.recipes.domain.usecases

import com.example.recipes.mocks.RecipesMocks
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.Assert
import org.junit.Before
import org.junit.Test

@OptIn(ExperimentalCoroutinesApi::class)
class FilterRecipeByKeywordUseCaseTest {

    private lateinit var useCase: FilterRecipesByKeywordUseCase

    @Before
    fun setup() {
        useCase = FilterRecipesByKeywordUseCase()
    }

    @Test
    fun `Test get all recipes use case successful`() = runTest {
        val expectedFilteredRecipeDto = RecipesMocks.getRecipeDtoList()[2]

        useCase.execute(
            "recipe",
            RecipesMocks.getRecipeDtoList(),
        ).first().let { filteredRecipeDto ->
            Assert.assertEquals(expectedFilteredRecipeDto.id, filteredRecipeDto.id)
            Assert.assertEquals(expectedFilteredRecipeDto.title, filteredRecipeDto.title)
            Assert.assertEquals(expectedFilteredRecipeDto.thumbnail, filteredRecipeDto.thumbnail)
            Assert.assertEquals(expectedFilteredRecipeDto.ingredients, filteredRecipeDto.ingredients)
        }
    }
}
