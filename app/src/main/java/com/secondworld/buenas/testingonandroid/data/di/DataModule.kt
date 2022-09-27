package com.secondworld.buenas.testingonandroid.data.di

import com.secondworld.buenas.testingonandroid.data.repository.RepositoryImpl
import com.secondworld.buenas.testingonandroid.domain.repository.Repository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class DataModule {

    @Binds
    abstract fun bindRepository(repositoryImpl: RepositoryImpl) : Repository
}
