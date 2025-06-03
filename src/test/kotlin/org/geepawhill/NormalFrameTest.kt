package org.geepawhill

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class NormalFrameTest {
    val frame = NormalFrame()

    @Test
    fun `rolls update ball fields`() {
        frame.isFilledAfterScoring(0, Roll.Three)
        assertThat(frame.first.value).isEqualTo("3")
        frame.isFilledAfterScoring(0, Roll.Five)
        assertThat(frame.second.value).isEqualTo("5")
    }

    @Test
    fun `strike update ball fields with symbol`() {
        frame.isFilledAfterScoring(0, Roll.Strike)
        assertThat(frame.first.value).isEqualTo("X")
    }

    @Test
    fun `spare update ball fields with symbol`() {
        frame.isFilledAfterScoring(0, Roll.Three)
        frame.isFilledAfterScoring(0, Roll.Seven)
        assertThat(frame.second.value).isEqualTo("/")
    }

    @Test
    fun `literal spare update ball fields with symbol`() {
        frame.isFilledAfterScoring(0, Roll.Three)
        frame.isFilledAfterScoring(0, Roll.Spare)
        assertThat(frame.second.value).isEqualTo("/")
    }

    @Test
    fun `two rolls advance frame`() {
        assertThat(frame.isFilledAfterScoring(0, Roll.Four)).isFalse()
        assertThat(frame.isFilledAfterScoring(0, Roll.Five)).isTrue()
    }

    @Test
    fun `strike advances frame`() {
        assertThat(frame.isFilledAfterScoring(0, Roll.Strike)).isTrue()
    }

    @Test
    fun `complete score with two rolls`() {
        frame.isFilledAfterScoring(0, Roll.Four)
        frame.isFilledAfterScoring(0, Roll.Five)
        assertThat(frame.completeScoreIfPossible(0)).isEqualTo(9)
    }

    @Test
    fun `incomplete score with strike and no bonuses`() {
        frame.isFilledAfterScoring(0, Roll.Strike)
        assertThat(frame.completeScoreIfPossible(0)).isEqualTo(0)
        assertThat(frame.total.value).isEqualTo("")
    }

    @Test
    fun `complete score with strike and two bonuses`() {
        frame.isFilledAfterScoring(0, Roll.Strike)
        frame.scoreAndReportIfComplete(0, 3)
        frame.scoreAndReportIfComplete(0, 4)
        assertThat(frame.completeScoreIfPossible(0)).isEqualTo(17)
        assertThat(frame.total.value).isEqualTo("17")
    }

    @Test
    fun `complete score with spare and bonus`() {
        frame.isFilledAfterScoring(0, Roll.Three)
        frame.isFilledAfterScoring(0, Roll.Spare)
        frame.scoreAndReportIfComplete(0, 3)
        assertThat(frame.completeScoreIfPossible(0)).isEqualTo(13)
        assertThat(frame.total.value).isEqualTo("13")
    }

    @Test
    fun `incomplete score with spare and no bonus`() {
        frame.isFilledAfterScoring(0, Roll.Three)
        frame.isFilledAfterScoring(0, Roll.Spare)
        assertThat(frame.completeScoreIfPossible(0)).isEqualTo(0)
        assertThat(frame.total.value).isEqualTo("")
    }

    @Test
    fun `incomplete score with Strike and one bonus`() {
        frame.isFilledAfterScoring(0, Roll.Strike)
        frame.scoreAndReportIfComplete(0, 3)
        assertThat(frame.completeScoreIfPossible(0)).isEqualTo(0)
    }

    @Test
    fun `discovered score with Strike and one bonus`() {
        frame.isFilledAfterScoring(0, Roll.Strike)
        frame.scoreAndReportIfComplete(0, 0)
        frame.scoreAndReportIfComplete(0, 10)
        assertThat(frame.total.value).isEqualTo("20")
    }


}