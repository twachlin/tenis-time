package com.example.tenis_time.presentation.feature.settings

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import com.example.tenis_time.presentation.feature.settings.components.MatchMode
import com.example.tenis_time.presentation.feature.settings.components.TieBreakMode

class SettingsScreenState(
) {
    var matchMode by mutableStateOf(MatchMode.THREE_SETS)
    var isAdvantageActivated by mutableStateOf(false)
    var tieBreakMode by mutableStateOf(TieBreakMode.NORMAL)
}