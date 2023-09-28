package ua.vitolex.mathgames.presentation.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ua.vitolex.mathgames.R
import ua.vitolex.mathgames.main.MainViewModel
import ua.vitolex.mathgames.ui.theme.cairo
import ua.vitolex.mathgames.ui.theme.exo
import ua.vitolex.mathgames.util.scaledSp

@Composable
fun TimeSelection(viewModel: MainViewModel) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp),
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = stringResource(R.string.Choose_a_time),
            fontSize = 22.scaledSp(),
            modifier = Modifier.fillMaxWidth(),
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.bodyMedium,
        )
        Spacer(modifier = Modifier.height(10.dp))
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Button(
                modifier = Modifier
                    .size(70.dp)
                    .clip(CircleShape)
                    .background(
                        brush =
                        if (viewModel.totalTime == 60000L) {
                            DarkGrayGradient
                        } else {
                            LightGrayGradient
                        }
                    ),
                border =
                if (viewModel.totalTime == 60000L) {
                    DarkGrayBorder
                } else {
                    LightGrayBorder
                },
                onClick = {
                    viewModel.startTimer = false
                    viewModel.totalTime = 60L * 1000L
                },
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.Transparent,
                    contentColor = if (viewModel.totalTime == 60000L) Color.Red else Color.Black,
                ),
                contentPadding = PaddingValues(0.dp)

            ) {
                Text(
                    text = buildAnnotatedString {
                        withStyle(
                            style = SpanStyle(
                                fontFamily = cairo,
                                fontWeight = FontWeight.Normal,
                                fontSize = 18.scaledSp()
                            )
                        ) {
                            append("1 ")
                        }
                        withStyle(
                            style = SpanStyle(
                                fontFamily = exo,
                                fontWeight = FontWeight.Normal,
                                fontSize = 18.scaledSp()
                            )
                        ) {
                            append(stringResource(R.string.min))
                        }

                    }
                )
            }
            Spacer(modifier = Modifier.height(2.dp))
            Button(
                modifier = Modifier
                    .size(75.dp)
                    .clip(CircleShape)
                    .background(
                        brush =
                        if (viewModel.totalTime == 180000L) {
                            DarkGrayGradient
                        } else {
                            LightGrayGradient
                        }
                    ),
                border =
                if (viewModel.totalTime == 180000L) {
                    DarkGrayBorder
                } else {
                    LightGrayBorder
                },
                onClick = {
                    viewModel.startTimer = false
                    viewModel.totalTime = 180L * 1000L
                },
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.Transparent,
                    contentColor = if (viewModel.totalTime == 180000L) Color.Red else Color.Black,
                ),
                        contentPadding = PaddingValues(0.dp)
            ) {
                Text(
                    text = buildAnnotatedString {
                        withStyle(
                            style = SpanStyle(
                                fontFamily = cairo,
                                fontWeight = FontWeight.Normal,
                                fontSize = 18.scaledSp()
                            )
                        ) {
                            append("3 ")
                        }
                        withStyle(
                            style = SpanStyle(
                                fontFamily = exo,
                                fontWeight = FontWeight.Normal,
                                fontSize = 18.scaledSp()
                            )
                        ) {
                            append(stringResource(R.string.min))
                        }

                    }
                )
            }
            Spacer(modifier = Modifier.height(2.dp))
            Button(
                modifier = Modifier
                    .size(80.dp)
                    .clip(CircleShape)
                    .background(
                        brush =

                        if (viewModel.totalTime == 300000L) {
                            DarkGrayGradient
                        } else {
                          LightGrayGradient
                        }
                    ),
                border =
                    if (viewModel.totalTime == 300000L) {
                        DarkGrayBorder
                    } else {
                        LightGrayBorder
                    },

                onClick = {
                    viewModel.startTimer = false
                    viewModel.totalTime = 300L * 1000L
                },
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.Transparent,
                    contentColor = if (viewModel.totalTime == 300000L) Color.Red else Color.Black,
                ),
                contentPadding = PaddingValues(0.dp)
            ) {
                Text(
                    text = buildAnnotatedString {
                        withStyle(
                            style = SpanStyle(
                                fontFamily = cairo,
                                fontWeight = FontWeight.Normal,
                                fontSize = 18.scaledSp()
                            )
                        ) {
                            append("5 ")
                        }
                        withStyle(
                            style = SpanStyle(
                                fontFamily = exo,
                                fontWeight = FontWeight.Normal,
                                fontSize = 18.scaledSp()
                            )
                        ) {
                            append(stringResource(R.string.min))
                        }

                    }
                )
            }
        }
    }
}

val LightGrayGradient = Brush.sweepGradient(
    0.0f to Color.LightGray,
    0.14f to Color.Gray.copy(0.8f),
    0.5f to Color.Gray,
    0.9f to Color.LightGray,
    center = Offset(0.2f, 0.2f)
)

val DarkGrayGradient = Brush.sweepGradient(
    0.0f to Color.DarkGray,
    0.14f to Color.Gray.copy(0.8f),
    0.5f to Color.LightGray,
    1f to Color.Gray,
    center = Offset(0.2f, 0.2f)
)

val LightGrayBorder =  BorderStroke(
    2.dp,
    brush = Brush
        .sweepGradient(
            0.0f to Color.White,
            0.14f to Color.Gray.copy(1f),
            0.5f to Color.Gray,
            0.9f to Color.White,
            center = Offset(0.2f, 0.2f)
        )
)

val DarkGrayBorder =  BorderStroke(
    2.dp,
    brush = Brush
        .sweepGradient(
            0.0f to Color.LightGray,
            0.14f to Color.Gray.copy(1f),
            0.5f to Color.Gray,
            0.9f to Color.LightGray,
            center = Offset(0.2f, 0.2f)
        )
)