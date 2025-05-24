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
        val mark = scoreToMark(score)
        if (rolls.size == 1) {
            first.value = mark
            return false
        }
        if (rolls.size == 2) {
            second.value = mark
            return !(isStrike() || isSpare())
        }
        if (rolls.size == 3) {
            third.value = mark
            return true
        }
        return true
    }

    private fun scoreToMark(score: Score): String {
        if (score == Score.Strike) return "X"
        if (score == Score.Spare) return "/"
        if (rolls.size == 2 && rolls.sum() == 10) return "/"
        if (score == Score.Zero) return "-"
        return score.ordinal.toString()
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
        when (score) {
            Score.Strike -> return 10
            Score.Spare -> return 10 - rolls[0]
            else -> return score.ordinal
        }
    }
}