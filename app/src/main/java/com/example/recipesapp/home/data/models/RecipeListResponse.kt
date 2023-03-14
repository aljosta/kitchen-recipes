package com.example.recipesapp.home.data.models

data class RecipeListResponse(
    val query: String? = null,
    val paging: PagingEntity? = PagingEntity(),
    val results: ArrayList<RecipeEntity> = arrayListOf(),
)
