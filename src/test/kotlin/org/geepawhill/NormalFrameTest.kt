package org.geepawhill

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class NormalFrameTest {
    val frame = Frame()

    @Test
    fun `rolls update ball fields`() {
        frame.roll(Score.Three)
        assertThat(frame.first.value).isEqualTo("3")
        frame.roll(Score.Five)
        assertThat(frame.second.value).isEqualTo("5")
    }

//    @Test
//    fun `marks update ball fields with symbol`() {
//        frame.roll(Score.Strike)
//        assertThat(frame.first.value).isEqualTo("X")
//    }

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