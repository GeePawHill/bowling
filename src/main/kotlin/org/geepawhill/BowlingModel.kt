package org.geepawhill

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf

class Frame(val hasThird: Boolean=false) {
    val score = mutableStateOf("8")
}

class Player(name:String) {
    val isCurrent = mutableStateOf(false)
    val name = mutableStateOf(name)
    val frames = mutableStateListOf<Frame>()

    init {
        for(f in 0..8 ) frames.add(Frame())
        frames.add(Frame(true))
    }
}

class BowlingModel {
    fun newGame() {
    }

    val players = mutableStateListOf<Player>()

    init {
        players.add(Player("GeePaw"))
        players[0].isCurrent.value = true
        players.add(Player("Ron"))
    }
}