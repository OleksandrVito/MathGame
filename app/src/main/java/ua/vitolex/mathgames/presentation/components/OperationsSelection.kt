package ua.vitolex.mathgames.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
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
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ua.vitolex.mathgames.R
import ua.vitolex.mathgames.main.MainViewModel
import ua.vitolex.mathgames.util.scaledSp

@Composable
fun OperationsSelection(viewModel: MainViewModel) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp),
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = stringResource(R.string.Choose_operations),
            fontSize = 22.scaledSp(),
            modifier = Modifier.fillMaxWidth(),
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.bodyMedium,
//            color = Color.LightGray
        )
        Spacer(modifier = Modifier.height(10.dp))
        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center) {
            Button(
                modifier = Modifier
                    .size(60.dp)
                    .clip(CircleShape)
                    .background(
                        brush =

                        if ("+" in viewModel.mathOperations.value) {
                            DarkGrayGradient
                        } else {
                            LightGrayGradient
                        }
                    ),
                border =
                if ("+" in viewModel.mathOperations.value) {
                    DarkGrayBorder
                } else {
                    LightGrayBorder
                },

                onClick = {
                    viewModel.selectOperations("+")
                },
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.Transparent,
                    contentColor = if ("+" in viewModel.mathOperations.value) Color.Red else Color.Black,
                )
            ) {
                Text(text = "+", fontSize = 24.scaledSp())
            }
            Button(
                modifier = Modifier
                    .size(60.dp)
                    .clip(CircleShape)
                    .background(
                        brush =

                        if ("-" in viewModel.mathOperations.value) {
                            DarkGrayGradient
                        } else {
                            LightGrayGradient
                        }
                    ),
                border =
                if ("-" in viewModel.mathOperations.value) {
                    DarkGrayBorder
                } else {
                    LightGrayBorder
                },
                onClick = {
                    viewModel.selectOperations("-")
                },
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.Transparent,
                    contentColor = if ("-" in viewModel.mathOperations.value) Color.Red else Color.Black,
                )
            ) {
                Text(text = "-", fontSize = 24.scaledSp())
            }
            Button(
                modifier = Modifier
                    .size(60.dp)
                    .clip(CircleShape)
                    .background(
                        brush =

                        if ("/" in viewModel.mathOperations.value) {
                            DarkGrayGradient
                        } else {
                            LightGrayGradient
                        }
                    ),
                border =
                if ("/" in viewModel.mathOperations.value) {
                    DarkGrayBorder
                } else {
                    LightGrayBorder
                },
                onClick = {
                    viewModel.selectOperations("/")
                },
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.Transparent,
                    contentColor = if ("/" in viewModel.mathOperations.value) Color.Red else Color.Black,
                )
            ) {
                Text(text = "/", fontSize = 24.scaledSp())
            }
            Button(
                modifier = Modifier
                    .size(60.dp)
                    .clip(CircleShape)
                    .background(
                        brush =

                        if ("*" in viewModel.mathOperations.value) {
                            DarkGrayGradient
                        } else {
                            LightGrayGradient
                        }
                    ),
                border =
                if ("*" in viewModel.mathOperations.value) {
                    DarkGrayBorder
                } else {
                    LightGrayBorder
                },
                onClick = {
                    viewModel.selectOperations("*")
                },
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.Transparent,
                    contentColor = if ("*" in viewModel.mathOperations.value) Color.Red else Color.Black,
                )
            ) {
                Text(text = "*", fontSize = 24.scaledSp())
            }
        }
    }
}
