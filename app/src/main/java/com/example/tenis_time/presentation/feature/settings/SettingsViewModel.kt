package com.example.tenis_time.presentation.feature.settings

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.tenis_time.domain.model.SettingsState
import com.example.tenis_time.domain.repository.SettingsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SettingsViewModel @Inject constructor(
    private val repository: SettingsRepository
): ViewModel() {

    val uiState: StateFlow<SettingsState> = repository.settingsFlow.stateIn(viewModelScope,
        SharingStarted.WhileSubscribed(5_000), SettingsState())

    fun updateSettings(state: SettingsState) = viewModelScope.launch {
        repository.save(state)
    }
}