package org.geepawhill

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.*

class Constants {
    companion object {
        val PLAYER_HEIGHT = 200.dp
        val NAME_SIZE = TextUnit(30f, TextUnitType.Sp)
        val ROLL_SIZE = 60.dp
        val ROLL_FONT_SIZE = TextUnit(25f, TextUnitType.Sp)
        val SCORE_FONT_SIZE = TextUnit(35f, TextUnitType.Sp)
        val FRAME_WIDTH = ROLL_SIZE * 2
        val THREE_FRAME_WIDTH = ROLL_SIZE * 3
        val CURRENT_COLOR = Color.LightGray
        val NON_CURRENT_COLOR = Color.White
        val BUTTON_FONT_SIZE = TextUnit(30f, TextUnitType.Sp)
    }
}