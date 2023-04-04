package com.example.recipes.data.repositories

import com.example.recipes.data.datasources.RecipeRemoteDataSource
import com.example.recipes.domain.RecipeRepository
import com.example.recipes.mocks.RecipesMocks
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

    private lateinit var recipeRepository: RecipeRepository

    @Before
    fun setup() {
        recipeRepository =
            RecipeDataRepository(remoteDataSource)
    }

    @Test
    fun `Test gert product list successful`() = runTest {
        val responseMock = RecipesMocks.getRecipeResponse()

        coEvery {
            remoteDataSource.getRecipeList()
        } returns Response.success(responseMock)

        val response = recipeRepository.getRecipeList()

        coVerify { remoteDataSource.getRecipeList() }

        assertEquals(responseMock.results.size, response.size)
    }

    @Test
    fun `Test get recipe list failed`() = runTest {
        coEvery {
            remoteDataSource.getRecipeList()
        } returns Response.error(404, "".toResponseBody())

        try {
            recipeRepository.getRecipeList()
        } catch (ex: Throwable) {
            assert(ex is Exception)
        }
    }
}
