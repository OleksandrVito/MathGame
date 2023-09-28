package ua.vitolex.mathgames.presentation.screens

import android.annotation.SuppressLint
import androidx.activity.compose.BackHandler
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeOut
import androidx.compose.animation.scaleIn
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawWithCache
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.BlendMode
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.BaselineShift
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import ua.vitolex.buns.presentation.navigation.Screens
import ua.vitolex.mathgames.R
import ua.vitolex.mathgames.main.MainViewModel
import ua.vitolex.mathgames.presentation.components.BannerAdView
import ua.vitolex.mathgames.presentation.components.CustomDialog
import ua.vitolex.mathgames.presentation.components.KeyboardButton
import ua.vitolex.mathgames.presentation.components.LightGrayGradient
import ua.vitolex.mathgames.presentation.components.Timer
import ua.vitolex.mathgames.ui.theme.cairo
import ua.vitolex.mathgames.ui.theme.exo
import ua.vitolex.mathgames.util.scaledSp
import kotlin.NumberFormatException
import kotlin.OptIn


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class, ExperimentalAnimationApi::class)
@Composable
fun MainScreen(
    navController: NavHostController,
    viewModel: MainViewModel,
) {
    var numRes by remember {
        mutableStateOf("")
    }
    var color by remember {
        mutableStateOf(Color.Black)
    }

    val scope = rememberCoroutineScope()

    var textVisible by remember { mutableStateOf(true) }

    if (viewModel.showDialog)
        CustomDialog(
            setShowDialog = {
                viewModel.showDialog = it
            },
            navController = navController,
            viewModel = viewModel
        )
    fun updateResult() {
        try {
            when (viewModel.currentOperation.value) {
                "+" -> {
                    if (viewModel.numFirst.value + viewModel.numSecond.value == numRes.toInt()) {
                        color = Color(android.graphics.Color.parseColor("#299617"))

                        viewModel.getRandomNumberForDivide()
                        if (viewModel.startTimer) viewModel.score =
                            viewModel.score + 1
                        scope.launch {
                            delay(200)
                            textVisible = false
                            delay(300)
                            viewModel.updateResult("C")
                            textVisible = true
                        }
                    } else color = Color.Red
                }

                "-" -> {
                    if (viewModel.numFirst.value - viewModel.numSecond.value == numRes.toInt()) {
                        color = Color(android.graphics.Color.parseColor("#006400"))
                        viewModel.getRandomNumberForDivide()
                        if (viewModel.startTimer) viewModel.score =
                            viewModel.score + 1
                        scope.launch {
                            delay(200)
                            textVisible = false
                            delay(300)
                            viewModel.updateResult("C")
                            textVisible = true
                        }
                    } else color = Color.Red
                }

                "*" -> {
                    if (viewModel.numFirst.value * viewModel.numSecond.value == numRes.toInt()) {
                        color = Color(android.graphics.Color.parseColor("#006400"))
                        viewModel.getRandomNumberForDivide()
                        if (viewModel.startTimer) viewModel.score =
                            viewModel.score + 1
                        scope.launch {
                            delay(200)
                            textVisible = false
                            delay(300)
                            viewModel.updateResult("C")
                            textVisible = true
                        }
                    } else color = Color.Red
                }

                "/" -> {
                    if (viewModel.numFirst.value / viewModel.numSecond.value == numRes.toInt()) {
                        color = Color(android.graphics.Color.parseColor("#006400"))
                        viewModel.getRandomNumberForDivide()
                        if (viewModel.startTimer) viewModel.score =
                            viewModel.score + 1
                        scope.launch {
                            delay(200)
                            textVisible = false
                            delay(300)
                            viewModel.updateResult("C")
                            textVisible = true
                        }
                    } else color = Color.Red
                }
            }

        } catch (e: NumberFormatException) {

        }
    }

    BackHandler(enabled = true, onBack = {
        navController.popBackStack(Screens.SettingsScreen.rout, false)
        viewModel.startTimer = false
    })
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = {},
                navigationIcon = {
                    IconButton(
                        onClick = {
                            navController.navigate(Screens.SettingsScreen.rout)
                            viewModel.startTimer = false
                        }
                    ) {
                        Icon(
                            imageVector = Icons.Default.ArrowBack,
                            contentDescription = "ArrowBack",

                            modifier = Modifier
                                .size(28.dp)
                                .graphicsLayer(alpha = 0.99f)
                                .drawWithCache {
                                    onDrawWithContent {
                                        drawContent()
                                        drawRect(LightGrayGradient, blendMode = BlendMode.SrcAtop)
                                    }
                                },
                        )
                    }
                },
                actions = {},
                colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                    containerColor = Color.Transparent
                )
            )
        },
        containerColor = Color.Transparent,
        modifier = Modifier
            .paint(
                painterResource(id = viewModel.background),
                contentScale = ContentScale.Crop
            )
            .padding(top = 0.dp, start = 20.dp, end = 20.dp, bottom = 20.dp)
    ) {
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 60.dp)
                .clip(RoundedCornerShape(8.dp))
                .background(
                    Brush.verticalGradient(
                        listOf(
                            Color(0x80ffffff),
                            Color.Transparent
                        )
                    )
                ),
            verticalArrangement = Arrangement.SpaceBetween,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            item {
                Spacer(modifier = Modifier.height(30.dp))
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Timer(
                        inactiveBarColor = Color(
                            android.graphics.Color.parseColor(
                                "#404258"
                            )
                        ),
                        activeBarColor = Color(
                            android.graphics.Color.parseColor(
                                "#F45050"
                            )
                        ),
                        modifier = Modifier.size(100.dp),
                        viewModel = viewModel
                    )
                }
                Spacer(modifier = Modifier.height(5.dp))
            }

            item {
                Text(
                    text = buildAnnotatedString {
                        withStyle(
                            style = SpanStyle(
                                fontFamily = exo,
                                fontWeight = FontWeight.Normal,
                                fontSize = 22.scaledSp(),
                            )
                        ) {
                            append(stringResource(R.string.Score))
                        }
                        withStyle(
                            style = SpanStyle(
                                fontFamily = cairo,
                                fontWeight = FontWeight.Normal,
                                fontSize = 22.scaledSp(),
                                baselineShift = BaselineShift(-0.05f),
                            )
                        ) {
                            append(" ${viewModel.score}")
                        }
                    },
                    modifier = Modifier.fillMaxWidth(),
                    textAlign = TextAlign.Center
                )
                Spacer(modifier = Modifier.height(5.dp))
            }

            item {
                Row(
                    modifier = Modifier
                        .clip(RoundedCornerShape(2.dp))
                        .background(
                            Brush.verticalGradient(
                                listOf(
                                    Color(
                                        android.graphics.Color.parseColor(
                                            "#A5C0DD"
                                        )
                                    ), Color(android.graphics.Color.parseColor("#6C9BCF"))
                                )
                            )
                        ),
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically
                ) {

                    Box(
                        modifier = Modifier
                            .width(85.dp)
                            .height(80.dp),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = viewModel.numFirst.value.toString(),
                            color = color,
                            fontSize = 24.scaledSp(),
                            style = MaterialTheme.typography.displayMedium
                        )
                    }

                    Text(
                        text = viewModel.currentOperation.value,
                        color = color,
                        fontSize = 24.scaledSp(), maxLines = 1, textAlign = TextAlign.Center,
                        modifier = Modifier.width(25.dp),
                        style = MaterialTheme.typography.displayMedium
                    )

                    Box(
                        modifier = Modifier
                            .width(85.dp)
                            .height(80.dp),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = viewModel.numSecond.value.toString(),
                            color = color,
                            fontSize = 24.scaledSp(), maxLines = 1,
                            style = MaterialTheme.typography.displayMedium
                        )
                    }

                    Text(
                        text = "=",
                        color = color,
                        fontSize = 24.scaledSp(),
                        maxLines = 1,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.width(25.dp),
                        style = MaterialTheme.typography.displayMedium
                    )

                    Box(
                        modifier = Modifier
                            .width(85.dp)
                            .height(80.dp),
                        contentAlignment = Alignment.Center
                    ) {
                        androidx.compose.animation.AnimatedVisibility(
                            visible = textVisible,
                            enter = scaleIn(animationSpec = tween(500)),
                            exit = fadeOut(animationSpec = tween(500)),
                        ) {
                            Text(
                                text = viewModel.result,
                                fontSize = 24.scaledSp(),
                                maxLines = 1,
                                style = MaterialTheme.typography.displayMedium
                            )
                        }
                    }

                }
                Spacer(modifier = Modifier.height(10.dp))
            }

            item {
                Column(
                    modifier = Modifier
                        .clip(RoundedCornerShape(8.dp))
                        .background(
                            Brush.verticalGradient(
                                listOf(
                                    Color(
                                        android.graphics.Color.parseColor(
                                            "#EFEFEF"
                                        )
                                    ), Color(
                                        android.graphics.Color.parseColor(
                                            "#A9A9A9"
                                        )
                                    )
                                )
                            )
                        )
                        .padding(30.dp), horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Row(
                        horizontalArrangement = Arrangement.Center
                    ) {
                        KeyboardButton(
                            key = "1",
                            onClick = {
                                viewModel.updateResult("1")
                                numRes = viewModel.result
                                updateResult()
                            })
                        Spacer(modifier = Modifier.width(10.dp))
                        KeyboardButton(
                            key = "2",
                            onClick = {
                                viewModel.updateResult("2")
                                numRes = viewModel.result
                                updateResult()
                            })
                        Spacer(modifier = Modifier.width(10.dp))
                        KeyboardButton(
                            key = "3",
                            onClick = {
                                viewModel.updateResult("3")
                                numRes = viewModel.result
                                updateResult()
                            })
                    }
                    Spacer(modifier = Modifier.height(10.dp))
                    Row(
                        horizontalArrangement = Arrangement.Center
                    ) {
                        KeyboardButton(
                            key = "4",
                            onClick = {
                                viewModel.updateResult("4")
                                numRes = viewModel.result
                                updateResult()
                            })
                        Spacer(modifier = Modifier.width(10.dp))
                        KeyboardButton(
                            key = "5",
                            onClick = {
                                viewModel.updateResult("5")
                                numRes = viewModel.result
                                updateResult()
                            })
                        Spacer(modifier = Modifier.width(10.dp))
                        KeyboardButton(
                            key = "6",
                            onClick = {
                                viewModel.updateResult("6")
                                numRes = viewModel.result
                                updateResult()
                            })
                    }
                    Spacer(modifier = Modifier.height(10.dp))
                    Row(
                        horizontalArrangement = Arrangement.Center
                    ) {
                        KeyboardButton(
                            key = "7",
                            onClick = {
                                viewModel.updateResult("7")
                                numRes = viewModel.result
                                updateResult()
                            })
                        Spacer(modifier = Modifier.width(10.dp))
                        KeyboardButton(
                            key = "8",
                            onClick = {
                                viewModel.updateResult("8")
                                numRes = viewModel.result
                                updateResult()
                            })
                        Spacer(modifier = Modifier.width(10.dp))
                        KeyboardButton(
                            key = "9",
                            onClick = {
                                viewModel.updateResult("9")
                                numRes = viewModel.result
                                updateResult()
                            })
                    }
                    Spacer(modifier = Modifier.height(10.dp))
                    Row(
                        horizontalArrangement = Arrangement.Center
                    ) {
                        KeyboardButton(
                            key = "0",
                            onClick = {
                                viewModel.updateResult("0")
                                numRes = viewModel.result
                                updateResult()
                            })
                        Spacer(modifier = Modifier.width(10.dp))
                        KeyboardButton(
                            key = "<=",
                            onClick = {
                                viewModel.updateResult("<=")
                                numRes = viewModel.result
                                updateResult()
                            })

                    }

                }
            }
            item {
                Spacer(modifier = Modifier.height(5.dp))
                Box(
                    modifier = Modifier
                        .height(50.dp),
                    contentAlignment = Alignment.Center
                ) {
                    BannerAdView(id = stringResource(id = R.string.main_banner1))
                }

            }
        }
    }
}

