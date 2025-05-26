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
    override val local: Int
        get() = rolls.sum() + bonuses.sum()

    override fun scoreToMark(roll: Roll): String {
        if (roll == Roll.Strike) return "X"
        if (roll == Roll.Spare) return "/"
        if (rolls.size == 2 && rolls.sum() == 10) return "/"
        if (roll == Roll.Zero) return "-"
        return roll.ordinal.toString()
    }

    override fun scoreToPins(roll: Roll): Int {
        when (roll) {
            Roll.Strike -> return 10
            Roll.Spare -> return 10 - rolls[0]
            else -> return roll.ordinal
        }
    }
}