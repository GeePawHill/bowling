package org.geepawhill

import androidx.compose.runtime.mutableStateOf

class FrameDataDelegate : FrameData {
    override val first = mutableStateOf("")
    override val second = mutableStateOf("")
    override val third = mutableStateOf("")
    override val total = mutableStateOf("")

    override val rolls = mutableListOf<Int>()
    override val bonuses = mutableListOf<Int>()
    override val isStrike: Boolean
        get() = rolls.isNotEmpty() && rolls[0] == 10
    override val isSpare: Boolean
        get() = rolls.size == 2 && rolls[0] + rolls[1] == 10

    override fun scoreToMark(score: Score): String {
        if (score == Score.Strike) return "X"
        if (score == Score.Spare) return "/"
        if (rolls.size == 2 && rolls.sum() == 10) return "/"
        if (score == Score.Zero) return "-"
        return score.ordinal.toString()
    }

    override fun scoreToPins(score: Score): Int {
        when (score) {
            Score.Strike -> return 10
            Score.Spare -> return 10 - rolls[0]
            else -> return score.ordinal
        }
    }

}