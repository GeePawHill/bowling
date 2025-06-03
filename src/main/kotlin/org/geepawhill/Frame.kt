package org.geepawhill

interface Frame : FrameData {
    val isTenth: Boolean
    fun scoreAndReportIfComplete(scoreSoFar: Int, bonus: Int): Int
    fun isFilledAfterScoring(scoreSoFar: Int, roll: Roll): Boolean
}