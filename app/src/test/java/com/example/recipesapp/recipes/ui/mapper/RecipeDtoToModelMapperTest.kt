package com.example.recipesapp.recipes.ui.mapper

import com.example.recipesapp.mocks.RecipeMocks
import org.junit.Assert
import org.junit.Test

class RecipeDtoToModelMapperTest {
    @Test
    fun `test recipe dto transform to recipe model`() {
        val recipeDto = RecipeMocks.getRecipeDto()

        val recipeModel = RecipeDtoToModelMapper.transform(recipeDto)

        with(RecipeMocks.getRecipeModel()) {
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
