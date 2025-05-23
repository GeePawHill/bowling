package org.geepawhill

import androidx.compose.runtime.mutableStateListOf

class BowlingModel {

    fun newGame() {
    }

    fun roll(score: Score) {
    }

    fun isEnabled(score: Score): Boolean {
        if (score == Score.Six) return false
        else return true
    }

    val players = mutableStateListOf<Player>()

    init {
        players.add(Player("GeePaw"))
        players[0].isCurrent.value = true
        players.add(Player("Ron"))
    }
}