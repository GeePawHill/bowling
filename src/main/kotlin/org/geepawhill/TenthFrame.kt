package org.geepawhill

class TenthFrame() : Frame, FrameData by FrameDataDelegate() {
    override val isTenth: Boolean = true

    fun score(base: Int): Int {
        if (!isComplete()) return base;
        val sum = base + local
        total.value = sum.toString()
        return sum
    }

    override fun scoreAndReportIfComplete(scoreSoFar: Int, bonus: Int): Int {
        // no bonuses in tenth frame
        return score(scoreSoFar)
    }

    override fun isFilledAfterScoring(scoreSoFar: Int, roll: Roll): Boolean {
        val isFull = roll(roll)
        score(scoreSoFar)
        return isFull
    }

    private fun isComplete(): Boolean {
        if (rolls.size == 3) return true
        if (rolls.size == 2 && !isStrike && !isSpare) return true
        return false
    }

    private fun roll(roll: Roll): Boolean {
        val pins = rollToPins(roll)
        rolls += pins
        val mark = rollToSymbol(roll)
        if (rolls.size == 1) {
            first.value = mark
            return false
        }
        if (rolls.size == 2) {
            second.value = mark
            return !(isStrike || isSpare)
        }
        if (rolls.size == 3) {
            third.value = mark
            return true
        }
        return true
    }

}