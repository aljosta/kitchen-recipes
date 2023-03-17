package com.example.recipesapp.recipedetail.domain.usecases

import com.example.recipesapp.mocks.RecipeMocks
import com.example.recipesapp.mocks.RecipeMocks.DEFAULT_RECIPE_ID
import com.example.recipesapp.recipedetail.domain.usescases.GetRecipeDetailUseCase
import com.example.recipesapp.recipes.domain.RecipeRepository
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.Assert
import org.junit.Before
import org.junit.Test

@OptIn(ExperimentalCoroutinesApi::class)
class GetRecipeDetailUseCaseTest {

    private val recipeRepository = mockk<RecipeRepository>()

    private lateinit var useCase: GetRecipeDetailUseCase

    @Before
    fun setup() {
        useCase = GetRecipeDetailUseCase(recipeRepository)
    }

    @Test
    fun `Test get all recipes use case successful`() = runTest {
        val expectedRecipeDto = RecipeMocks.getRecipeDto()

        coEvery { recipeRepository.getRecipeDetail(DEFAULT_RECIPE_ID) } returns RecipeMocks.getRecipeEntity()

        useCase.execute(DEFAULT_RECIPE_ID).let { recipeDto ->
            Assert.assertEquals(expectedRecipeDto.id, recipeDto.id)
            Assert.assertEquals(expectedRecipeDto.title, recipeDto.title)
            Assert.assertEquals(expectedRecipeDto.thumbnail, recipeDto.thumbnail)
            Assert.assertEquals(expectedRecipeDto.description, recipeDto.description)
            Assert.assertEquals(expectedRecipeDto.ingredients, recipeDto.ingredients)
            Assert.assertEquals(expectedRecipeDto.preparation, recipeDto.preparation)
            Assert.assertEquals(expectedRecipeDto.location, recipeDto.location)
        }

        coVerify { recipeRepository.getRecipeDetail(DEFAULT_RECIPE_ID) }
    }
}
