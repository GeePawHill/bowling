package org.geepawhill

import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf

class BowlingModel {

    val players = mutableStateListOf<Player>()
    val current = mutableStateOf<Player>(NoPlayer())

    fun newGame() {
        players.clear()
        players.add(Human("GeePaw"))
        players.add(Human("Ron"))
        current.value = players[0]
    }

    fun roll(roll: Roll) {
        if (current.value.possiblyFillFrame(roll)) nextPlayer()
    }

    private fun nextPlayer() {
        val index = players.indexOf(current.value)
        if (index == -1) return
        if (index == players.size - 1) {
            current.value = players[0]
        } else current.value = players[index + 1]
    }

    fun isEnabled(roll: Roll): Boolean {
        if (roll == Roll.Six) return false
        else return true
    }


    init {
    }
}