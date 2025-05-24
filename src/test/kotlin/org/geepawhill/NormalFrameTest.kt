package org.geepawhill

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class NormalFrameTest {
    val frame = NormalFrame()

    @Test
    fun `rolls update ball fields`() {
        frame.roll(Score.Three)
        assertThat(frame.first.value).isEqualTo("3")
        frame.roll(Score.Five)
        assertThat(frame.second.value).isEqualTo("5")
    }

    @Test
    fun `strike update ball fields with symbol`() {
        frame.roll(Score.Strike)
        assertThat(frame.first.value).isEqualTo("X")
    }

    @Test
    fun `spare update ball fields with symbol`() {
        frame.roll(Score.Three)
        frame.roll(Score.Seven)
        assertThat(frame.second.value).isEqualTo("/")
    }

    @Test
    fun `two rolls advance frame`() {
        assertThat(frame.roll(Score.Four)).isFalse()
        assertThat(frame.roll(Score.Five)).isTrue()
    }

    @Test
    fun `strike advances frame`() {
        assertThat(frame.roll(Score.Strike)).isTrue()
    }
}