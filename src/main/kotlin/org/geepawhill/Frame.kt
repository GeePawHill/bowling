package org.geepawhill

interface Frame : FrameData {
    val isTenth: Boolean
    fun roll(roll: Roll): Boolean
    fun possiblyComplete(accumulator: Int, bonus: Roll): Int
    fun score(base: Int): Int
    fun possiblyFill(accumulator: Int, roll: Roll): Boolean
}