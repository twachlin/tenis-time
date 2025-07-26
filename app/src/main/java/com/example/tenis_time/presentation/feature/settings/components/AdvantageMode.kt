package com.example.tenis_time.presentation.feature.settings.components

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.example.tenis_time.R

@Composable
fun AdvantageMode(
    isAdvantageActivated: Boolean,
    modifier: Modifier = Modifier,
) {
    ChipItem(
        modifier = modifier,
        title = stringResource(R.string.advantage_title),
        text = stringResource(if (isAdvantageActivated) R.string.yes else R.string.no)
    )
}