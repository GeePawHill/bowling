package org.geepawhill

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class NormalFrameTest {
    val frame = NormalFrame()

    @Test
    fun `rolls update ball fields`() {
        frame.possiblyFill(0, Roll.Three)
        assertThat(frame.first.value).isEqualTo("3")
        frame.possiblyFill(0, Roll.Five)
        assertThat(frame.second.value).isEqualTo("5")
    }

    @Test
    fun `strike update ball fields with symbol`() {
        frame.possiblyFill(0, Roll.Strike)
        assertThat(frame.first.value).isEqualTo("X")
    }

    @Test
    fun `spare update ball fields with symbol`() {
        frame.possiblyFill(0, Roll.Three)
        frame.possiblyFill(0, Roll.Seven)
        assertThat(frame.second.value).isEqualTo("/")
    }

    @Test
    fun `literal spare update ball fields with symbol`() {
        frame.possiblyFill(0, Roll.Three)
        frame.possiblyFill(0, Roll.Spare)
        assertThat(frame.second.value).isEqualTo("/")
    }

    @Test
    fun `two rolls advance frame`() {
        assertThat(frame.possiblyFill(0, Roll.Four)).isFalse()
        assertThat(frame.possiblyFill(0, Roll.Five)).isTrue()
    }

    @Test
    fun `strike advances frame`() {
        assertThat(frame.possiblyFill(0, Roll.Strike)).isTrue()
    }

    @Test
    fun `complete score with two rolls`() {
        frame.possiblyFill(0, Roll.Four)
        frame.possiblyFill(0, Roll.Five)
        assertThat(frame.completeScoreIfPossible(0)).isEqualTo(9)
    }

    @Test
    fun `incomplete score with strike and no bonuses`() {
        frame.possiblyFill(0, Roll.Strike)
        assertThat(frame.completeScoreIfPossible(0)).isEqualTo(0)
        assertThat(frame.total.value).isEqualTo("")
    }

    @Test
    fun `complete score with strike and two bonuses`() {
        frame.possiblyFill(0, Roll.Strike)
        frame.possiblyComplete(0, Roll.Three)
        frame.possiblyComplete(0, Roll.Four)
        assertThat(frame.completeScoreIfPossible(0)).isEqualTo(17)
        assertThat(frame.total.value).isEqualTo("17")
    }

    @Test
    fun `complete score with spare and bonus`() {
        frame.possiblyFill(0, Roll.Three)
        frame.possiblyFill(0, Roll.Spare)
        frame.possiblyComplete(0, Roll.Three)
        assertThat(frame.completeScoreIfPossible(0)).isEqualTo(13)
        assertThat(frame.total.value).isEqualTo("13")
    }

    @Test
    fun `incomplete score with spare and no bonus`() {
        frame.possiblyFill(0, Roll.Three)
        frame.possiblyFill(0, Roll.Spare)
        assertThat(frame.completeScoreIfPossible(0)).isEqualTo(0)
        assertThat(frame.total.value).isEqualTo("")
    }

    @Test
    fun `incomplete score with Strike and one bonus`() {
        frame.possiblyFill(0, Roll.Strike)
        frame.possiblyComplete(0, Roll.Three)
        assertThat(frame.completeScoreIfPossible(0)).isEqualTo(0)
    }
}