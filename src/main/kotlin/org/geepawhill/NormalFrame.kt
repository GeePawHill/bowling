package org.geepawhill


class NormalFrame() : Frame, FrameData by FrameDataDelegate() {

    override val isTenth: Boolean = false

    var bonusesNeeded = 0

    override fun roll(roll: Roll): Boolean {
        val pins = scoreToPins(roll)
        rolls += pins
        val mark = scoreToMark(roll)
        if (isStrike) bonusesNeeded = 2
        if (isSpare) bonusesNeeded = 1
        if (rolls.size == 1) {
            first.value = mark
            return isStrike
        }
        second.value = mark
        return true
    }

    override fun possiblyComplete(accumulator: Int, bonus: Roll): Int {
        bonus(bonus)
        return score(accumulator)
    }

    override fun score(base: Int): Int {
        val sum = base + local
        if (isComplete()) {
            total.value = sum.toString()
        }
        return sum
    }

    override fun possiblyFill(accumulator: Int, roll: Roll): Boolean {
        val isFull = roll(roll)
        score(accumulator)
        return isFull
    }

    override fun bonus(roll: Roll) {
        if (bonusesNeeded > 0) {
            bonusesNeeded -= 1
            bonuses += scoreToPins(roll)
        }
    }

    private fun isComplete(): Boolean {
        if (bonusesNeeded > 0) return false
        if (isStrike) return true
        return rolls.size == 2
    }
}


