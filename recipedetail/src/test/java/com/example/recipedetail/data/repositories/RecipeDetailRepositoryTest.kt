package com.example.recipedetail.data.repositories

import com.example.recipedetail.data.datasources.RecipeDetailRemoteDataSource
import com.example.recipedetail.domain.RecipeDetailRepository
import com.example.recipedetail.mocks.RecipeDetailMocks
import com.example.recipedetail.mocks.RecipeDetailMocks.DEFAULT_RECIPE_ID
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import okhttp3.ResponseBody.Companion.toResponseBody
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import retrofit2.Response

@OptIn(ExperimentalCoroutinesApi::class)
class RecipeDetailRepositoryTest {
    private val remoteDataSource = mockk<RecipeDetailRemoteDataSource>()

    private lateinit var recipeDetailRepository: RecipeDetailRepository

    @Before
    fun setup() {
        recipeDetailRepository =
            RecipeDetailDataRepository(remoteDataSource)
    }

    @Test
    fun `Test get recipe by id successful`() = runTest {
        val responseMock = RecipeDetailMocks.getRecipeDetailEntity()

        coEvery {
            remoteDataSource.getRecipeById(DEFAULT_RECIPE_ID)
        } returns Response.success(responseMock)

        val response = recipeDetailRepository.getRecipeDetail(DEFAULT_RECIPE_ID)

        coVerify { remoteDataSource.getRecipeById(DEFAULT_RECIPE_ID) }

        Assert.assertEquals(responseMock.id, response.id)
        Assert.assertEquals(responseMock.title, response.title)
        Assert.assertEquals(responseMock.thumbnail, response.thumbnail)
        Assert.assertEquals(responseMock.description, response.description)
        Assert.assertEquals(responseMock.ingredients, response.ingredients)
        Assert.assertEquals(responseMock.preparation, response.preparation)
        Assert.assertEquals(responseMock.location, response.location)
    }

    @Test
    fun `Test get recipe by id failed`() = runTest {
        coEvery {
            remoteDataSource.getRecipeById(DEFAULT_RECIPE_ID)
        } returns Response.error(404, "".toResponseBody())

        try {
            recipeDetailRepository.getRecipeDetail(DEFAULT_RECIPE_ID)
        } catch (ex: Throwable) {
            assert(ex is Exception)
        }
    }
}
