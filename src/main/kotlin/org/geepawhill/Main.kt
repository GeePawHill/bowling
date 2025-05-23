package org.geepawhill

import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.DpSize
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.*

@Composable
@Preview
fun App() {
    val model = BowlingModel()
    Column(Modifier.padding(20.dp, 0.dp)) {
        PlayersView(model.players, model.current)
        ControlsView(model)
    }
}


fun main() = application {
    val state = rememberWindowState(size = DpSize(1340.dp, 1200.dp))

    Window(
        ::exitApplication,
        state,
        title = "Bowling Game"
    ) {
        App()
    }
}
