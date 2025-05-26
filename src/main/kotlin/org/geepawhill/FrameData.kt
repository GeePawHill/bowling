package org.geepawhill

import androidx.compose.runtime.MutableState

interface FrameData {
    val first: MutableState<String>
    val second: MutableState<String>
    val third: MutableState<String>
    val total: MutableState<String>
    val rolls: MutableList<Int>
    val bonuses: MutableList<Int>

    val isStrike: Boolean
    val isSpare: Boolean

    fun rollToSymbol(roll: Roll): String
    fun rollToPins(roll: Roll): Int
    val local: Int
}