package org.geepawhill

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class TenthFrameTest {
    val tenth = TenthFrame()

    @Test
    fun `tenth rolls update ball fields`() {
        tenth.roll(Score.Four)
        tenth.roll(Score.Spare)
        tenth.roll(Score.Five)
        assertThat(tenth.third.value).isEqualTo("5")
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
    fun `complete score with two balls`() {
        tenth.roll(Score.Four)
        tenth.roll(Score.Five)
        assertThat(tenth.score(0)).isEqualTo(9)
        assertThat(tenth.total.value).isEqualTo("9")
    }

    @Test
    fun `complete score with strike and 2 other rolls`() {
        tenth.roll(Score.Strike)
        tenth.roll(Score.Four)
        tenth.roll(Score.Five)
        assertThat(tenth.score(0)).isEqualTo(19)
        assertThat(tenth.total.value).isEqualTo("19")
    }

    @Test
    fun `complete score with spare and 1 other roll`() {
        tenth.roll(Score.Four)
        tenth.roll(Score.Spare)
        tenth.roll(Score.Five)
        assertThat(tenth.score(0)).isEqualTo(15)
        assertThat(tenth.total.value).isEqualTo("15")
    }

    @Test
    fun `incomplete score with spare only`() {
        tenth.roll(Score.Four)
        tenth.roll(Score.Spare)
        assertThat(tenth.score(0)).isEqualTo(10)
        assertThat(tenth.total.value).isEqualTo("")
    }
}