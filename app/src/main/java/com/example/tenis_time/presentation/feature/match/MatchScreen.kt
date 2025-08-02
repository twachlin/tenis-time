package com.example.tenis_time.presentation.feature.match

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.wear.compose.material.Scaffold
import androidx.wear.compose.material.Text
import androidx.wear.compose.material.TimeText
import androidx.wear.compose.material.Vignette
import androidx.wear.compose.material.VignettePosition
import androidx.wear.tooling.preview.devices.WearDevices
import com.example.tenis_time.presentation.feature.match.components.GameScore
import com.example.tenis_time.presentation.feature.match.components.GameScoresComponent
import com.example.tenis_time.presentation.feature.match.components.SetsScore

@Composable
fun MatchScreen(
    rivalName: String = "Them",
    mineName: String = "Us",
    rivalSets: List<Int>,
    mineSets: List<Int>,
    rivalGameScore: GameScore,
    mineGameScore: GameScore,
) {
    Scaffold(
        timeText = { TimeText() },
        vignette = { Vignette(VignettePosition.TopAndBottom) },
        content = {
            MatchScreenContent(
                rivalName = rivalName,
                mineName = mineName,
                rivalSets = rivalSets,
                mineSets = mineSets,
                rivalGameScore = rivalGameScore,
                mineGameScore = mineGameScore,
            )
        }
    )
}

@Composable
fun MatchScreenContent(
    rivalName: String,
    mineName: String,
    rivalSets: List<Int>,
    mineSets: List<Int>,
    rivalGameScore: GameScore,
    mineGameScore: GameScore,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Row(
            modifier = modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceAround,
            verticalAlignment = Alignment.CenterVertically
        ) {
            MatchSetsScore(
                rivalsName = rivalName,
                mineName = mineName,
                rivalSets = rivalSets,
                mineSets = mineSets,
            )
            GameScoresComponent(
                rivalScore = rivalGameScore,
                mineScore = mineGameScore
            )
        }
    }
}

@Composable
private fun MatchSetsScore(
    rivalsName: String,
    mineName: String = "Us",
    rivalSets: List<Int>,
    mineSets: List<Int>,
) {
    Column {
        Text(
            modifier = Modifier.padding(bottom = 4.dp),
            text = rivalsName
        )
        SetsScore(sets = rivalSets)
        SetsScore(sets = mineSets)
        Text(
            modifier = Modifier.padding(top = 4.dp),
            text = mineName
        )
    }
}

@Preview(device = WearDevices.SMALL_ROUND, showSystemUi = true, showBackground = true)
@Composable
private fun MatchScreenContentPreview() {
    MatchScreen(
        rivalSets = listOf(4, 6, 3),
        mineSets = listOf(6, 3, 4),
        rivalGameScore = GameScore.Thirty,
        mineGameScore = GameScore.Forty
    )
}