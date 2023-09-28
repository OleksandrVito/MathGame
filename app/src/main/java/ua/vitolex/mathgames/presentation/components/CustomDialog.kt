package ua.vitolex.mathgames.presentation.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
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
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.navigation.NavController
import ua.vitolex.buns.presentation.navigation.Screens
import ua.vitolex.mathgames.R
import ua.vitolex.mathgames.main.MainViewModel
import ua.vitolex.mathgames.ui.theme.cairo
import ua.vitolex.mathgames.ui.theme.exo
import ua.vitolex.mathgames.util.scaledSp

@Composable
fun CustomDialog(
    setShowDialog: (Boolean) -> Unit,
    navController: NavController,
    viewModel: MainViewModel,
) {

    Dialog(onDismissRequest = {}) {
        Surface(
            modifier = Modifier.clip(RoundedCornerShape(4.dp)).background(MaterialTheme.colorScheme.background).padding(10.dp),
            color = MaterialTheme.colorScheme.background,
            shape = RoundedCornerShape(4.dp),
        ) {
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier.clip(RoundedCornerShape(4.dp)).background(Color.White.copy(0.5f))
            ) {
                Column(
                    modifier = Modifier.padding(10.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = stringResource(R.string.Time_is_up),
                        style = MaterialTheme.typography.bodyMedium,
                        fontSize = 18.scaledSp()
                    )
                    Spacer(modifier = Modifier.height(10.dp))
                    Text(
                        text = buildAnnotatedString {
                            withStyle(
                                style = SpanStyle(
                                    fontFamily = exo,
                                    fontWeight = FontWeight.Normal,
                                    fontSize = 18.scaledSp()
                                )
                            ) {
                                append(stringResource(R.string.Your_result))
                            }
                            withStyle(
                                style = SpanStyle(
                                    fontFamily = cairo,
                                    fontWeight = FontWeight.Normal,
                                    fontSize = 18.scaledSp()
                                )
                            ) {
                                append(" ${viewModel.score}")
                            }
                        },
                    )
                    Spacer(modifier = Modifier.height(10.dp))
                    Text(
                        text = "${stringResource(R.string.The_best_result)} ${if (viewModel.mapScores["${viewModel.level}${viewModel.totalTime / 1000}"] == "null") 0 else viewModel.mapScores["${viewModel.level}${viewModel.totalTime / 1000}"]}",
                        style = MaterialTheme.typography.bodyMedium,
                        fontSize = 18.scaledSp()
                    )
                    Spacer(modifier = Modifier.height(40.dp))
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .weight(1f), contentAlignment = Alignment.Center
                        ) {
                            Button(
                                onClick = {
                                    navController.popBackStack(Screens.SettingsScreen.rout, false)
                                    setShowDialog(false)

                                },
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .height(50.dp).clip(RoundedCornerShape(8.dp))
                                    .background(
                                        Brush.linearGradient(
                                            0.0f to MaterialTheme.colorScheme.primary.copy(0.5f),
                                            0.5f to MaterialTheme.colorScheme.primary.copy(0.75f),
                                            0.9f to  MaterialTheme.colorScheme.primary,
                                            start = Offset(0.0f, 50.0f),
                                            end = Offset(0.0f, 100.0f),
                                        )
                                    ),
                                colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent),
                                shape = RoundedCornerShape(8.dp),
                                border = BorderStroke(
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
                            ) {
                                Text(
                                    text = stringResource(R.string.back_home),
                                    style = MaterialTheme.typography.bodyMedium,
                                    fontSize = 16.scaledSp()
                                )
                            }
                        }

                        Spacer(modifier = Modifier.width(2.dp))

                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .weight(1f), contentAlignment = Alignment.Center
                        ) {
                            Button(
                                onClick = {
                                    navController.navigate(Screens.PulseCountDownScreen.rout)
                                    setShowDialog(false)

                                },
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .height(50.dp).clip(RoundedCornerShape(8.dp))
                                    .background(
                                        Brush.linearGradient(
                                            0.0f to MaterialTheme.colorScheme.primary.copy(0.5f),
                                            0.5f to MaterialTheme.colorScheme.primary.copy(0.75f),
                                            0.9f to  MaterialTheme.colorScheme.primary,
                                            start = Offset(0.0f, 50.0f),
                                            end = Offset(0.0f, 100.0f),
                                        )
                                    ),
                                colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent),
                                shape = RoundedCornerShape(8.dp),
                                border = BorderStroke(
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
                            ) {
                                Text(
                                    text = stringResource(R.string.restart),
                                    style = MaterialTheme.typography.bodyMedium,
                                    fontSize = 16.scaledSp()
                                )
                            }

                        }
                    }
                }
            }
        }
    }
}