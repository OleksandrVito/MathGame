package ua.vitolex.mathgames.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
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
fun RecordsTable (viewModel: MainViewModel){
    DropdownMenuItem(
    text = {
        Column( modifier = Modifier.clip(RoundedCornerShape(4.dp)).background(Color.White.copy(0.5f))
           .padding(start = 0.dp, top = 10.dp, bottom = 10.dp, end = 0.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = stringResource(R.string.Your_records), fontSize = 20.scaledSp(), style = MaterialTheme.typography.bodyMedium, modifier = Modifier.fillMaxWidth(), textAlign = TextAlign.Center)
            Spacer(
                modifier = Modifier
                    .height(5.dp)
            )
            Row {
                Box (modifier = Modifier
                    .width(100.dp))
                Box (modifier = Modifier
                    .width(52.dp), contentAlignment = Alignment.Center){
                    Text(  text = buildAnnotatedString {
                        withStyle(
                            style = SpanStyle(
                                fontFamily = cairo,
                                fontWeight = FontWeight.Normal,
                                fontSize = 16.scaledSp()
                            )
                        ) {
                            append("1")
                        }
                        withStyle(
                            style = SpanStyle(
                                fontFamily = exo,
                                fontWeight = FontWeight.Normal,
                                fontSize = 16.scaledSp()
                            )
                        ) {
                            append(stringResource(R.string.min))
                        }

                    })
                }
                Box (modifier = Modifier
                    .width(52.dp), contentAlignment = Alignment.Center){
                    Text(  text = buildAnnotatedString {
                        withStyle(
                            style = SpanStyle(
                                fontFamily = cairo,
                                fontWeight = FontWeight.Normal,
                                fontSize = 16.scaledSp()
                            )
                        ) {
                            append("3")
                        }
                        withStyle(
                            style = SpanStyle(
                                fontFamily = exo,
                                fontWeight = FontWeight.Normal,
                                fontSize = 16.scaledSp()
                            )
                        ) {
                            append(stringResource(R.string.min))
                        }

                    })
                }
                Box (modifier = Modifier
                    .width(52.dp), contentAlignment = Alignment.Center){
                    Text(  text = buildAnnotatedString {
                        withStyle(
                            style = SpanStyle(
                                fontFamily = cairo,
                                fontWeight = FontWeight.Normal,
                                fontSize = 16.scaledSp()
                            )
                        ) {
                            append("5")
                        }
                        withStyle(
                            style = SpanStyle(
                                fontFamily = exo,
                                fontWeight = FontWeight.Normal,
                                fontSize = 16.scaledSp()
                            )
                        ) {
                            append(stringResource(R.string.min))
                        }

                    })
                }

            }
            Spacer(
                modifier = Modifier
                    .height(5.dp)
            )
            Row (modifier = Modifier
                .background(
                    Color(
                        android.graphics.Color.parseColor(
                            "#DCDCDC"
                        )
                    )
                )
                .padding(vertical = 8.dp, horizontal = 10.dp)){
                Box (modifier = Modifier
                    .width(100.dp)){
                    Text(text = "${stringResource(R.string.easy_level)}: ", fontSize = 16.scaledSp(), style = MaterialTheme.typography.bodyMedium)
                }
                Box (modifier = Modifier
                    .width(52.dp), contentAlignment = Alignment.Center){
                    Text(text = if("${viewModel.mapScores["easy60"]}" == "null") "0" else "${viewModel.mapScores["easy60"]}",
                        fontSize = 16.scaledSp(), style = MaterialTheme.typography.displayMedium)
                }
                Box (modifier = Modifier
                    .width(52.dp), contentAlignment = Alignment.Center){
                    Text(text =  if("${viewModel.mapScores["easy180"]}" == "null") "0" else "${viewModel.mapScores["easy180"]}",
                        fontSize = 16.scaledSp(), style = MaterialTheme.typography.displayMedium)
                }
                Box (modifier = Modifier
                    .width(52.dp), contentAlignment = Alignment.Center){
                    Text(text =  if("${viewModel.mapScores["easy300"]}" == "null") "0" else "${viewModel.mapScores["easy300"]}",
                        fontSize = 16.scaledSp(), style = MaterialTheme.typography.displayMedium)
                }

            }
            Spacer(
                modifier = Modifier
                    .height(5.dp)
            )
            Row (modifier = Modifier
                .background(
                    Color(
                        android.graphics.Color.parseColor(
                            "#D3D3D3"
                        )
                    )
                )
                .padding(vertical = 8.dp, horizontal = 10.dp)){
                Box (modifier = Modifier
                    .width(100.dp)){
                    Text(text = "${stringResource(R.string.medium_level)}: ", fontSize = 16.scaledSp(), style = MaterialTheme.typography.bodyMedium)
                }
                Box (modifier = Modifier
                    .width(52.dp), contentAlignment = Alignment.Center){
                    Text(text =  if("${viewModel.mapScores["medium60"]}" == "null") "0" else "${viewModel.mapScores["medium60"]}",
                        fontSize = 16.scaledSp(), style = MaterialTheme.typography.displayMedium)
                }
                Box (modifier = Modifier
                    .width(52.dp), contentAlignment = Alignment.Center){
                    Text(text =  if("${viewModel.mapScores["medium180"]}" == "null") "0" else  "${viewModel.mapScores["medium180"]}",
                        fontSize = 16.scaledSp(), style = MaterialTheme.typography.displayMedium)
                }
                Box (modifier = Modifier
                    .width(52.dp), contentAlignment = Alignment.Center){
                    Text(text =  if("${viewModel.mapScores["medium300"]}" == "null") "0" else "${viewModel.mapScores["medium300"]}",
                        fontSize = 16.scaledSp(), style = MaterialTheme.typography.displayMedium)
                }
            }
            Spacer(
                modifier = Modifier
                    .height(5.dp)
            )
            Row(modifier = Modifier
                .background(
                    Color(
                        android.graphics.Color.parseColor(
                            "#C0C0C0"
                        )
                    )
                )
                .padding(vertical = 8.dp, horizontal = 10.dp)) {
                Box (modifier = Modifier
                    .width(100.dp)){
                    Text(text = "${stringResource(R.string.hard_level)}: ", fontSize = 16.scaledSp(), style = MaterialTheme.typography.bodyMedium)
                }
                Box (modifier = Modifier
                    .width(52.dp), contentAlignment = Alignment.Center){
                    Text(text = if("${viewModel.mapScores["hard60"]}" == "null") "0" else  "${viewModel.mapScores["hard60"]}",
                        fontSize = 16.scaledSp(), style = MaterialTheme.typography.displayMedium)
                }
                Box (modifier = Modifier
                    .width(52.dp), contentAlignment = Alignment.Center){
                    Text(text = if("${viewModel.mapScores["hard180"]}" == "null") "0" else "${viewModel.mapScores["hard180"]}",
                        fontSize = 16.scaledSp(), style = MaterialTheme.typography.displayMedium)
                }
                Box (modifier = Modifier
                    .width(52.dp), contentAlignment = Alignment.Center){
                    Text(text = if("${viewModel.mapScores["hard300"]}" == "null") "0" else "${viewModel.mapScores["hard300"]}",
                        fontSize = 16.scaledSp(), style = MaterialTheme.typography.displayMedium)
                }
            }

        }

    },
    onClick = {},
    contentPadding = PaddingValues(start = 0.dp, end = 0.dp),

    )
}