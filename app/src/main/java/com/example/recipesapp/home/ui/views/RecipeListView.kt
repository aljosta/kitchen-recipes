package com.example.recipesapp.home.ui.views

import android.util.Log
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.recipesapp.home.ui.models.RecipeListState
import com.example.recipesapp.home.ui.models.RecipeModel
import com.example.recipesapp.ui.view.ErrorView
import com.example.recipesapp.ui.view.LoadingView

private const val TAG = "RecipeListView"

@Composable
fun RecipeListView(
    recipeListState: RecipeListState,
    navigateToDetail: (String) -> Unit,
) {
    when (recipeListState) {
        is RecipeListState.Success -> {
            val recipeList = recipeListState.data
            if (recipeList.isEmpty()) {
                EmptyStateView()
            } else {
                RecipeListView(
                    recipeList = recipeList,
                    onItemClick = navigateToDetail,
                )
            }
        }
        is RecipeListState.Error -> {
            val exception = recipeListState.exception
            Log.e(TAG, exception.message.toString())
            ErrorView(exception = exception)
        }
        is RecipeListState.Loading -> {
            LoadingView()
        }
    }
}

@Composable
fun RecipeListView(
    recipeList: List<RecipeModel>,
    onItemClick: (String) -> Unit,
    modifier: Modifier = Modifier,
) {
    LazyVerticalGrid(
        modifier = modifier,
        columns = GridCells.Fixed(2),
    ) {
        items(
            recipeList.size,
        ) { index ->
            RecipeItemView(recipeModel = recipeList[index], onItemClick = onItemClick)
        }
    }
}
