package com.example.tenis_time.presentation.feature.settings

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.tenis_time.presentation.feature.settings.components.AdvantageMode
import com.example.tenis_time.presentation.feature.settings.components.MatchMode
import com.example.tenis_time.presentation.feature.settings.components.TieBreakMode

@Composable
fun SettingsScreen(
    matchMode: MatchMode,
    isAdvantageActivated: Boolean,
    tieBreakMode: TieBreakMode,
    onMatchModeClick: () -> Unit,
    onAdvantageModeClick: () -> Unit,
    onTieBreakModeClick: () -> Unit,
) {
    Column(modifier = Modifier.fillMaxWidth()) {
        MatchMode(
            matchMode = matchMode,
            modifier = Modifier
                .fillMaxWidth()
                .clickable { onMatchModeClick() }
        )
        when (matchMode) {
            MatchMode.THREE_SETS, MatchMode.FIVE_SETS -> {
                NormalMatchModeSettings(
                    isAdvantageActivated = isAdvantageActivated,
                    tieBreakMode = tieBreakMode,
                    onAdvantageModeClick = { onAdvantageModeClick() },
                    onTieBreakModeClick = { onTieBreakModeClick() },
                )
            }

            MatchMode.TIE_BREAK -> {
                TieBreakMode(
                    modifier = Modifier.clickable { onTieBreakModeClick() },
                    tieBreakMode = tieBreakMode
                )
            }
        }
    }
}

@Composable
fun NormalMatchModeSettings(
    isAdvantageActivated: Boolean,
    tieBreakMode: TieBreakMode,
    modifier: Modifier = Modifier,
    onAdvantageModeClick: () -> Unit = {},
    onTieBreakModeClick: () -> Unit = {},
) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        AdvantageMode(
            modifier = Modifier.clickable { onAdvantageModeClick() },
            isAdvantageActivated = isAdvantageActivated
        )
        TieBreakMode(
            modifier = Modifier.clickable { onTieBreakModeClick() },
            tieBreakMode = tieBreakMode
        )
    }
}