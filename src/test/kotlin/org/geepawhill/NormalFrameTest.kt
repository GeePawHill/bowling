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

    @Test
    fun `score with two rolls`() {
        frame.roll(Score.Four)
        frame.roll(Score.Five)
        assertThat(frame.score(0)).isEqualTo(9)
    }

    @Test
    fun `incomplete score with strike`() {
        frame.roll(Score.Strike)
        assertThat(frame.score(0)).isEqualTo(10)
        assertThat(frame.total.value).isEqualTo("")
    }

    @Test
    fun `complete score with strike and bonuses`() {
        frame.roll(Score.Strike)
        frame.bonus(3)
        frame.bonus(4)
        assertThat(frame.score(0)).isEqualTo(17)
        assertThat(frame.total.value).isEqualTo("17")
    }

    @Test
    fun `complete score with spare and bonus`() {
        frame.roll(Score.Three)
        frame.roll(Score.Spare)
        frame.bonus(3)
        assertThat(frame.score(0)).isEqualTo(13)
        assertThat(frame.total.value).isEqualTo("13")
    }

    @Test
    fun `incomplete score with Strike and one bonus`() {
        frame.roll(Score.Strike)
        frame.bonus(3)
        assertThat(frame.score(0)).isEqualTo(13)
    }
}