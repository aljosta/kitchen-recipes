package com.example.recipedetail.di

import com.example.core.data.network.ApiServiceProvider
import com.example.recipedetail.data.datasources.RecipeDetailRemoteDataSource
import com.example.recipedetail.data.repositories.RecipeDetailDataRepository
import com.example.recipedetail.domain.RecipeDetailRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object RecipeDetailModule {
    @Singleton
    @Provides
    fun provideRemoteDataSource(): RecipeDetailRemoteDataSource =
        ApiServiceProvider().create(
            RecipeDetailRemoteDataSource::class.java,
            "http://demo0687698.mockable.io/",
        )

    @Singleton
    @Provides
    fun provideRepository(
        remoteDataSource: RecipeDetailRemoteDataSource,
    ): RecipeDetailRepository = RecipeDetailDataRepository(remoteDataSource)
}