package com.secondworld.buenas.testingonandroid.data.testing_screen.di

import com.secondworld.buenas.testingonandroid.data.testing_screen.repository.TestingRepositoryImpl
import com.secondworld.buenas.testingonandroid.domain.testing_screen.repository.TestingRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class TestingDataModule {

    @Binds
    abstract fun bindRepository(repositoryImpl: TestingRepositoryImpl) : TestingRepository
}
