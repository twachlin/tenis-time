package com.example.tenis_time.presentation.feature.settings.components

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.example.tenis_time.R

@Composable
fun TieBreakMode(
    tieBreakMode: TieBreakMode,
    modifier: Modifier = Modifier
) {
    ChipItem(
        modifier = modifier,
        title = stringResource(R.string.tie_break_title),
        text = getTieBreakText(tieBreakMode = tieBreakMode),
    )
}

@Composable
private fun getTieBreakText(
    tieBreakMode: TieBreakMode,
): String {
    return when (tieBreakMode) {
        TieBreakMode.NORMAL -> stringResource(R.string.tie_break_normal_text)
        TieBreakMode.SUPER -> stringResource(R.string.tie_break_super_text)
    }
}

enum class TieBreakMode {
    NORMAL,
    SUPER;
}