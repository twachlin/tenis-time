package com.example.tenis_time.presentation.feature.commons.components

import androidx.compose.foundation.background
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.wear.compose.material.Scaffold
import androidx.wear.compose.material.TimeText
import com.example.tenis_time.presentation.theme.backgroundColor

@Composable
fun TennisScaffold(
    content: @Composable (modifier: Modifier) -> Unit,
    modifier: Modifier = Modifier,
) {
    Scaffold(
        modifier = modifier,
        timeText = {
            TimeText()
        },
        content = {
            val modifier = Modifier
                .background(color = backgroundColor)
            content(modifier)
        }
    )
}