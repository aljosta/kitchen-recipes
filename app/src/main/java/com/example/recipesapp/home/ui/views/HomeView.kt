package com.example.recipesapp.home.ui.views

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.recipesapp.R
import com.example.recipesapp.home.ui.HomeViewModel
import com.example.recipesapp.home.ui.models.RecipeListState
import com.example.recipesapp.ui.view.TopBar

@Composable
fun HomeView(
    navigateToDetail: (String) -> Unit = {},
    viewModel: HomeViewModel = hiltViewModel(),
) {
    val recipeListState by viewModel.recipeListState.collectAsStateWithLifecycle(
        initialValue = RecipeListState.Loading,
    )
    val searchTextValue by viewModel.searchText.collectAsStateWithLifecycle()

    Scaffold(
        topBar = {
            TopBar(
                title = stringResource(id = R.string.recipe_list_top_bar_title),
                icon = Icons.Default.Menu,
            )
        },
    ) { paddingValues ->
        HomeView(
            recipeListState = recipeListState,
            searchTextValue = searchTextValue,
            onValueChange = viewModel::onSearchTextChange,
            navigateToDetail = navigateToDetail,
            modifier = Modifier.padding(paddingValues),
        )
    }
}

@Composable
fun HomeView(
    recipeListState: RecipeListState,
    searchTextValue: String,
    onValueChange: (String) -> Unit,
    navigateToDetail: (String) -> Unit,
    modifier: Modifier = Modifier,
) {
    Column(modifier = modifier) {
        SearchFieldView(
            searchValue = searchTextValue,
            onValueChange = onValueChange,
        )
        RecipeListView(
            recipeListState = recipeListState,
            navigateToDetail = navigateToDetail,
        )
    }
}

@Composable
fun SearchFieldView(
    searchValue: String,
    onValueChange: (String) -> Unit,
) {
    TextField(
        value = searchValue,
        onValueChange = onValueChange,
        modifier = Modifier.fillMaxWidth(),
        label = {
            Text(text = stringResource(id = R.string.recipe_search_label))
        },
        leadingIcon = {
            Icon(
                imageVector = Icons.Default.Search,
                contentDescription = stringResource(id = R.string.recipe_search_label),
            )
        },
        keyboardOptions = KeyboardOptions(imeAction = ImeAction.Done),
    )
}

@Preview(showBackground = true)
@Composable
fun PreviewHome() {
    HomeView(
        recipeListState = RecipeListState.Success(emptyList()),
        searchTextValue = "",
        onValueChange = {},
        navigateToDetail = {},
    )
}
