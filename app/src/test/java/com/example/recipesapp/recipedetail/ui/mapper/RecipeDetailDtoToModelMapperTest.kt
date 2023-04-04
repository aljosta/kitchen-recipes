package com.example.recipesapp.recipedetail.ui.mapper

import com.example.recipesapp.mocks.RecipeMocks
import org.junit.Assert
import org.junit.Test

class RecipeDetailDtoToModelMapperTest {
    @Test
    fun `test recipe detail dto transform to recipe model`() {
        val recipeDto = RecipeMocks.getRecipeDetailDto()

        val recipeModel = RecipeDetailDtoToModelMapper.transform(recipeDto)

        with(RecipeMocks.getRecipeDetailModel()) {
            Assert.assertEquals(id, recipeModel.id)
            Assert.assertEquals(title, recipeModel.title)
            Assert.assertEquals(thumbnail, recipeModel.thumbnail)
            Assert.assertEquals(description, recipeModel.description)
            Assert.assertEquals(ingredients, recipeModel.ingredients)
            Assert.assertEquals(preparation, recipeModel.preparation)
            Assert.assertEquals(location, recipeModel.location)
        }
    }
}