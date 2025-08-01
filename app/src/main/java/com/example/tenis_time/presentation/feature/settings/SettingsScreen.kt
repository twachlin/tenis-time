package com.example.tenis_time.presentation.feature.settings

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.wear.compose.foundation.lazy.AutoCenteringParams
import androidx.wear.compose.foundation.lazy.ScalingLazyColumn
import androidx.wear.compose.foundation.lazy.ScalingLazyListState
import androidx.wear.compose.foundation.lazy.rememberScalingLazyListState
import com.example.tenis_time.presentation.feature.commons.components.TennisScaffold
import com.example.tenis_time.presentation.feature.settings.components.AdvantageMode
import com.example.tenis_time.presentation.feature.settings.components.MatchMode
import com.example.tenis_time.presentation.feature.settings.components.TieBreakMode

@Composable
fun SettingsScreen(
    state: SettingsScreenState,
    onMatchModeClick: () -> Unit,
    onAdvantageModeClick: () -> Unit,
    onTieBreakModeClick: () -> Unit,
) {
    val listState = rememberScalingLazyListState(
        initialCenterItemIndex = 0
    )
    TennisScaffold(
        content = { modifier ->
            SettingsScreenContent(
                modifier = modifier,
                state = state,
                listState = listState,
                onMatchModeClick = onMatchModeClick,
                onAdvantageModeClick = onAdvantageModeClick,
                onTieBreakModeClick = onTieBreakModeClick,
            )
        }
    )
}

@Composable
fun SettingsScreenContent(
    state: SettingsScreenState,
    listState: ScalingLazyListState,
    onMatchModeClick: () -> Unit,
    onAdvantageModeClick: () -> Unit,
    onTieBreakModeClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    ScalingLazyColumn(
        modifier = modifier,
        state = listState,
        autoCentering = AutoCenteringParams(itemIndex = 0),
        contentPadding = PaddingValues(vertical = 16.dp, horizontal = 8.dp),
        verticalArrangement = Arrangement.spacedBy(4.dp),
        content = {
            item {
                MatchMode(
                    matchMode = state.matchMode,
                    modifier = Modifier
                        .fillMaxWidth()
                        .clickable { onMatchModeClick() }
                )
            }
            item {
                when (state.matchMode) {
                    MatchMode.THREE_SETS, MatchMode.FIVE_SETS -> {
                        NormalMatchModeSettings(
                            isAdvantageActivated = state.isAdvantageActivated,
                            tieBreakMode = state.tieBreakMode,
                            onAdvantageModeClick = { onAdvantageModeClick() },
                            onTieBreakModeClick = { onTieBreakModeClick() },
                        )
                    }

                    MatchMode.TIE_BREAK -> {
                        TieBreakMode(
                            modifier = Modifier.clickable { onTieBreakModeClick() },
                            tieBreakMode = state.tieBreakMode
                        )
                    }
                }
            }
        }
    )
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

@Preview
@Composable
private fun Prueba() {
}