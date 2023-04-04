package com.example.recipes.domain.usecases

import com.example.recipes.domain.RecipeRepository
import com.example.recipes.mocks.RecipesMocks
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

@OptIn(ExperimentalCoroutinesApi::class)
class GetAllRecipesUseCaseTest {
    private val recipeRepository = mockk<RecipeRepository>()

    private lateinit var useCase: GetAllRecipesUseCase

    @Before
    fun setup() {
        useCase = GetAllRecipesUseCase(recipeRepository)
    }

    @Test
    fun `Test get all recipes use case successful`() = runTest {
        val expectedRecipeDto = RecipesMocks.getRecipeDto()

        coEvery { recipeRepository.getRecipeList() } returns RecipesMocks.getRecipeListResponse()

        useCase.execute().first().let { recipeDto ->
            assertEquals(expectedRecipeDto.id, recipeDto.id)
            assertEquals(expectedRecipeDto.title, recipeDto.title)
            assertEquals(expectedRecipeDto.thumbnail, recipeDto.thumbnail)
            assertEquals(expectedRecipeDto.ingredients, recipeDto.ingredients)
        }

        coVerify { recipeRepository.getRecipeList() }
    }
}