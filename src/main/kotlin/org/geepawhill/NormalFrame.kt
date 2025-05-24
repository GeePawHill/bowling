package org.geepawhill


class NormalFrame() : Frame, FrameData by FrameDataDelegate() {

    override val isTenth: Boolean = false

    override fun roll(score: Score): Boolean {
        val pins = scoreToPins(score)
        rolls += pins
        val mark = scoreToMark(score)
        if (rolls.size == 1) {
            first.value = mark
            return isStrike
        }
        second.value = mark
        return true
    }
}


