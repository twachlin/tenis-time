package com.example.tenis_time.data

import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.stringPreferencesKey

object SettingsKeys {
    val MATCH_MODE = stringPreferencesKey("match_mode")     // "3" | "5" | "TB"
    val ADVANTAGE = booleanPreferencesKey("advantage")     // true | false
    val TIEBREAK_MODE = stringPreferencesKey("tiebreak_mode")  // "NORMAL" | "SUPER"
}