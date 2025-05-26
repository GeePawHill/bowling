package org.geepawhill


class NormalFrame() : Frame, FrameData by FrameDataDelegate() {

    override val isTenth: Boolean = false

    var bonusesNeeded = 0

    override fun roll(score: Score): Boolean {
        val pins = scoreToPins(score)
        rolls += pins
        val mark = scoreToMark(score)
        if (isStrike) bonusesNeeded = 2
        if (isSpare) bonusesNeeded = 1
        if (rolls.size == 1) {
            first.value = mark
            return isStrike
        }
        second.value = mark
        return true
    }

    override fun score(base: Int): Int {
        val sum = base + local
        if (isComplete()) {
            total.value = sum.toString()
        }
        return sum
    }

    override fun bonus(score: Score) {
        if (bonusesNeeded > 0) {
            bonusesNeeded -= 1
            bonuses += scoreToPins(score)
        }
    }

    private fun isComplete(): Boolean {
        if (bonusesNeeded > 0) return false
        if (isStrike) return true
        return rolls.size == 2
    }
}


