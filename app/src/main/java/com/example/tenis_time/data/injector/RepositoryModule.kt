package com.example.tenis_time.data.injector

import com.example.tenis_time.data.SettingsRepositoryImpl
import com.example.tenis_time.domain.repository.SettingsRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule(
    private val settingsRepositoryImpl: SettingsRepositoryImpl
) {

    @Binds
    abstract fun bindSettingsRepository(
        settingsRepositoryImpl: SettingsRepositoryImpl
    ): SettingsRepository
}