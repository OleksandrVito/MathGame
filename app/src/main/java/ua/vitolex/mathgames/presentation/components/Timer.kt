package ua.vitolex.mathgames.presentation.components


import android.os.CountDownTimer
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.layout.onSizeChanged
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.IntSize
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import ua.vitolex.mathgames.main.MainViewModel
import ua.vitolex.mathgames.util.scaledSp

@Composable
fun Timer(
    inactiveBarColor: Color,
    activeBarColor: Color,
    modifier: Modifier = Modifier,
    strokeWidth: Dp = 5.dp,
    viewModel: MainViewModel,
) {

    var size by remember {
        mutableStateOf(IntSize.Zero)
    }

    var time by remember {
        mutableStateOf(viewModel.totalTime / 1000)
    }

    var context = LocalContext.current
    var scope = rememberCoroutineScope()

    val timer = object : CountDownTimer(viewModel.totalTime, 1000) {
        override fun onTick(millisUntilFinished: Long) {
            if (viewModel.startTimer == false) this.cancel()
            if (viewModel.startTimer == true) time = millisUntilFinished / 1000
            if (millisUntilFinished / 1000 == 0L) {
                viewModel.startTimer = false
            }
            viewModel.value = time * 1000 / viewModel.totalTime.toFloat()
        }

        override fun onFinish() {
            // do something
            viewModel.showDialog = true
            scope.launch {
                if (viewModel.mapScores["${viewModel.level}${viewModel.totalTime / 1000}"] == "null" || viewModel.score > viewModel.mapScores["${viewModel.level}${viewModel.totalTime / 1000}"]!!.toInt()) {
                    viewModel.saveSettings(
                        context,
                        "${viewModel.score}",
                        "${viewModel.level}${viewModel.totalTime / 1000}"
                    )
                }

            }
        }
    }
    LaunchedEffect(key1 = true) {
        viewModel.value = time * 1000 / viewModel.totalTime.toFloat()
        delay(1000L)
        if (viewModel.startTimer == false) {
            timer.start()
            viewModel.startTimer = true
        }
        viewModel.startTimer = true
    }

    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Box(
            contentAlignment = Alignment.Center,
            modifier = modifier
                .onSizeChanged {
                    size = it
                }
                .padding(end = 0.dp),
        ) {
            Canvas(modifier = modifier) {
                drawArc(
                    color = inactiveBarColor,
                    startAngle = -90f,
                    sweepAngle = 360f,
                    useCenter = false,
                    size = Size(size.width.toFloat(), size.height.toFloat()),
                    style = Stroke(2.dp.toPx(), cap = StrokeCap.Butt)
                )
                drawArc(
                    color = activeBarColor,
                    startAngle = -90f,
                    sweepAngle = 360f * viewModel.value,
                    useCenter = false,
                    size = Size(size.width.toFloat(), size.height.toFloat()),
                    style = Stroke(strokeWidth.toPx(), cap = StrokeCap.Round)
                )

            }
            Text(
                text = "${addZero(time / 60)} : ${addZero(time % 60)}",
                fontSize = 25.scaledSp(),
                textAlign = TextAlign.Center,
                style = MaterialTheme.typography.displayMedium,
                modifier = Modifier.fillMaxWidth()

            )

        }
    }
}

fun addZero(num: Long): String {
    return if (num.toString().length < 2) "0$num" else num.toString()
}