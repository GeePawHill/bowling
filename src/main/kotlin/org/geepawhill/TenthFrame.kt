package org.geepawhill

class TenthFrame() : Frame, FrameData by FrameDataDelegate() {
    override val isTenth: Boolean = true
    override fun roll(score: Score): Boolean {
        val pins = scoreToPins(score)
        rolls += pins
        val mark = scoreToMark(score)
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