package com.example.recipesapp.location.ui

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class LocationViewModel : ViewModel() {
    private val _filterTextFlow = MutableStateFlow("")
    val filterTextFlow: StateFlow<String>
        get() = _filterTextFlow.asStateFlow()
}
