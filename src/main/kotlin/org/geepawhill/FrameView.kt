package org.geepawhill

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import org.geepawhill.Constants.Companion.ROLL_FONT_SIZE
import org.geepawhill.Constants.Companion.ROLL_SIZE
import org.geepawhill.Constants.Companion.THREE_FRAME_WIDTH

@Composable
fun FrameView(frame: Frame) {
    Column(Modifier.width(if (frame.hasThird) THREE_FRAME_WIDTH else Constants.FRAME_WIDTH).border(1.dp, Color.Black)) {
        Row() {
            FirstBox()
            SecondBox()
            if (frame.hasThird) ThirdBox()
        }
        Box(Modifier.fillMaxWidth(1f), contentAlignment = Alignment.Center) {
            Text(frame.score.value, fontSize = Constants.SCORE_FONT_SIZE, textAlign = TextAlign.Center)
        }
    }
}

@Composable
fun FirstBox() {
    Box(Modifier.width(ROLL_SIZE).height(ROLL_SIZE), contentAlignment = Alignment.Center) {
        Text("9", fontSize = ROLL_FONT_SIZE, textAlign = TextAlign.Center)
    }
}

@Composable
fun SecondBox() {
    Box(Modifier.width(ROLL_SIZE).height(ROLL_SIZE).border(1.dp, Color.Black), contentAlignment = Alignment.Center) {
        Text("9", fontSize = ROLL_FONT_SIZE, textAlign = TextAlign.Center)
    }
}

@Composable
fun ThirdBox() {
    Box(Modifier.width(ROLL_SIZE).height(ROLL_SIZE).border(1.dp, Color.Black), contentAlignment = Alignment.Center) {
        Text("6", fontSize = ROLL_FONT_SIZE, textAlign = TextAlign.Center)
    }
}