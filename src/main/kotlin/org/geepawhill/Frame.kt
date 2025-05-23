package org.geepawhill

import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf

enum class Score {
    Zero,
    One,
    Two,
    Three,
    Four,
    Five,
    Six,
    Seven,
    Eight,
    Nine,
    Strike,
    Spare,
    Random
}

class Frame(val hasThird: Boolean = false) {
    val first = mutableStateOf("")
    val second = mutableStateOf("")
    val third = mutableStateOf("")
    val score = mutableStateOf("")

    val available = mutableStateListOf<Score>()

    init {
        allScoresAvailable()
    }

    fun allScoresAvailable() {
        available.clear()
        available.addAll(Score.values())
    }
}