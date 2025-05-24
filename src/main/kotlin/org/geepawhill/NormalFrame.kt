package org.geepawhill


class NormalFrame(override val isTenth: Boolean = false) : Frame, FrameData by FrameDataDelegate() {
    override fun roll(score: Score): Boolean {
        val pins = scoreToPins(score)
        rolls += pins
        if (rolls.size == 1) {
            first.value = pins.toString()
            return pins == 10
        }
        second.value = pins.toString()
        return true
    }
}


class TenthFrame(override val isTenth: Boolean = true) : Frame, FrameData by FrameDataDelegate() {
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