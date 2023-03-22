package com.example.recipesapp.home.ui

import com.example.recipes.domain.usecases.FilterRecipesByKeywordUseCase
import com.example.recipes.domain.usecases.GetAllRecipesUseCase
import com.example.recipesapp.mocks.RecipeMocks
import com.example.recipesapp.recipes.ui.models.RecipeListState
import io.mockk.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.*
import org.junit.After
import org.junit.Assert
import org.junit.Before
import org.junit.Test

@OptIn(ExperimentalCoroutinesApi::class)
class HomeViewModelTest {
    private val getRecipesUseCase = mockk<GetAllRecipesUseCase>()

    private val filterRecipesUseCase = mockk<FilterRecipesByKeywordUseCase>()

    private lateinit var viewModel: HomeViewModel

    @Before
    fun setup() {
        Dispatchers.setMain(UnconfinedTestDispatcher(TestCoroutineScheduler()))
    }

    @After
    fun reset() {
        Dispatchers.resetMain()
    }

    @Test
    fun `Test get recipe list successful`() = runTest {
        coEvery {
            getRecipesUseCase.execute()
        } returns RecipeMocks.getRecipeDtoList()

        viewModel = HomeViewModel(getRecipesUseCase, filterRecipesUseCase)

        coVerify { getRecipesUseCase.execute() }
        Assert.assertEquals(
            RecipeListState.Success(RecipeMocks.getRecipeListModel()),
            viewModel.recipeListState.value,
        )
    }

    @Test
    fun `Test get recipe detail is failed`() = runTest {
        coEvery {
            getRecipesUseCase.execute()
        } throws Exception()

        viewModel = HomeViewModel(getRecipesUseCase, filterRecipesUseCase)

        Assert.assertEquals(
            RecipeListState.Error(Exception()).toString(),
            viewModel.recipeListState.value.toString(),
        )
    }
}
