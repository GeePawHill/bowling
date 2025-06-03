package org.geepawhill

interface Player {
    val name: String
    val frames: List<Frame>
    fun possiblyFillFrame(roll: Roll): Boolean
}

class NoPlayer : Player {
    override val name = "N/A"
    override val frames = emptyList<Frame>()
    override fun possiblyFillFrame(roll: Roll) = false
}

class Human(override val name: String) : Player {

    var currentIndex = 0
    val current get() = frames[currentIndex]

    override fun possiblyFillFrame(roll: Roll): Boolean {
        val scoreSoFar = possiblyCompletePriorFrames(roll)
        if (current.isFilledAfterScoring(scoreSoFar, roll)) {
            currentIndex += 1
            return true
        }
        return false
    }

    private fun possiblyCompletePriorFrames(bonus: Roll): Int {
        var scoreSoFar = 0
        for (frameIndex in 0 until currentIndex) {
            scoreSoFar = frames[frameIndex].scoreAndReportIfComplete(scoreSoFar, bonus)
        }
        return scoreSoFar
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