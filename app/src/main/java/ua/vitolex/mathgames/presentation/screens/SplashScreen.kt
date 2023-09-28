package ua.vitolex.buns.presentation.screen

import android.annotation.SuppressLint
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.scaleIn
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
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
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.paint
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import kotlinx.coroutines.delay
import ua.vitolex.buns.presentation.navigation.Screens
import ua.vitolex.mathgames.main.MainViewModel
import ua.vitolex.mathgames.ui.theme.cairo
import ua.vitolex.mathgames.ui.theme.exo
import ua.vitolex.mathgames.util.scaledSp


@OptIn(ExperimentalAnimationApi::class)
@SuppressLint("FlowOperatorInvokedInComposition")
@Composable
fun SplashScreen(navController: NavHostController, viewModel: MainViewModel) {

    var textVisible1 by remember { mutableStateOf(false) }
    var textVisible2 by remember { mutableStateOf(false) }
    var textVisible3 by remember { mutableStateOf(false) }
    var textVisible4 by remember { mutableStateOf(false) }
    var textVisible5 by remember { mutableStateOf(false) }
    var textVisible by remember { mutableStateOf(false) }


    var color by remember { mutableStateOf(Color.White.copy(0.9f)) }

    LaunchedEffect(key1 = true) {
        delay(200L)
        textVisible1 = true

        delay(300L)
        textVisible2 = true

        delay(300L)
        textVisible3 = true


        delay(300L)
        textVisible4 = true
        textVisible = true

        delay(300L)
        textVisible5 = true

        delay(300L)
        textVisible = true

        delay(300L)
        navController.popBackStack()
        navController.navigate(Screens.SettingsScreen.rout)
    }


    Column(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxSize()
            .paint(
                painterResource(id = viewModel.background),
                contentScale = ContentScale.Crop),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Box(modifier = Modifier.fillMaxWidth().fillMaxHeight(0.15f), contentAlignment = Alignment.CenterStart){
            androidx.compose.animation.AnimatedVisibility(
                visible = textVisible1,
                enter = scaleIn(animationSpec = tween(600)),
                exit = fadeOut(animationSpec = tween(600)),
            ) {
                Text(
                    text = "225 / 5 = 45",
                    fontSize = 24.scaledSp(),
                    modifier = Modifier
                        .padding(start = 25.dp),
                    textAlign = TextAlign.Left,
                    style = TextStyle(
                        fontFamily = cairo,
                        shadow = Shadow(
                            color = Color.White,
                            offset = Offset(0f, 0f),
                            blurRadius = 10f
                        )
                    ),
                    color = color
                )
            }
        }

        Box(modifier = Modifier.fillMaxWidth().fillMaxHeight(0.05f), contentAlignment = Alignment.CenterEnd){
            androidx.compose.animation.AnimatedVisibility(
                visible = textVisible5,
                enter = fadeIn(animationSpec = tween(600)),
                exit = fadeOut(animationSpec = tween(600)),
            ) {
                Text(
                    text = "25 / 5 = 5",
                    fontSize = 28.scaledSp(),
                    modifier = Modifier
                        .padding(end = 85.dp),
                    textAlign = TextAlign.Left,
                    style = TextStyle(
                        fontFamily = cairo,
                        shadow = Shadow(
                            color = Color.White,
                            offset = Offset(0f, 0f),
                            blurRadius = 10f
                        )
                    ),
                    color = color
                )
            }
        }
        Box(modifier = Modifier.fillMaxWidth().fillMaxHeight(0.05f), contentAlignment = Alignment.CenterStart){
            androidx.compose.animation.AnimatedVisibility(
                visible = textVisible3,
                enter = scaleIn(animationSpec = tween(600)),
                exit = fadeOut(animationSpec = tween(600)),
            ) {
                Text(
                    text = "616 - 242 = 374",
                    fontSize = 20.scaledSp(),
                    modifier = Modifier
                        .padding(start = 35.dp),
                    textAlign = TextAlign.Left,
                    style = TextStyle(
                        fontFamily = cairo,
                        shadow = Shadow(
                            color = Color.White,
                            offset = Offset(0f, 0f),
                            blurRadius = 10f
                        )
                    ),
                    color = color
                )
            }
        }
        Box(modifier = Modifier.fillMaxWidth().fillMaxHeight(0.05f), contentAlignment = Alignment.CenterEnd){
            androidx.compose.animation.AnimatedVisibility(
                visible = textVisible4,
                enter = scaleIn(animationSpec = tween(600)),
                exit = fadeOut(animationSpec = tween(600)),
            ) {
                Text(
                    text = "92 * 6 = 552",
                    fontSize = 25.scaledSp(),
                    modifier = Modifier
                        .padding(end = 25.dp),
                    textAlign = TextAlign.Right,
                    style = TextStyle(
                        fontFamily = cairo,
                        shadow = Shadow(
                            color = Color.White,
                            offset = Offset(0f, 0f),
                            blurRadius = 10f
                        )
                    ),
                    color = color
                )
            }
        }
        Box(modifier = Modifier.fillMaxWidth().fillMaxHeight(0.3f), contentAlignment = Alignment.Center){
            androidx.compose.animation.  AnimatedVisibility(
                visible = textVisible,
                enter = scaleIn(animationSpec = tween(600)),
                exit = fadeOut(animationSpec = tween(600)),
            ) {
                Text(
                    text = "MathGame",
                    fontSize = 50.scaledSp(),
                    modifier = Modifier
                        .fillMaxWidth(),
                    textAlign = TextAlign.Center,
                    style = TextStyle(
                        fontFamily = exo,
                        shadow = Shadow(
                            color = Color.White,
                            offset = Offset(0f, 0f),
                            blurRadius = 10f
                        )
                    ),
                    color = Color.White
                )
            }
        }
        Box(modifier = Modifier.fillMaxWidth().fillMaxHeight(0.15f), contentAlignment = Alignment.CenterStart){
            androidx.compose.animation.  AnimatedVisibility(
                visible = textVisible3,
                enter = fadeIn(animationSpec = tween(600)),
                exit = fadeOut(animationSpec = tween(600)),
            ) {
                Text(
                    text = "346 / 2 = 173",
                    fontSize = 25.scaledSp(),
                    modifier = Modifier
                        .padding(start = 20.dp),
                    textAlign = TextAlign.Left,
                    style = TextStyle(
                        fontFamily = cairo,
                        shadow = Shadow(
                            color = Color.White,
                            offset = Offset(0f, 0f),
                            blurRadius = 10f
                        )
                    ),
                    color = color
                )
            }
        }
        Box(modifier = Modifier.fillMaxWidth().fillMaxHeight(0.15f), contentAlignment = Alignment.CenterEnd){
            androidx.compose.animation.  AnimatedVisibility(
                visible = textVisible2,
                enter = fadeIn(animationSpec = tween(600)),
                exit = fadeOut(animationSpec = tween(600)),
            ) {
                Text(
                    text = "43 + 28 = 71",
                    fontSize = 20.scaledSp(),
                    modifier = Modifier
                        .padding(end = 25.dp),
                    textAlign = TextAlign.Left,
                    style = TextStyle(
                        fontFamily = cairo,
                        shadow = Shadow(
                            color = Color.White,
                            offset = Offset(0f, 0f),
                            blurRadius = 10f
                        )
                    ),
                    color = color
                )
            }
        }
        Box(modifier = Modifier.fillMaxWidth().fillMaxHeight(0.15f), contentAlignment = Alignment.CenterStart){
            androidx.compose.animation.  AnimatedVisibility(
                visible = textVisible3,
                enter = scaleIn(animationSpec = tween(600)),
                exit = fadeOut(animationSpec = tween(600)),
            ) {
                Text(
                    text = "343 + 628 = 971",
                    fontSize = 30.scaledSp(),
                    modifier = Modifier
                        .padding(start = 65.dp),
                    textAlign = TextAlign.Left,
                    style = TextStyle(
                        fontFamily = cairo,
                        shadow = Shadow(
                            color = Color.White,
                            offset = Offset(0f, 0f),
                            blurRadius = 10f
                        )
                    ),
                    color = color
                )
            }
        }

        Box(modifier = Modifier.fillMaxWidth().fillMaxHeight(0.35f), contentAlignment = Alignment.CenterEnd){
            androidx.compose.animation.      AnimatedVisibility(
                visible = textVisible2,
                enter = fadeIn(animationSpec = tween(600)),
                exit = fadeOut(animationSpec = tween(600)),
            ) {
                Text(
                    text = "288 - 139 = 149",
                    fontSize = 20.scaledSp(),
                    modifier = Modifier
                        .padding(end = 55.dp),
                    textAlign = TextAlign.Right,
                    style = TextStyle(
                        fontFamily = cairo,
                        shadow = Shadow(
                            color = Color.White,
                            offset = Offset(0f, 0f),
                            blurRadius = 10f
                        )
                    ),
                    color = color
                )
            }
        }
        Box(modifier = Modifier.fillMaxWidth().fillMaxHeight(), contentAlignment = Alignment.CenterStart){
            androidx.compose.animation.  AnimatedVisibility(
                visible = textVisible5,
                enter = scaleIn(animationSpec = tween(600)),
                exit = fadeOut(animationSpec = tween(600)),
            ) {
                Text(
                    text = "378 / 9 = 42",
                    fontSize = 25.scaledSp(),
                    modifier = Modifier
                        .padding(start = 15.dp),
                    textAlign = TextAlign.Left,
                    style = TextStyle(
                        fontFamily = cairo,
                        shadow = Shadow(
                            color = Color.White,
                            offset = Offset(0f, 0f),
                            blurRadius = 10f
                        )
                    ),
                    color = color
                )
            }
        }

    }
}