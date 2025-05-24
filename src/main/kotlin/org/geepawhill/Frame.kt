package org.geepawhill

import androidx.compose.runtime.mutableStateOf

class Frame(val isTenth: Boolean = false) {
    val first = mutableStateOf("")
    val second = mutableStateOf("")
    val third = mutableStateOf("")
    val total = mutableStateOf("")

    val rolls = mutableListOf<Int>()
    val bonuses = mutableListOf<Int>()

    fun roll(score: Score): Boolean {
        return if (isTenth) tenthRoll(score)
        else normalRoll(score)
    }

    fun tenthRoll(score: Score): Boolean {
        val pins = scoreToPins(score)
        rolls += pins
        if (rolls.size == 1) {
            first.value = pins.toString()
            return false
        }
        if (rolls.size == 2) {
            second.value = pins.toString()
            return !(isStrike() || isSpare())
        }
        if (rolls.size == 3) {
            third.value = pins.toString()
            return true
        }
        return true
    }

    fun isStrike(): Boolean {
        return rolls.size > 0 && rolls[0] == 10
    }

    fun isSpare(): Boolean {
        return rolls.size == 2 && rolls.sum() == 10
    }


    fun normalRoll(score: Score): Boolean {
        val pins = scoreToPins(score)
        rolls += pins
        if (rolls.size == 1) {
            first.value = pins.toString()
            return pins == 10
        }
        second.value = pins.toString()
        return true
    }

    fun scoreToPins(score: Score): Int {
        return when (score) {
            Score.Strike -> 10
            Score.Spare -> 10 - rolls[0]
            else -> score.ordinal
        }
    }
}