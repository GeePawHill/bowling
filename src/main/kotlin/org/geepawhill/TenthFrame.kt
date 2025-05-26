package org.geepawhill

class TenthFrame() : Frame, FrameData by FrameDataDelegate() {
    override val isTenth: Boolean = true
    override fun roll(roll: Roll): Boolean {
        val pins = scoreToPins(roll)
        rolls += pins
        val mark = scoreToMark(roll)
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

    override fun score(base: Int): Int {
        val sum = base + local
        if (isComplete()) {
            total.value = sum.toString()
        }
        return sum
    }

    override fun possiblyComplete(accumulator: Int, bonus: Roll): Int {
        // no bonuses in tenth frame
        return score(accumulator)
    }

    override fun bonus(roll: Roll) {
    }

    override fun possiblyFill(accumulator: Int, roll: Roll): Boolean {
        val isFull = roll(roll)
        score(accumulator)
        return isFull
    }

    private fun isComplete(): Boolean {
        if (rolls.size == 3) return true
        if (rolls.size == 2 && !isStrike && !isSpare) return true
        return false
    }
}