package org.geepawhill

import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf

class Player(name: String) {
    fun roll(score: Score) {
    }

    val isCurrent = mutableStateOf(false)
    val name = mutableStateOf(name)
    val frames = mutableStateListOf<Frame>()

    init {
        for (f in 0..8) frames.add(Frame())
        frames.add(Frame(true))
    }
}