package com.example.recipesapp.recipes.ui.views

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.recipesapp.recipes.ui.models.RecipeModel
import com.example.core.utils.Constants

@Composable
fun RecipeItemView(
    recipeModel: RecipeModel,
    onItemClick: (String) -> Unit,
) {
    Card(
        modifier = Modifier.padding(8.dp)
            .clickable { onItemClick(recipeModel.id) },
        elevation = 6.dp,
    ) {
        Column(
            modifier = Modifier.fillMaxSize()
                .padding(15.dp),
            verticalArrangement = Arrangement.SpaceEvenly,
        ) {
            Text(
                text = recipeModel.title,
                modifier = Modifier.padding(bottom = 10.dp),
                style = MaterialTheme.typography.h6,
            )
            AsyncImage(
                model = recipeModel.thumbnail,
                contentDescription = Constants.EMPTY_STRING,
                contentScale = ContentScale.Fit,
                modifier = Modifier.fillMaxSize(),
            )
        }
    }
}

@Preview
@Composable
fun PreviewRecipeItemView() {
    RecipeItemView(
        recipeModel = RecipeModel(
            id = "10",
            title = "Sopa de lentejas",
            description = "jsahjdhasj",
            thumbnail = "",
            ingredients = "",
            preparation = "",
            location = listOf(),
        ),
        onItemClick = {},
    )
}
