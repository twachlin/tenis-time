package com.example.tenis_time.presentation.feature.home

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.wear.compose.material.Icon
import androidx.wear.compose.material.Scaffold
import androidx.wear.compose.material.Text
import androidx.wear.compose.material.TimeText
import com.example.tenis_time.R
import com.example.tenis_time.presentation.theme.darkGray
import com.example.tenis_time.presentation.theme.primaryGreen

@Composable
fun HomeScreen(
    onListClick: () -> Unit = {},
    onPlayClick: () -> Unit = {},
    onSettingsClick: () -> Unit = {},
) {
    Scaffold(
        timeText = {
            TimeText()
        },
        content = {
            HomeScreenContent(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal = 8.dp, vertical = 24.dp),
                onListClick = onListClick,
                onSettingsClick = onSettingsClick,
                onPlayClick = onPlayClick,
            )
        }
    )
}

@Composable
fun HomeScreenContent(
    modifier: Modifier = Modifier,
    onListClick: () -> Unit = {},
    onSettingsClick: () -> Unit = {},
    onPlayClick: () -> Unit = {},
) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Text(
            text = stringResource(R.string.home_screen_title)
        )
        Spacer(modifier = Modifier.size(24.dp))
        Row(
            modifier = Modifier,
            horizontalArrangement = Arrangement.spacedBy(2.dp)
        ) {
            RoundedIcon(
                modifier = Modifier
                    .clickable { onListClick() },
                iconRes = R.drawable.ic_list
            )
            Box(
                modifier = Modifier
                    .padding(top = 4.dp)
                    .clickable { onPlayClick() }
            ) {
                Icon(
                    modifier = Modifier
                        .size(56.dp),
                    painter = painterResource(R.drawable.ic_play),
                    contentDescription = null,
                    tint = primaryGreen
                )
            }
            RoundedIcon(
                modifier = Modifier
                    .clickable { onSettingsClick() },
                iconRes = R.drawable.ic_settings
            )
        }
    }
}

@Composable
fun RoundedIcon(
    iconRes: Int,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .clip(shape = RoundedCornerShape(100))
            .background(color = darkGray)
            .border(
                width = 1.dp,
                color = darkGray,
                shape = RoundedCornerShape(100)
            ),
        contentAlignment = Alignment.Center
    ) {
        Icon(
            modifier = Modifier.padding(8.dp),
            painter = painterResource(iconRes),
            contentDescription = null
        )
    }
}

@Preview
@Composable
private fun RoundedIconPreview() {
    RoundedIcon(iconRes = R.drawable.ic_list)
}

@Preview
@Composable
private fun HomeScreenContentPreview() {
    HomeScreenContent()
}