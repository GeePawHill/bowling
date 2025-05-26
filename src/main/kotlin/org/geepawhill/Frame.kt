package org.geepawhill

interface Frame : FrameData {
    val isTenth: Boolean
    fun possiblyComplete(scoreSoFar: Int, bonus: Roll): Int
    fun possiblyFill(scoreSoFar: Int, roll: Roll): Boolean
}