package com.example.tenis_time.presentation.feature.home

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.example.tenis_time.presentation.feature.match.MatchActivity
import com.example.tenis_time.presentation.feature.settings.SettingsActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeActivity : ComponentActivity() {

    private val viewModel: HomeViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        installSplashScreen()

        super.onCreate(savedInstanceState)

        setTheme(android.R.style.Theme_DeviceDefault)

        setContent {
            HomeScreen(
                onSettingsClick = { navigateToSettings() },
                onPlayClick = { launchMatch() }
            )
        }
    }

    fun navigateToSettings() {
        val intent = SettingsActivity.getIntent(this)
        startActivity(intent)
    }

    fun launchMatch() {
        val settings = viewModel.settingsState.value
        val intent = MatchActivity.getIntent(context = this, settings = settings)
        startActivity(intent)
    }
}