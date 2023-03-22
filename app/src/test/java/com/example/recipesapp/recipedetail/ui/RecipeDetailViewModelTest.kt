package com.example.recipesapp.recipedetail.ui

import androidx.lifecycle.SavedStateHandle
import com.example.recipesapp.mocks.RecipeMocks
import com.example.recipesapp.mocks.RecipeMocks.DEFAULT_RECIPE_ID
import com.example.recipedetail.usescases.GetRecipeDetailUseCase
import com.example.recipesapp.recipedetail.ui.models.RecipeDetailState
import com.example.recipesapp.ui.NavArgs
import io.mockk.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.*
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

@OptIn(ExperimentalCoroutinesApi::class)
class RecipeDetailViewModelTest {
    private val useCase = mockk<GetRecipeDetailUseCase>()

    private val savedStateHandle = mockk<SavedStateHandle>(relaxed = true)

    private lateinit var viewModel: RecipeDetailViewModel

    @Before
    fun setup() {
        Dispatchers.setMain(UnconfinedTestDispatcher(TestCoroutineScheduler()))
        every { savedStateHandle.get<String>(NavArgs.RecipeId.key) } returns DEFAULT_RECIPE_ID
    }

    @After
    fun reset() {
        Dispatchers.resetMain()
    }

    @Test
    fun `Test get recipe detail successful`() = runTest {
        coEvery {
            useCase.execute(DEFAULT_RECIPE_ID)
        } returns RecipeMocks.getRecipeDto()

        viewModel = RecipeDetailViewModel(useCase, savedStateHandle)

        coVerify { useCase.execute(DEFAULT_RECIPE_ID) }
        assertEquals(
            RecipeDetailState.Success(RecipeMocks.getRecipeModel()),
            viewModel.recipeDetailState.value,
        )
    }

    @Test
    fun `Test get recipe detail is failed`() = runTest {
        coEvery {
            useCase.execute(DEFAULT_RECIPE_ID)
        } throws Exception()

        viewModel = RecipeDetailViewModel(useCase, savedStateHandle)

        coVerify { useCase.execute(DEFAULT_RECIPE_ID) wasNot called }
        assertEquals(
            RecipeDetailState.Error(Exception()).toString(),
            viewModel.recipeDetailState.value.toString(),
        )
    }
}