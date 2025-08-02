package com.example.tenis_time.domain.model

data class SettingsState(
    val matchMode: MatchMode = MatchMode.THREE_SETS,
    val isAdvantageEnabled: Boolean = false,
    val tieBreakMode: TieBreakMode = TieBreakMode.NORMAL,
)