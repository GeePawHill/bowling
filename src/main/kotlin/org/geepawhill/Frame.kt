package org.geepawhill

interface Frame : FrameData {
    val isTenth: Boolean
    fun roll(score: Score): Boolean
}