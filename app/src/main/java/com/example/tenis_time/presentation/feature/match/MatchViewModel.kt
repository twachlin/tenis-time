package com.example.tenis_time.presentation.feature.match

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.tenis_time.domain.model.MatchMode
import com.example.tenis_time.domain.model.SettingsState
import com.example.tenis_time.presentation.feature.match.components.GameScore
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MatchViewModel @Inject constructor() : ViewModel() {

    lateinit var settingsState: SettingsState
    var uiState: MatchState by mutableStateOf(MatchState())
}

data class MatchState(
    val matchMode: MatchMode = MatchMode.THREE_SETS,
    val scoreState: ScoreState = ScoreState()
)

data class ScoreState(
    val rivalName: String = "Them",
    val mineName: String = "Us",
    val rivalSets: List<Int> = emptyList(),
    val mineSets: List<Int> = emptyList(),
    val rivalGameScore: GameScore = GameScore.Love,
    val mineGameScore: GameScore = GameScore.Love,
    val rivalTieBreakScore: Int = 0,
    val mineTieBreakScore: Int = 0,
)