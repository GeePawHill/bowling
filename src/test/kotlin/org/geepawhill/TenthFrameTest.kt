package org.geepawhill

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class TenthFrameTest {
    val tenth = TenthFrame()

    @Test
    fun `tenth rolls update ball fields`() {
        tenth.possiblyFill(0, Roll.Four)
        tenth.possiblyFill(0, Roll.Spare)
        tenth.possiblyFill(0, Roll.Five)
        assertThat(tenth.third.value).isEqualTo("5")
    }

    @Test
    fun `tenth rolls no mark advance frame`() {
        assertThat(tenth.possiblyFill(0, Roll.Four)).isFalse()
        assertThat(tenth.possiblyFill(0, Roll.Five)).isTrue()
    }

    @Test
    fun `tenth rolls strike does not advance frame`() {
        assertThat(tenth.possiblyFill(0, Roll.Strike)).isFalse()
    }

    @Test
    fun `tenth rolls spare does not advance frame`() {
        assertThat(tenth.possiblyFill(0, Roll.Four)).isFalse()
        assertThat(tenth.possiblyFill(0, Roll.Spare)).isFalse()
    }

    @Test
    fun `tenth third roll advances frame`() {
        assertThat(tenth.possiblyFill(0, Roll.Four)).isFalse()
        assertThat(tenth.possiblyFill(0, Roll.Spare)).isFalse()
        assertThat(tenth.possiblyFill(0, Roll.Four)).isTrue()
    }

    @Test
    fun `complete score with two balls`() {
        tenth.possiblyFill(0, Roll.Four)
        tenth.possiblyFill(0, Roll.Five)
        assertThat(tenth.score(0)).isEqualTo(9)
        assertThat(tenth.total.value).isEqualTo("9")
    }

    @Test
    fun `complete score with strike and 2 other rolls`() {
        tenth.possiblyFill(0, Roll.Strike)
        tenth.possiblyFill(0, Roll.Four)
        tenth.possiblyFill(0, Roll.Five)
        assertThat(tenth.score(0)).isEqualTo(19)
        assertThat(tenth.total.value).isEqualTo("19")
    }

    @Test
    fun `complete score with spare and 1 other roll`() {
        tenth.possiblyFill(0, Roll.Four)
        tenth.possiblyFill(0, Roll.Spare)
        tenth.possiblyFill(0, Roll.Five)
        assertThat(tenth.score(0)).isEqualTo(15)
        assertThat(tenth.total.value).isEqualTo("15")
    }

    @Test
    fun `incomplete score with spare only`() {
        tenth.possiblyFill(0, Roll.Four)
        tenth.possiblyFill(0, Roll.Spare)
        assertThat(tenth.score(0)).isEqualTo(0)
        assertThat(tenth.total.value).isEqualTo("")
    }
}