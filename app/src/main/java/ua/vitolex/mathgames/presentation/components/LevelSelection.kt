package ua.vitolex.mathgames.presentation.components

import android.annotation.SuppressLint
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ua.vitolex.mathgames.R
import ua.vitolex.mathgames.main.MainViewModel
import ua.vitolex.mathgames.util.scaledSp

@SuppressLint("UnrememberedMutableState")
@Composable
fun LevelSelection(viewModel: MainViewModel) {

    val levelList = listOf<String>(
        stringResource(R.string.easy_level),
        stringResource(R.string.medium_level),
        stringResource(R.string.hard_level), )
    var index by remember { mutableStateOf(0) }


    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp),
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text =  stringResource(R.string.Choose_a_level),
            fontSize = 22.scaledSp(),
            modifier = Modifier.fillMaxWidth(),
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.bodyMedium,
        )
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Button(
                modifier = Modifier
                    .size(55.dp)
                    .clip(CircleShape)
                    .background(
                        brush = LightGrayGradient
                    ),
                border = LightGrayBorder,
                onClick = {
                    if (viewModel.index > 0) viewModel.index--
                    viewModel.level = viewModel.levelList[viewModel.index]
                },
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.Transparent,
                    contentColor = Color.Black,
                ),
                contentPadding = PaddingValues(0.dp)
            ) {
                Icon(imageVector = ImageVector.vectorResource(R.drawable.baseline_chevron_left_24),
                    contentDescription = "left")
            }

            Spacer(modifier = Modifier.width(10.dp))

            Box(
                modifier = Modifier
                    .height(60.dp)
                    .width(140.dp)
                    .clip(RoundedCornerShape(4.dp))
                    .background(
                        Brush.horizontalGradient(
                            listOf(
                                Color.Transparent,
                                Color(0x80ffffff).copy(0.25f),
                                Color(0x80ffffff),
                                Color(0x80ffffff).copy(0.25f),
                                Color.Transparent
                            )
                        )
                    ),
                contentAlignment = Alignment.Center
            ) {
                Text(text =levelList[viewModel.index], fontSize = 20.scaledSp(), style = MaterialTheme.typography.bodyMedium)
            }

            Spacer(modifier = Modifier.width(10.dp))
            Button(
                modifier = Modifier
                    .size(55.dp)
                    .clip(CircleShape)
                    .background(
                        brush = LightGrayGradient
                    ),
                border = LightGrayBorder,
                onClick = {
                    if (viewModel.index < 2) viewModel.index++
                    viewModel.level = viewModel.levelList[viewModel.index]
                },
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.Transparent,
                    contentColor = Color.Black,
                ),
                contentPadding = PaddingValues(0.dp)
            ) {
                Icon(imageVector = ImageVector.vectorResource(R.drawable.baseline_chevron_right_24),
                    contentDescription = "right")
            }
        }
    }

}