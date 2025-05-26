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
                RollButton(model, roll = Roll.Zero)
                RollButton(model, roll = Roll.One)
                RollButton(model, roll = Roll.Two)
                RollButton(model, roll = Roll.Three)
                RollButton(model, roll = Roll.Four)
            }
            Row(Modifier.padding(40.dp, 16.dp).fillMaxWidth(), horizontalArrangement = Arrangement.Center) {
                RollButton(model, roll = Roll.Five)
                RollButton(model, roll = Roll.Six)
                RollButton(model, roll = Roll.Seven)
                RollButton(model, roll = Roll.Eight)
                RollButton(model, roll = Roll.Nine)
            }
            Row(Modifier.padding(40.dp, 16.dp).fillMaxWidth(), horizontalArrangement = Arrangement.Center) {
                RollButton(model, Roll.Spare)
                RollButton(model, Roll.Strike)
                RollButton(model, Roll.Random)
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
    model: BowlingModel, roll: Roll
) {
    Button(
        onClick = { model.roll(roll) },
        shape = CircleShape,
        enabled = model.isEnabled(roll)
    ) {
        Text(roll.asControl(), fontSize = BUTTON_FONT_SIZE)
    }
    Spacer(Modifier.width(20.dp))
}
