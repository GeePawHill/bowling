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
                RollButton(model, 0, "-")
                RollButton(model, 1)
                RollButton(model, 2)
                RollButton(model, 3)
                RollButton(model, 4)
            }
            Row(Modifier.padding(40.dp, 16.dp).fillMaxWidth(), horizontalArrangement = Arrangement.Center) {
                RollButton(model, 5)
                RollButton(model, 6)
                RollButton(model, 7)
                RollButton(model, 8)
                RollButton(model, 9)
            }
            Row(Modifier.padding(40.dp, 16.dp).fillMaxWidth(), horizontalArrangement = Arrangement.Center) {
                RollButton(model, 0, "/") { model.spare() }
                RollButton(model, 0, "X") { model.strike() }
                RollButton(model, 0, "?") { model.random() }
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
    model: BowlingModel, rollNumber: Int, text: String = rollNumber.toString(),
    onClick: () -> Unit = { model.roll(rollNumber) }
) {
    Button(
        onClick = onClick,
        shape = CircleShape,
    ) {
        Text(text, fontSize = BUTTON_FONT_SIZE)
    }
    Spacer(Modifier.width(20.dp))
}
