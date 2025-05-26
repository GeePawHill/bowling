package org.geepawhill

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class TenthFrameTest {
    val tenth = TenthFrame()

    @Test
    fun `tenth rolls update ball fields`() {
        tenth.roll(Roll.Four)
        tenth.roll(Roll.Spare)
        tenth.roll(Roll.Five)
        assertThat(tenth.third.value).isEqualTo("5")
    }

    @Test
    fun `tenth rolls no mark advance frame`() {
        assertThat(tenth.roll(Roll.Four)).isFalse()
        assertThat(tenth.roll(Roll.Five)).isTrue()
    }

    @Test
    fun `tenth rolls strike does not advance frame`() {
        assertThat(tenth.roll(Roll.Strike)).isFalse()
    }

    @Test
    fun `tenth rolls spare does not advance frame`() {
        assertThat(tenth.roll(Roll.Four)).isFalse()
        assertThat(tenth.roll(Roll.Spare)).isFalse()
    }

    @Test
    fun `tenth third roll advances frame`() {
        assertThat(tenth.roll(Roll.Four)).isFalse()
        assertThat(tenth.roll(Roll.Spare)).isFalse()
        assertThat(tenth.roll(Roll.Four)).isTrue()
    }

    @Test
    fun `complete score with two balls`() {
        tenth.roll(Roll.Four)
        tenth.roll(Roll.Five)
        assertThat(tenth.score(0)).isEqualTo(9)
        assertThat(tenth.total.value).isEqualTo("9")
    }

    @Test
    fun `complete score with strike and 2 other rolls`() {
        tenth.roll(Roll.Strike)
        tenth.roll(Roll.Four)
        tenth.roll(Roll.Five)
        assertThat(tenth.score(0)).isEqualTo(19)
        assertThat(tenth.total.value).isEqualTo("19")
    }

    @Test
    fun `complete score with spare and 1 other roll`() {
        tenth.roll(Roll.Four)
        tenth.roll(Roll.Spare)
        tenth.roll(Roll.Five)
        assertThat(tenth.score(0)).isEqualTo(15)
        assertThat(tenth.total.value).isEqualTo("15")
    }

    @Test
    fun `incomplete score with spare only`() {
        tenth.roll(Roll.Four)
        tenth.roll(Roll.Spare)
        assertThat(tenth.score(0)).isEqualTo(10)
        assertThat(tenth.total.value).isEqualTo("")
    }
}