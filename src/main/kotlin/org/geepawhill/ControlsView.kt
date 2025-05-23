package org.geepawhill

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import org.geepawhill.Constants.Companion.BUTTON_FONT_SIZE

@Composable
fun ControlsView(model: BowlingModel) {
    Row(Modifier.padding(16.dp).fillMaxWidth(), horizontalArrangement = Arrangement.Center) {
        Column {
            Row(Modifier.padding(40.dp, 16.dp).fillMaxWidth(), horizontalArrangement = Arrangement.Center) {
                RollButton(model, score = Score.Zero)
                RollButton(model, score = Score.One)
                RollButton(model, score = Score.Two)
                RollButton(model, score = Score.Three)
                RollButton(model, score = Score.Four)
            }
            Row(Modifier.padding(40.dp, 16.dp).fillMaxWidth(), horizontalArrangement = Arrangement.Center) {
                RollButton(model, score = Score.Five)
                RollButton(model, score = Score.Six)
                RollButton(model, score = Score.Seven)
                RollButton(model, score = Score.Eight)
                RollButton(model, score = Score.Nine)
            }
            Row(Modifier.padding(40.dp, 16.dp).fillMaxWidth(), horizontalArrangement = Arrangement.Center) {
                RollButton(model, Score.Spare)
                RollButton(model, Score.Strike)
                RollButton(model, Score.Random)
            }
            Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center) {
                Button({ model.newGame() }) {
                    Text("New Game", fontSize = BUTTON_FONT_SIZE)
                }
            }
        }
    }
}

@Composable
fun RollButton(
    model: BowlingModel, score: Score
) {
    Button(
        onClick = { model.roll(score) },
        shape = CircleShape,
        enabled = model.isEnabled(score)
    ) {
        Text(score.asControl(), fontSize = BUTTON_FONT_SIZE)
    }
    Spacer(Modifier.width(20.dp))
}
