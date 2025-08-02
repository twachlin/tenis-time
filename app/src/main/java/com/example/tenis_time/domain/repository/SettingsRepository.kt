package com.example.tenis_time.domain.repository

import com.example.tenis_time.domain.model.SettingsState
import kotlinx.coroutines.flow.Flow

interface SettingsRepository {
    val settingsFlow: Flow<SettingsState>
    suspend fun save(state: SettingsState)
}