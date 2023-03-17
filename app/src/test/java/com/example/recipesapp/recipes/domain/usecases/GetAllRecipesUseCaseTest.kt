package com.example.recipesapp.recipes.domain.usecases

import com.example.recipesapp.mocks.RecipeMocks
import com.example.recipesapp.recipes.domain.RecipeRepository
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
        val expectedRecipeDto = RecipeMocks.getRecipeDto()

        coEvery { recipeRepository.getRecipeList() } returns RecipeMocks.getRecipeListResponse()

        useCase.execute().first().let { recipeDto ->
            assertEquals(expectedRecipeDto.id, recipeDto.id)
            assertEquals(expectedRecipeDto.title, recipeDto.title)
            assertEquals(expectedRecipeDto.thumbnail, recipeDto.thumbnail)
            assertEquals(expectedRecipeDto.description, recipeDto.description)
            assertEquals(expectedRecipeDto.ingredients, recipeDto.ingredients)
            assertEquals(expectedRecipeDto.preparation, recipeDto.preparation)
            assertEquals(expectedRecipeDto.location, recipeDto.location)
        }

        coVerify { recipeRepository.getRecipeList() }
    }
}