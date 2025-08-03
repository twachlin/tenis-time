package com.example.tenis_time.domain.usecase

import com.example.tenis_time.domain.model.SettingsState
import com.example.tenis_time.domain.repository.SettingsRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class ObserveSettingsUseCase @Inject constructor(
    private val repository: SettingsRepository,
) {
    operator fun invoke(): Flow<SettingsState> = repository.settingsFlow
}