package com.example.recipesapp.home.di

import com.example.recipesapp.data.network.ApiServiceProvider
import com.example.recipesapp.home.data.datasources.RecipeRemoteDataSource
import com.example.recipesapp.home.data.repositories.RecipeDataRepository
import com.example.recipesapp.home.domain.RecipeRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object RecipesModule {
    @Singleton
    @Provides
    fun provideRemoteDataSource(): RecipeRemoteDataSource =
        ApiServiceProvider().create(
            RecipeRemoteDataSource::class.java,
            "http://demo0687698.mockable.io/",
        )

    @Singleton
    @Provides
    fun provideRepository(
        remoteDataSource: RecipeRemoteDataSource,
    ): RecipeRepository = RecipeDataRepository(remoteDataSource)
}
