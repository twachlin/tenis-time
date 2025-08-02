package com.example.tenis_time.presentation.feature.match.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.wear.compose.material.Text
import androidx.wear.tooling.preview.devices.WearDevices.SMALL_ROUND

@Composable
fun SetsScore(
    sets: List<Int>,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.spacedBy(4.dp)
    ) {
        sets.forEach {
            Text(
                text = it.toString(),
                fontSize = 16.sp,
            )
        }
    }
}

@Preview(device = SMALL_ROUND)
@Composable
private fun SetsScorePreview() {
    SetsScore(
        sets = listOf(4, 6, 3),
    )
}