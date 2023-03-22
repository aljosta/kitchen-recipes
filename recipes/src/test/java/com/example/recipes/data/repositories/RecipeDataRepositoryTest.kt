package com.example.recipes.data.repositories

import com.example.recipes.data.datasources.RecipeRemoteDataSource
import com.example.recipes.domain.RecipeRepository
import com.example.recipes.mocks.RecipesMocks
import com.example.recipes.mocks.RecipesMocks.DEFAULT_RECIPE_ID
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import okhttp3.ResponseBody.Companion.toResponseBody
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import org.mockito.ArgumentMatchers.*
import retrofit2.Response

@OptIn(ExperimentalCoroutinesApi::class)
class RecipeDataRepositoryTest {

    private val remoteDataSource = mockk<RecipeRemoteDataSource>()

    private lateinit var productRepository: RecipeRepository

    @Before
    fun setup() {
        productRepository =
            RecipeDataRepository(remoteDataSource)
    }

    @Test
    fun `Test gert product list successful`() = runTest {
        val responseMock = RecipesMocks.getRecipeResponse()

        coEvery {
            remoteDataSource.getRecipeList()
        } returns Response.success(responseMock)

        val response = productRepository.getRecipeList()

        coVerify { remoteDataSource.getRecipeList() }

        assertEquals(responseMock.results.size, response.size)
    }

    @Test
    fun `Test get recipe list failed`() = runTest {
        coEvery {
            remoteDataSource.getRecipeList()
        } returns Response.error(404, "".toResponseBody())

        try {
            productRepository.getRecipeList()
        } catch (ex: Throwable) {
            assert(ex is Exception)
        }
    }

    @Test
    fun `Test get recipe by id successful`() = runTest {
        val responseMock = RecipesMocks.getRecipeEntity()

        coEvery {
            remoteDataSource.getRecipeById(DEFAULT_RECIPE_ID)
        } returns Response.success(responseMock)

        val response = productRepository.getRecipeDetail(DEFAULT_RECIPE_ID)

        coVerify { remoteDataSource.getRecipeById(DEFAULT_RECIPE_ID) }

        assertEquals(responseMock.id, response.id)
        assertEquals(responseMock.title, response.title)
        assertEquals(responseMock.thumbnail, response.thumbnail)
    }

    @Test
    fun `Test get recipe by id failed`() = runTest {
        val recipeId = "1"

        coEvery {
            remoteDataSource.getRecipeById(recipeId)
        } returns Response.error(404, "".toResponseBody())

        try {
            productRepository.getRecipeDetail(recipeId)
        } catch (ex: Throwable) {
            assert(ex is Exception)
        }
    }
}
