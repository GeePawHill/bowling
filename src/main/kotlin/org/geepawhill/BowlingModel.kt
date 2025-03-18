package org.geepawhill

import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf

class Player(name:String) {
    val name = mutableStateOf(name)
}

class BowlingModel {
    val players = mutableStateListOf<Player>()

    init {
        players.add(Player("GeePaw"))
        players.add(Player("Ron"))
    }
}