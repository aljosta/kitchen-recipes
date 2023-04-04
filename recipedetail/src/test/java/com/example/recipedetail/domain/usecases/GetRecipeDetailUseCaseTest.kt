package com.example.recipedetail.domain.usecases

import com.example.recipedetail.domain.RecipeDetailRepository
import com.example.recipedetail.mocks.RecipeDetailMocks
import com.example.recipedetail.mocks.RecipeDetailMocks.DEFAULT_RECIPE_ID
import com.example.recipedetail.domain.usescases.GetRecipeDetailUseCase
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

    private val recipeRepository = mockk<RecipeDetailRepository>()

    private lateinit var useCase: GetRecipeDetailUseCase

    @Before
    fun setup() {
        useCase = GetRecipeDetailUseCase(recipeRepository)
    }

    @Test
    fun `Test get all recipes use case successful`() = runTest {
        val expectedRecipeDto = RecipeDetailMocks.getRecipeDetailDto()

        coEvery {
            recipeRepository.getRecipeDetail(DEFAULT_RECIPE_ID)
        } returns RecipeDetailMocks.getRecipeDetailEntity()

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
