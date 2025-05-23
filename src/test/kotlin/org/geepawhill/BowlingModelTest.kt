package org.geepawhill

import org.junit.jupiter.api.Test


class BowlingModelTest {

    val model = BowlingModel()

    @Test
    fun `scores simple single frame`() {
        model.newGame()
        model.roll(3)
        model.roll(5)
    }
}