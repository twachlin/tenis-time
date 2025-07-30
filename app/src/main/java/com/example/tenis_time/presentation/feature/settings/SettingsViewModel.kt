package com.example.tenis_time.presentation.feature.settings

import androidx.lifecycle.ViewModel
import com.example.tenis_time.presentation.utils.extensions.nextEnum

class SettingsViewModel: ViewModel() {

    val state = SettingsScreenState()

    fun onMatchModeClicked() {
        state.matchMode = state.matchMode.nextEnum()
    }

    fun onAdvantageModeClicked() {
        state.isAdvantageActivated = !state.isAdvantageActivated
    }

    fun onTieBreakModeClick() {
        state.tieBreakMode = state.tieBreakMode.nextEnum()
    }
}