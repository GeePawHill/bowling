package org.geepawhill

import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.WindowPlacement
import androidx.compose.ui.window.application
import androidx.compose.ui.window.rememberWindowState

@Composable
@Preview
fun App() {
    val model = BowlingModel()
    PlayersView(model.players)
}

@Composable
fun PlayersView(players: SnapshotStateList<Player>) {
    Row(modifier = Modifier.fillMaxWidth()) {
        LazyColumn(modifier = Modifier.weight(1f)) {
            items(players) {
                Row(modifier = Modifier.weight(1f).height(PLAYER_HEIGHT)) {
                    PlayerView(it)
                }
            }
        }
    }
}

@Composable
private fun PlayerView(player: Player) {
    Column {
        Text(
            text = player.name.value,
            fontSize = NAME_SIZE
        )
        Spacer(modifier = Modifier.weight(.99f))
        Spacer(Modifier.height(1.dp).fillMaxWidth().background(Color.Black))
    }
}

val PLAYER_HEIGHT = 200.dp
val NAME_SIZE = TextUnit(30f, TextUnitType.Sp)


fun main() = application {
    val state = rememberWindowState(placement = WindowPlacement.Maximized)

    Window(::exitApplication,
        state,
        title = "Bowling Game"
        ) {
        App()
    }
}
