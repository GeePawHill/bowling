package org.geepawhill

import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.*
import androidx.compose.ui.window.*
import javax.swing.text.html.CSS.Attribute.FONT_SIZE

@Composable
@Preview
fun App() {
    val model = BowlingModel()
    Column(Modifier.padding(20.dp,0.dp)) {
        PlayersView(model.players)
        ControlsView(model)
    }
}

@Composable
fun ControlsView(model: BowlingModel) {
    Row(Modifier.padding(16.dp)) {
        Column {
            Row(Modifier.padding(40.dp,16.dp)) {
                RollButton(model,0,"-")
                RollButton(model,1)
                RollButton(model,2)
                RollButton(model,3)
                RollButton(model,4)
            }
            Row(Modifier.padding(40.dp,16.dp)) {
                RollButton(model,5)
                RollButton(model,6)
                RollButton(model,7)
                RollButton(model,8)
                RollButton(model,9)
            }
            Row(Modifier.padding(40.dp,16.dp)) {
                Spacer(Modifier.width(80.dp))
                RollButton(model,0,"/") { model.spare() }
                RollButton(model,0,"X") { model.strike() }
                RollButton(model,0,"?") { model.random() }
            }
        }
        Spacer(Modifier.weight(1f))
        Column {
            Button({ model.newGame() }) {
                Text("New Game",fontSize = BUTTON_FONT_SIZE)
            }
        }
    }
}

@Composable
fun RollButton(model: BowlingModel, rollNumber: Int,text:String=rollNumber.toString(),
onClick: ()->Unit= { model.roll(rollNumber) }) {
    Button(onClick = onClick,
        shape = CircleShape,
        ) {
        Text(text, fontSize = BUTTON_FONT_SIZE)
    }
    Spacer(Modifier.width(20.dp))
}

@Composable
fun PlayersView(players: SnapshotStateList<Player>) {
    Row(modifier = Modifier.width(1300.dp)) {
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
        val color = if(player.isCurrent.value) CURRENT_COLOR else NON_CURRENT_COLOR
    Column(Modifier.background(color)) {
        Text(
            text = player.name.value,
            fontSize = NAME_SIZE
        )
        Row {
            for(frame in player.frames) {
                FrameView(frame)
            }
        }
        Spacer(modifier = Modifier.weight(.99f))
        Spacer(Modifier.height(1.dp).fillMaxWidth().background(Color.Black))
    }
}

@Composable
fun FrameView(frame: Frame) {
    Column(Modifier.width(if(frame.hasThird) THREE_FRAME_WIDTH else FRAME_WIDTH).border(1.dp,Color.Black)) {
        Row() {
            FirstBox()
            SecondBox()
            if(frame.hasThird) ThirdBox()
        }
        Box(Modifier.fillMaxWidth(1f), contentAlignment = Alignment.Center) {
            Text(frame.score.value, fontSize = SCORE_FONT_SIZE, textAlign = TextAlign.Center)
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

val PLAYER_HEIGHT = 200.dp
val NAME_SIZE = TextUnit(30f, TextUnitType.Sp)
val ROLL_SIZE = 60.dp
val ROLL_FONT_SIZE = TextUnit(25f, TextUnitType.Sp)
val SCORE_FONT_SIZE = TextUnit(35f, TextUnitType.Sp)
val FRAME_WIDTH = ROLL_SIZE*2
val THREE_FRAME_WIDTH = ROLL_SIZE*3
val CURRENT_COLOR = Color.LightGray
val NON_CURRENT_COLOR = Color.White
val BUTTON_FONT_SIZE = TextUnit(30f, TextUnitType.Sp)


fun main() = application {
    val state = rememberWindowState(size = DpSize(1300.dp, 1200.dp))

    Window(::exitApplication,
        state,
        title = "Bowling Game"
        ) {
        App()
    }
}
