package com.example.recipes.di

import com.example.core.data.network.ApiServiceProvider
import com.example.recipes.data.datasources.RecipeRemoteDataSource
import com.example.recipes.data.repositories.RecipeDataRepository
import com.example.recipes.domain.RecipeRepository
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
