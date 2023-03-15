package com.example.recipesapp.recipedetail.ui.views

import android.util.Log
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.ParagraphStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.style.LineBreak
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import coil.compose.AsyncImage
import com.example.recipesapp.R
import com.example.recipesapp.recipes.ui.models.RecipeModel
import com.example.recipesapp.recipedetail.ui.RecipeDetailViewModel
import com.example.recipesapp.recipedetail.ui.models.RecipeDetailState
import com.example.recipesapp.ui.view.ErrorView
import com.example.recipesapp.ui.view.LoadingView
import com.example.recipesapp.ui.view.TopBar
import com.example.recipesapp.utils.Constants

private const val TAG = "RecipeDetailView"
private const val BULLET_STRING = "\u2022"
private const val TAB_STRING = "\t"

@Composable
fun RecipeDetailView(
    navigateToMap: (List<Double>) -> Unit,
    navigateUp: () -> Unit,
    viewModel: RecipeDetailViewModel = hiltViewModel(),
) {
    val recipeDetailState by viewModel.recipeDetailState.collectAsStateWithLifecycle(
        initialValue = RecipeDetailState.Loading,
    )

    Scaffold(
        topBar = {
            TopBar(
                title = stringResource(id = R.string.recipe_detail_top_bar_title),
                icon = Icons.Default.ArrowBack,
                onIconClick = navigateUp,
            )
        },
    ) { paddingValues ->
        when (recipeDetailState) {
            is RecipeDetailState.Success -> {
                val recipeDetail = (recipeDetailState as RecipeDetailState.Success).data
                RecipeDetailView(
                    recipeDetail = recipeDetail,
                    onMapButtonClick = navigateToMap,
                    modifier = Modifier.padding(paddingValues)
                        .verticalScroll(rememberScrollState())
                        .fillMaxWidth(),
                )
            }
            is RecipeDetailState.Error -> {
                val exception = (recipeDetailState as RecipeDetailState.Error).exception
                Log.e(TAG, exception.message.toString())
                ErrorView(exception)
            }
            is RecipeDetailState.Loading -> {
                LoadingView()
            }
        }
    }
}

@Composable
fun RecipeDetailView(
    recipeDetail: RecipeModel,
    onMapButtonClick: (List<Double>) -> Unit,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier.padding(15.dp),
        verticalArrangement = Arrangement.SpaceEvenly,
    ) {
        Text(
            text = recipeDetail.title,
            modifier = Modifier.padding(bottom = 10.dp),
            style = MaterialTheme.typography.h4,
        )
        AsyncImage(
            model = recipeDetail.thumbnail,
            contentDescription = Constants.EMPTY_STRING,
            contentScale = ContentScale.FillBounds,
            modifier = Modifier.height(300.dp).fillMaxWidth(),
        )
        Button(
            onClick = { onMapButtonClick(recipeDetail.location) },
            modifier = Modifier.padding(vertical = 15.dp)
        ) {
            Row {
                Icon(
                    imageVector = Icons.Default.LocationOn,
                    contentDescription = stringResource(id = R.string.location_button_text),
                )
                Text(text = stringResource(id = R.string.location_button_text))
            }
        }
        Divider()
        Text(
            text = stringResource(id = R.string.description_text),
            modifier = Modifier.padding(bottom = 5.dp, top = 15.dp),
            style = MaterialTheme.typography.h6,
        )
        Text(
            text = recipeDetail.description,
            modifier = Modifier.padding(bottom = 15.dp),
            style = MaterialTheme.typography.body1,
        )
        Text(
            text = stringResource(id = R.string.ingredients_text),
            modifier = Modifier.padding(bottom = 5.dp),
            style = MaterialTheme.typography.h6,
        )
        Text(
            text = buildAnnotatedString {
                recipeDetail.ingredients.split("\n").forEach { paragraph ->
                    if (paragraph.isNotBlank()) {
                        withStyle(style = ParagraphStyle(lineBreak = LineBreak.Paragraph)) {
                            append("$BULLET_STRING$TAB_STRING$TAB_STRING")
                            append(paragraph)
                        }
                    }
                }
            },
            modifier = Modifier.padding(bottom = 15.dp),
            style = MaterialTheme.typography.body1,
        )
        Text(
            text = stringResource(id = R.string.preparation_text),
            modifier = Modifier.padding(bottom = 5.dp),
            style = MaterialTheme.typography.h6,
        )
        Text(
            text = buildAnnotatedString {
                recipeDetail.preparation.split("\n").forEachIndexed { index, paragraph ->
                    if (paragraph.isNotBlank()) {
                        withStyle(style = ParagraphStyle(lineBreak = LineBreak.Paragraph)) {
                            append("${index + 1}.$TAB_STRING$TAB_STRING")
                            append(paragraph)
                        }
                    }
                }
            },
            modifier = Modifier.padding(bottom = 5.dp),
            style = MaterialTheme.typography.body1,
        )
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewRecipeDetailView() {
    RecipeDetailView(
        recipeDetail = RecipeModel(
            id = "10",
            title = "Sopa de lentejas",
            description = "jsahjdhasj",
            thumbnail = "",
            ingredients = "",
            preparation = "",
            location = listOf(),
        ),
        onMapButtonClick = { /*TODO*/ },
    )
}
