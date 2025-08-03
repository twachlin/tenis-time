package com.example.tenis_time.presentation.feature.match.components

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.wear.compose.material.Text

@Composable
fun GameScoresComponent(
    rivalScore: GameScore,
    mineScore: GameScore,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(2.dp)
    ) {
        GameScoreComponent(score = rivalScore)
        GameScoreComponent(score = mineScore)
    }
}

@Composable
fun GameScoreComponent(
    score: GameScore,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .size(40.dp)
            .clip(shape = RoundedCornerShape(25))
            .border(width = 1.dp, color = Color.Gray, shape = RoundedCornerShape(25)),
        contentAlignment = Alignment.Center,
    ) {
        Text(
            modifier = Modifier,
            text = score.value,
            fontSize = 22.sp,
            textAlign = TextAlign.Center
        )
    }
}

enum class GameScore(val value: String) {
    Love(value = "0"),
    Fifteen(value = "15"),
    Thirty(value = "30"),
    Forty(value = "40"),
    Advantage(value = "Ad");
}

@Preview
@Composable
private fun GameScoreComponentPreview() {
    GameScoreComponent(
        score = GameScore.Fifteen
    )
}

@Preview
@Composable
private fun GameScorePreview() {
    GameScoresComponent(
        rivalScore = GameScore.Love,
        mineScore = GameScore.Thirty,
    )
}