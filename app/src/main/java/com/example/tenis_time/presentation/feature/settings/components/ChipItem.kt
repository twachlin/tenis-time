package com.example.tenis_time.presentation.feature.settings.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.wear.compose.material.Text
import androidx.wear.tooling.preview.devices.WearDevices
import com.example.tenis_time.presentation.theme.darkGray

@Composable
fun ChipItem(
    title: String,
    text: String,
    modifier: Modifier = Modifier,
) {
    Box(
        modifier = modifier
            .clip(shape = RoundedCornerShape(100))
            .border(width = 1.dp, color = darkGray, shape = RoundedCornerShape(100))
            .background(color = darkGray),
    ) {
        Column(
            modifier = Modifier.fillMaxWidth().padding(horizontal = 16.dp, vertical = 8.dp)
        ){
            ChipItemTitle(text = title)
            Spacer(modifier = Modifier.size(4.dp))
            ChipItemText(text = text)
        }
    }
}

@Composable
private fun ChipItemTitle(
    text: String,
    modifier: Modifier = Modifier
) {
    Text(
        modifier = modifier,
        text = text,
        fontWeight = FontWeight.Bold,
        fontSize = 14.sp
    )
}

@Composable
private fun ChipItemText(
    text: String,
    modifier: Modifier = Modifier
) {
    Text(
        modifier = modifier,
        text = text,
        fontSize = 16.sp
    )
}

@Preview(device = WearDevices.SMALL_ROUND, showBackground = true)
@Composable
private fun ChipItemPreview() {
    ChipItem(
        title = "Tie break mode",
        text = "Normal (7)"
    )
}