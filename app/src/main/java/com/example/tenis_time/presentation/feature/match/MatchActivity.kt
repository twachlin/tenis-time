package com.example.tenis_time.presentation.feature.match

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import com.example.tenis_time.domain.model.SettingsState
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MatchActivity : ComponentActivity() {

    companion object {
        const val SETTINGS_STATE = "settings_state"

        fun getIntent(context: Context, settings: SettingsState): Intent {
            return Intent(context, MatchActivity::class.java).apply {
                putExtra(SETTINGS_STATE, settings)
            }
        }
    }

    private val viewModel: MatchViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModel.settingsState =
            intent.getParcelableExtra(SETTINGS_STATE, SettingsState::class.java) ?: SettingsState()

        viewModel.uiState = viewModel.uiState.copy(
            matchMode = viewModel.settingsState.matchMode
        )

        setContent {
            MatchScreen(
                viewModel = viewModel,
            )
        }
    }
}