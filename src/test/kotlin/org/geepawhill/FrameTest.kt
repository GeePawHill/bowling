package org.geepawhill

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class FrameTest {
    val frame = Frame()
    val tenth = Frame(true)

    @Test
    fun `normal rolls update ball fields`() {
        frame.roll(Score.Three)
        assertThat(frame.first.value).isEqualTo("3")
        frame.roll(Score.Five)
        assertThat(frame.second.value).isEqualTo("5")
    }

    @Test
    fun `tenth rolls update ball fields`() {
        tenth.roll(Score.Four)
        tenth.roll(Score.Spare)
        tenth.roll(Score.Five)
        assertThat(tenth.third.value).isEqualTo("5")
    }

    @Test
    fun `normal rolls advance frame`() {
        assertThat(frame.roll(Score.Four)).isFalse()
        assertThat(frame.roll(Score.Five)).isTrue()
    }

    @Test
    fun `normal rolls advance frame on strike`() {
        assertThat(frame.roll(Score.Strike)).isTrue()
    }

    @Test
    fun `tenth rolls no mark advance frame`() {
        assertThat(tenth.roll(Score.Four)).isFalse()
        assertThat(tenth.roll(Score.Five)).isTrue()
    }

    @Test
    fun `tenth rolls strike does not advance frame`() {
        assertThat(tenth.roll(Score.Strike)).isFalse()
    }

    @Test
    fun `tenth rolls spare does not advance frame`() {
        assertThat(tenth.roll(Score.Four)).isFalse()
        assertThat(tenth.roll(Score.Spare)).isFalse()
    }

    @Test
    fun `tenth third roll advances frame`() {
        assertThat(tenth.roll(Score.Four)).isFalse()
        assertThat(tenth.roll(Score.Spare)).isFalse()
        assertThat(tenth.roll(Score.Four)).isTrue()
    }


    @Test
    fun `strike advances frame`() {
        assertThat(frame.roll(Score.Strike)).isTrue()
    }
}