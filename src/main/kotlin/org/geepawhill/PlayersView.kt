package org.geepawhill

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import org.geepawhill.Constants.Companion.CURRENT_COLOR
import org.geepawhill.Constants.Companion.NAME_SIZE
import org.geepawhill.Constants.Companion.NON_CURRENT_COLOR
import org.geepawhill.Constants.Companion.PLAYER_HEIGHT

@Composable
fun PlayersView(players: SnapshotStateList<Player>, current: MutableState<Player>) {
    Row(modifier = Modifier.width(1300.dp)) {
        LazyColumn(modifier = Modifier.weight(1f)) {
            items(players) {
                Row(modifier = Modifier.weight(1f).height(PLAYER_HEIGHT)) {
                    PlayerView(it, current)
                }
            }
        }
    }
}

@Composable
private fun PlayerView(player: Player, current: MutableState<Player>) {
    val color = if (player == current.value) CURRENT_COLOR else NON_CURRENT_COLOR
    Column(Modifier.background(color)) {
        Text(
            text = player.name,
            fontSize = NAME_SIZE
        )
        Row {
            for (frame in player.frames) {
                FrameView(frame)
            }
        }
        Spacer(modifier = Modifier.weight(.99f))
        Spacer(Modifier.height(1.dp).fillMaxWidth().background(Color.Black))
    }
}
