package org.geepawhill

interface Player {
    val name: String
    val frames: List<Frame>
    fun roll(score: Score): Boolean
}

class NoPlayer : Player {
    override val name = "N/A"
    override val frames = emptyList<Frame>()
    override fun roll(score: Score) = false
}

class Human(override val name: String) : Player {

    var currentIndex = 0
    val current get() = frames[currentIndex]

    override fun roll(score: Score): Boolean {
        var base = 0
        val shouldAdvance = current.roll(score)
        for (frameIndex in 0 until currentIndex) {
            frames[frameIndex].bonus(score)
            base = frames[frameIndex].score(base)
        }
        current.score(base)
        if (shouldAdvance) {
            currentIndex += 1
            return true
        }
        return false
    }

    override val frames =
        listOf(
            NormalFrame(),
            NormalFrame(),
            NormalFrame(),
            NormalFrame(),
            NormalFrame(),
            NormalFrame(),
            NormalFrame(),
            NormalFrame(),
            NormalFrame(),
            TenthFrame()
        )
}