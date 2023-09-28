package ua.vitolex.mathgames.presentation.screens

import android.os.CountDownTimer
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeOut
import androidx.compose.animation.scaleIn
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.navigation.NavHostController
import kotlinx.coroutines.delay
import ua.vitolex.buns.presentation.navigation.Screens
import ua.vitolex.mathgames.main.MainViewModel
import ua.vitolex.mathgames.util.scaledSp

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun PulseCountDownScreen(navController: NavHostController, viewModel: MainViewModel) {

    var time by remember {
        mutableStateOf(3000L / 1000)
    }

    var textVisible by remember { mutableStateOf(false) }

    val timer = object : CountDownTimer(3000L, 1000) {
        override fun onTick(millisUntilFinished: Long) {
            time = millisUntilFinished / 1000
        }

        override fun onFinish() {
            this.cancel()
        }
    }


    LaunchedEffect(key1 = true) {
        timer.start()

        delay(0L)
        textVisible = true

        delay(400L)
        textVisible = false

        delay(700L)
        textVisible = true

        delay(400L)
        textVisible = false
        viewModel.score = 0
        viewModel.getRandomNumberForDivide()

        delay(700L)
        textVisible = true

        delay(700L)
        navController.popBackStack()
        navController.navigate(Screens.MainScreen.rout)
    }



    Column(
        modifier = Modifier
            .fillMaxSize()
            .paint(
                painterResource(id = viewModel.background),
                contentScale = ContentScale.Crop),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        AnimatedVisibility(
            visible = textVisible,
            enter = scaleIn(animationSpec = tween(600)),
            exit = fadeOut(animationSpec = tween(600)),
        ) {
            Text(
                text = "${time + 1}",
                fontSize = 200.scaledSp(),
                modifier = Modifier
                    .fillMaxWidth(),
                textAlign = TextAlign.Center,
                style = MaterialTheme.typography.displayMedium, color = Color.White
            )
        }

    }
}