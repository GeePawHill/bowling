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
            FirstBox(frame)
            SecondBox(frame)
            if (frame.hasThird) ThirdBox(frame)
        }
        Box(Modifier.fillMaxWidth(1f), contentAlignment = Alignment.Center) {
            Text(frame.score.value, fontSize = Constants.SCORE_FONT_SIZE, textAlign = TextAlign.Center)
        }
    }
}

@Composable
fun FirstBox(frame: Frame) {
    Box(Modifier.width(ROLL_SIZE).height(ROLL_SIZE), contentAlignment = Alignment.Center) {
        Text(frame.first.value, fontSize = ROLL_FONT_SIZE, textAlign = TextAlign.Center)
    }
}

@Composable
fun SecondBox(frame: Frame) {
    Box(Modifier.width(ROLL_SIZE).height(ROLL_SIZE).border(1.dp, Color.Black), contentAlignment = Alignment.Center) {
        Text(frame.second.value, fontSize = ROLL_FONT_SIZE, textAlign = TextAlign.Center)
    }
}

@Composable
fun ThirdBox(frame: Frame) {
    Box(Modifier.width(ROLL_SIZE).height(ROLL_SIZE).border(1.dp, Color.Black), contentAlignment = Alignment.Center) {
        Text(frame.third.value, fontSize = ROLL_FONT_SIZE, textAlign = TextAlign.Center)
    }
}