package org.geepawhill

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class FrameTest {
    val frame = Frame()

    @Test
    fun `simple two-roll`() {
        assertThat(frame.roll(Score.Three)).isFalse()
        assertThat(frame.roll(Score.Five)).isTrue()
        assertThat(frame.first.value).isEqualTo("3")
        assertThat(frame.second.value).isEqualTo("5")
        assertThat(frame.total.value).isEqualTo("8")
    }
}