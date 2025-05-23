package org.geepawhill

import androidx.compose.runtime.mutableStateOf

class Frame(val hasThird: Boolean = false) {
    val score = mutableStateOf("8")
}