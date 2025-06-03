package org.geepawhill


class NormalFrame() : Frame, FrameData by FrameDataDelegate() {

    override val isTenth: Boolean = false

    private var bonusesNeeded = 0

    override fun scoreAndReportIfComplete(scoreSoFar: Int, bonus: Roll): Int {
        if (bonusesNeeded > 0) {
            bonusesNeeded -= 1
            bonuses += rollToPins(bonus)
        }
        return completeScoreIfPossible(scoreSoFar)
    }

    override fun isFilledAfterScoring(scoreSoFar: Int, roll: Roll): Boolean {
        rolls += rollToPins(roll)
        setBonusesNeeded()
        setSymbol(roll)
        completeScoreIfPossible(scoreSoFar)
        return isStrike || rolls.size == 2
    }

    fun completeScoreIfPossible(scoreSoFar: Int): Int {
        if (!isComplete()) return scoreSoFar
        val sum = scoreSoFar + local
        total.value = sum.toString()
        return sum
    }

    private fun setSymbol(roll: Roll) {
        when (rolls.size) {
            1 -> first.value = rollToSymbol(roll)
            else -> second.value = rollToSymbol(roll)
        }
    }

    private fun setBonusesNeeded() {
        if (isStrike) bonusesNeeded = 2
        if (isSpare) bonusesNeeded = 1
    }

    private fun isComplete(): Boolean {
        if (bonusesNeeded > 0) return false
        if (isStrike) return true
        return rolls.size == 2
    }
}


