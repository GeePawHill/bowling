package org.geepawhill

interface Player {
    val name: String
    val frames: List<Frame>
    fun roll(score: Score)
}

class NoPlayer : Player {
    override val name = "N/A"
    override val frames = emptyList<Frame>()
    override fun roll(score: Score) {}
}

class Human(override val name: String) : Player {
    override fun roll(score: Score) {
    }

    override val frames =
        listOf(Frame(), Frame(), Frame(), Frame(), Frame(), Frame(), Frame(), Frame(), Frame(), Frame(true))
}