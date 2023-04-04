package com.example.recipesapp.recipes.ui.mapper

import com.example.recipesapp.mocks.RecipeMocks
import org.junit.Assert
import org.junit.Test

class RecipeModelToDtoMapperTest {
    class RecipeDtoToModelMapperTest {
        @Test
        fun `test recipe model transform to recipe dto`() {
            val recipeModel = RecipeMocks.getRecipeModel()

            val recipeDto = RecipeModelToDtoMapper.transform(recipeModel)

            with(RecipeMocks.getRecipeDto()) {
                Assert.assertEquals(id, recipeDto.id)
                Assert.assertEquals(title, recipeDto.title)
                Assert.assertEquals(thumbnail, recipeDto.thumbnail)
                Assert.assertEquals(ingredients, recipeDto.ingredients)
            }
        }
    }
}