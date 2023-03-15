package com.example.recipesapp.recipedetail.ui

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.recipesapp.recipedetail.domain.usescases.GetRecipeDetailUseCase
import com.example.recipesapp.recipedetail.ui.models.RecipeDetailState
import com.example.recipesapp.recipes.ui.mapper.RecipeDtoToModelMapper
import com.example.recipesapp.ui.NavArgs
import com.example.recipesapp.utils.value
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RecipeDetailViewModel @Inject constructor(
    private val getRecipeDetailUseCase: GetRecipeDetailUseCase,
    savedStateHandle: SavedStateHandle,
) : ViewModel() {

    private val recipeId: String = savedStateHandle.get<String>(NavArgs.RecipeId.key).value()

    private val _recipeDetailState = MutableStateFlow<RecipeDetailState>(RecipeDetailState.Loading)
    val recipeDetailState: StateFlow<RecipeDetailState>
        get() = _recipeDetailState

    init {
        getRecipeDetail(recipeId)
    }

    private fun getRecipeDetail(recipeId: String) {
        viewModelScope.launch {
            try {
                _recipeDetailState.value =
                    RecipeDetailState.Success(
                        RecipeDtoToModelMapper.transform(getRecipeDetailUseCase.execute(recipeId)),
                    )
            } catch (exception: Exception) {
                _recipeDetailState.value = RecipeDetailState.Error(exception)
            }
        }
    }
}
