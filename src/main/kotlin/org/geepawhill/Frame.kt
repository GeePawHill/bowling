package org.geepawhill

import androidx.compose.runtime.mutableStateOf

class Frame(val hasThird: Boolean = false) {
    val first = mutableStateOf("")
    val second = mutableStateOf("")
    val third = mutableStateOf("")
    val score = mutableStateOf("")

    val available: Set<Score>
        get() {
            return Score.values().toSet()
        }

    init {
    }
}