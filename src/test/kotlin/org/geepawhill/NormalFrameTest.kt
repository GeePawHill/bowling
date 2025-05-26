package org.geepawhill

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class NormalFrameTest {
    val frame = NormalFrame()

    @Test
    fun `rolls update ball fields`() {
        frame.roll(Roll.Three)
        assertThat(frame.first.value).isEqualTo("3")
        frame.roll(Roll.Five)
        assertThat(frame.second.value).isEqualTo("5")
    }

    @Test
    fun `strike update ball fields with symbol`() {
        frame.roll(Roll.Strike)
        assertThat(frame.first.value).isEqualTo("X")
    }

    @Test
    fun `spare update ball fields with symbol`() {
        frame.roll(Roll.Three)
        frame.roll(Roll.Seven)
        assertThat(frame.second.value).isEqualTo("/")
    }

    @Test
    fun `two rolls advance frame`() {
        assertThat(frame.roll(Roll.Four)).isFalse()
        assertThat(frame.roll(Roll.Five)).isTrue()
    }

    @Test
    fun `strike advances frame`() {
        assertThat(frame.roll(Roll.Strike)).isTrue()
    }

    @Test
    fun `complete score with two rolls`() {
        frame.roll(Roll.Four)
        frame.roll(Roll.Five)
        assertThat(frame.score(0)).isEqualTo(9)
    }

    @Test
    fun `incomplete score with strike and no bonuses`() {
        frame.roll(Roll.Strike)
        assertThat(frame.score(0)).isEqualTo(10)
        assertThat(frame.total.value).isEqualTo("")
    }

    @Test
    fun `complete score with strike and two bonuses`() {
        frame.roll(Roll.Strike)
        frame.bonus(Roll.Three)
        frame.bonus(Roll.Four)
        assertThat(frame.score(0)).isEqualTo(17)
        assertThat(frame.total.value).isEqualTo("17")
    }

    @Test
    fun `complete score with spare and bonus`() {
        frame.roll(Roll.Three)
        frame.roll(Roll.Spare)
        frame.bonus(Roll.Three)
        assertThat(frame.score(0)).isEqualTo(13)
        assertThat(frame.total.value).isEqualTo("13")
    }

    @Test
    fun `incomplete score with spare and no bonus`() {
        frame.roll(Roll.Three)
        frame.roll(Roll.Spare)
        assertThat(frame.score(0)).isEqualTo(10)
        assertThat(frame.total.value).isEqualTo("")
    }

    @Test
    fun `incomplete score with Strike and one bonus`() {
        frame.roll(Roll.Strike)
        frame.bonus(Roll.Three)
        assertThat(frame.score(0)).isEqualTo(13)
    }
}