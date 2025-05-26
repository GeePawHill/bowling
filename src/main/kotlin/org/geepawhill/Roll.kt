package org.geepawhill

enum class Roll {
    Zero,
    One,
    Two,
    Three,
    Four,
    Five,
    Six,
    Seven,
    Eight,
    Nine,
    Strike,
    Spare,
    Random;

    fun asControl(): String {
        return when (this) {
            Zero -> "-"
            One -> "1"
            Two -> "2"
            Three -> "3"
            Four -> "4"
            Five -> "5"
            Six -> "6"
            Seven -> "7"
            Eight -> "8"
            Nine -> "9"
            Strike -> "X"
            Spare -> "/"
            Random -> "*"
        }
    }
}