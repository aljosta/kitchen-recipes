package com.example.recipesapp.home.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.recipes.domain.usecases.FilterRecipesByKeywordUseCase
import com.example.recipes.domain.usecases.GetAllRecipesUseCase
import com.example.recipesapp.recipes.ui.mapper.RecipeDtoToModelMapper
import com.example.recipesapp.recipes.ui.mapper.RecipeModelToDtoMapper
import com.example.recipesapp.recipes.ui.models.RecipeListState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getRecipesUseCase: GetAllRecipesUseCase,
    private val filterRecipesUseCase: FilterRecipesByKeywordUseCase,
) : ViewModel() {

    private val _searchText = MutableStateFlow("")
    val searchText = _searchText.asStateFlow()

    private var _recipeListState = MutableStateFlow<RecipeListState>(
        RecipeListState.Loading,
    )
    val recipeListState = _recipeListState.asStateFlow()

    val recipeListWithSearchState = searchText.combine(recipeListState) { text, currentListState ->
        if (text.isBlank()) {
            currentListState
        } else {
            filterRecipeList(text, currentListState)
        }
    }.stateIn(
        scope = viewModelScope,
        SharingStarted.WhileSubscribed(),
        initialValue = _recipeListState.value,
    )

    init {
        getRecipeList()
    }

    fun onSearchTextChange(textValue: String) {
        _searchText.value = textValue
    }

    private fun getRecipeList() {
        viewModelScope.launch {
            try {
                _recipeListState.value = RecipeListState.Success(
                    getRecipesUseCase.execute().map(RecipeDtoToModelMapper::transform),
                )
            } catch (exception: Exception) {
                _recipeListState.value = RecipeListState.Error(exception)
            }
        }
    }

    private fun filterRecipeList(keyword: String, state: RecipeListState) =
        (state as? RecipeListState.Success)?.data?.let { recipeList ->
            RecipeListState.Success(
                filterRecipesUseCase.execute(
                    keyword,
                    recipeList.map(RecipeModelToDtoMapper::transform),
                ).map(RecipeDtoToModelMapper::transform),
            )
        } ?: RecipeListState.Error(Exception())
}
