package com.example.tenis_time.data

import android.content.Context
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.preferencesDataStore
import com.example.tenis_time.domain.model.MatchMode
import com.example.tenis_time.domain.model.SettingsState
import com.example.tenis_time.domain.model.TieBreakMode
import com.example.tenis_time.domain.repository.SettingsRepository
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.map
import javax.inject.Inject

val Context.dataStore by preferencesDataStore("SETTINGS_PREFERENCES")

class SettingsRepositoryImpl @Inject constructor(
    @ApplicationContext private val context: Context
): SettingsRepository {

    override val settingsFlow = context.dataStore.data.map { preferences ->
        SettingsState(
            matchMode = MatchMode.valueOf(
                preferences[SettingsKeys.MATCH_MODE] ?: MatchMode.THREE_SETS.name
            ),
            isAdvantageEnabled = preferences[SettingsKeys.ADVANTAGE] == true,
            tieBreakMode = TieBreakMode.valueOf(
                preferences[SettingsKeys.TIEBREAK_MODE] ?: TieBreakMode.NORMAL.name
            ),
        )
    }

    override suspend fun save(state: SettingsState) {
        context.dataStore.edit { preferences ->
            preferences[SettingsKeys.MATCH_MODE] = state.matchMode.name
            preferences[SettingsKeys.ADVANTAGE] = state.isAdvantageEnabled
            preferences[SettingsKeys.TIEBREAK_MODE] = state.tieBreakMode.name
        }
    }
}