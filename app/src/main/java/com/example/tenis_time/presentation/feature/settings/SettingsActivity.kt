package com.example.tenis_time.presentation.feature.settings

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.tenis_time.presentation.feature.settings.components.MatchMode
import com.example.tenis_time.presentation.feature.settings.components.TieBreakMode

class SettingsActivity : ComponentActivity() {

    companion object {
        fun getIntent(context: Context): Intent {
            return Intent(context, SettingsActivity::class.java)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SettingsScreen(
                matchMode = MatchMode.THREE_SETS,
                isAdvantageActivated = true,
                tieBreakMode = TieBreakMode.NORMAL,
                onMatchModeClick = {},
                onAdvantageModeClick = {},
                onTieBreakModeClick = {},
            )
        }
    }
}