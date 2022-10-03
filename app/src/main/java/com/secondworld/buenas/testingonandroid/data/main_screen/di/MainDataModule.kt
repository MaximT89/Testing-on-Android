package com.secondworld.buenas.testingonandroid.data.main_screen.di

import com.secondworld.buenas.testingonandroid.data.main_screen.repositoty.MainRepositoryImpl
import com.secondworld.buenas.testingonandroid.domain.main_screen.repository.MainRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class MainDataModule {

    @Binds
    abstract fun bindsMainRepository(repository: MainRepositoryImpl) : MainRepository
}