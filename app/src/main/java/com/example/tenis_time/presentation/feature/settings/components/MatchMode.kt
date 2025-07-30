package com.example.tenis_time.presentation.feature.settings.components

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.example.tenis_time.R

@Composable
fun MatchMode(
    matchMode: MatchMode,
    modifier: Modifier = Modifier
) {
    ChipItem(
        modifier = modifier,
        title = stringResource(R.string.match_mode_title),
        text = getMatchModeText(matchMode = matchMode),
    )
}

@Composable
private fun getMatchModeText(matchMode: MatchMode): String {
    return when (matchMode) {
        MatchMode.THREE_SETS -> stringResource(R.string.match_mode_3_sets_text)
        MatchMode.FIVE_SETS -> stringResource(R.string.match_mode_5_sets_text)
        MatchMode.TIE_BREAK -> stringResource(R.string.match_mode_tie_break_text)
    }
}

enum class MatchMode {
    THREE_SETS,
    FIVE_SETS,
    TIE_BREAK;
    // TODO -> PERSONALIZED,
}