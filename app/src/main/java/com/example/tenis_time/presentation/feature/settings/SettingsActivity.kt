package com.example.tenis_time.presentation.feature.settings

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.runtime.collectAsState
import com.example.tenis_time.presentation.utils.extensions.nextEnum
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SettingsActivity : ComponentActivity() {

    companion object {
        fun getIntent(context: Context): Intent {
            return Intent(context, SettingsActivity::class.java)
        }
    }

    val viewModel: SettingsViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            var uiState = viewModel.uiState.collectAsState()
            SettingsScreen(
                state = uiState.value,
                onMatchModeClick = {
                    viewModel.updateSettings(
                        state = uiState.value.copy(
                            matchMode = uiState.value.matchMode.nextEnum()
                        )
                    )
                },
                onAdvantageModeClick = {
                    viewModel.updateSettings(
                        state = uiState.value.copy(
                            isAdvantageEnabled = !(uiState.value.isAdvantageEnabled)
                        )
                    )
                },
                onTieBreakModeClick = {
                    viewModel.updateSettings(
                        state = uiState.value.copy(
                            tieBreakMode = uiState.value.tieBreakMode.nextEnum()
                        )
                    )
                }
            )
        }
    }
}