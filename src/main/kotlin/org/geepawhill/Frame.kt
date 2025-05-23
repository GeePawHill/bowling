package org.geepawhill

import androidx.compose.runtime.mutableStateOf

class Frame(val hasThird: Boolean = false) {
    val first = mutableStateOf("")
    val second = mutableStateOf("")
    val third = mutableStateOf("")
    val total = mutableStateOf("")

    val rolls = mutableListOf<Int>()

    val available: Set<Score>
        get() {
            return Score.values().toSet()
        }

    fun roll(score: Score): Boolean {
        val pins = scoreToPins(score)
        rolls += pins
        if (rolls.size == 1) {
            first.value = pins.toString()
            return false
        }
        if (rolls.size == 2) {
            second.value = pins.toString()
            total.value = rolls.sum().toString()
        }
        return true
    }

    fun scoreToPins(score: Score): Int {
        return score.ordinal
    }
}