package ua.vitolex.mathgames.select_theme

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.paint
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.TileMode
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import ua.vitolex.mathgames.R
import ua.vitolex.mathgames.app.AppPreferences
import ua.vitolex.mathgames.main.MainEvent
import ua.vitolex.mathgames.main.MainViewModel
import ua.vitolex.mathgames.ui.theme.AppTheme
import ua.vitolex.mathgames.ui.theme.colorBlue
import ua.vitolex.mathgames.ui.theme.colorGreen
import ua.vitolex.mathgames.ui.theme.colorRed2
import ua.vitolex.mathgames.ui.theme.colorRed3
import ua.vitolex.mathgames.ui.theme.colorRed4
import ua.vitolex.mathgames.util.scaledSp

@Composable
fun SelectThemeDialog(
    mainViewModel: MainViewModel,
    setShowDialog: (Boolean) -> Unit,
    returnValue: (AppTheme) -> Unit,
) {
    DropdownMenuItem(
        text = {
            Card(
                modifier = Modifier
                    .wrapContentHeight()
                    .fillMaxWidth(),
                colors = CardDefaults.cardColors(
                    containerColor = Color.White.copy(0.5f)
                ),
                shape = RoundedCornerShape(4.dp)
            ) {
                Column(
                    modifier = Modifier.padding(start = 20.dp, top=10.dp, end = 20.dp)
                ) {
                    Text(text = stringResource(id = R.string.choose_a_theme),
                            fontSize = 22.scaledSp(),
                        modifier = Modifier.fillMaxWidth(),
                        textAlign = TextAlign.Center,
                        style = MaterialTheme.typography.bodyMedium,)
                    Spacer(modifier = Modifier.height(8.dp))
                    Row {
                        Column(
                            modifier = Modifier.fillMaxWidth(0.5f),
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Spacer(modifier = Modifier.padding(8.dp))
                            ItemSelectRadioButton(
                                onClick = {
                                    if (mainViewModel.stateApp.theme != AppTheme.Blue) {
                                        AppPreferences.setTheme(AppTheme.Blue)
                                        mainViewModel.onEvent(MainEvent.ThemeChange(AppTheme.Blue))
                                        setShowDialog(false)
                                        returnValue(AppTheme.Blue)
                                        mainViewModel.background =  R.drawable.blue
                                    }
                                },
                                isSelect = mainViewModel.stateApp.theme == AppTheme.Blue,
                                background = R.drawable.blue
                            )
                            Spacer(modifier = Modifier.padding(8.dp))
                            ItemSelectRadioButton(
                                onClick = {
                                    if (mainViewModel.stateApp.theme != AppTheme.Gradient) {
                                        AppPreferences.setTheme(AppTheme.Gradient)
                                        mainViewModel.onEvent(MainEvent.ThemeChange(AppTheme.Gradient))
                                        setShowDialog(false)
                                        returnValue(AppTheme.Gradient)
                                        mainViewModel.background =  R.drawable.gradient
                                    }
                                },
                                isSelect = mainViewModel.stateApp.theme == AppTheme.Gradient,
                                background = R.drawable.gradient
                            )
                            Spacer(modifier = Modifier.padding(8.dp))
                            ItemSelectRadioButton(
                                onClick = {
                                    if (mainViewModel.stateApp.theme != AppTheme.Colorful) {
                                        AppPreferences.setTheme(AppTheme.Colorful)
                                        mainViewModel.onEvent(MainEvent.ThemeChange(AppTheme.Colorful))
                                        setShowDialog(false)
                                        returnValue(AppTheme.Colorful)
                                        mainViewModel.background =  R.drawable.colorful
                                    }
                                },
                                isSelect = mainViewModel.stateApp.theme == AppTheme.Colorful,
                                background = R.drawable.colorful
                            )
                            Spacer(modifier = Modifier.padding(8.dp))
                        }
                        Column(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Spacer(modifier = Modifier.padding(8.dp))
                            ItemSelectRadioButton(
                                onClick = {
                                    if (mainViewModel.stateApp.theme != AppTheme.DarkBlue) {
                                        AppPreferences.setTheme(AppTheme.DarkBlue)
                                        mainViewModel.onEvent(MainEvent.ThemeChange(AppTheme.DarkBlue))
                                        setShowDialog(false)
                                        returnValue(AppTheme.DarkBlue)
                                        mainViewModel.background =  R.drawable.dark_blue
                                    }
                                },
                                isSelect = mainViewModel.stateApp.theme == AppTheme.DarkBlue,
                                background = R.drawable.dark_blue
                            )
                            Spacer(modifier = Modifier.padding(8.dp))
                            ItemSelectRadioButton(
                                onClick = {
                                    if (mainViewModel.stateApp.theme != AppTheme.Magenta) {
                                        AppPreferences.setTheme(AppTheme.Magenta)
                                        mainViewModel.onEvent(MainEvent.ThemeChange(AppTheme.Magenta))
                                        setShowDialog(false)
                                        returnValue(AppTheme.Magenta)
                                        mainViewModel.background =  R.drawable.magenta
                                    }
                                },
                                isSelect = mainViewModel.stateApp.theme == AppTheme.Magenta,
                                background = R.drawable.magenta
                            )
                            Spacer(modifier = Modifier.padding(8.dp))
                            ItemSelectRadioButton(
                                onClick = {
                                    if (mainViewModel.stateApp.theme != AppTheme.RedBlueBlack) {
                                        AppPreferences.setTheme(AppTheme.RedBlueBlack)
                                        mainViewModel.onEvent(MainEvent.ThemeChange(AppTheme.RedBlueBlack))
                                        setShowDialog(false)
                                        returnValue(AppTheme.RedBlueBlack)
                                        mainViewModel.background =  R.drawable.red_blue_black
                                    }
                                },
                                isSelect = mainViewModel.stateApp.theme == AppTheme.RedBlueBlack,
                                background = R.drawable.red_blue_black
                            )
                            Spacer(modifier = Modifier.padding(8.dp))
                        }
                    }
                }


            }
        },
        onClick = {


        },
        contentPadding = PaddingValues(start = 10.dp, end = 10.dp)
    )
}

@Composable
fun ItemSelectRadioButton(
    background: Int,
    onClick: () -> Unit,
    isSelect: Boolean,
) {
    Box(
        modifier = Modifier
            .border(
                width = if (isSelect) 2.dp else 0.dp,
                color = if (isSelect) Color.Red else Color.Transparent,
                shape = CircleShape
            )
            .border(
                width = if (isSelect) 4.dp else 0.dp,
                color = Color.White,
                shape = CircleShape
            )
            .size(if (isSelect) 50.dp else 48.dp)
            .clip(shape = CircleShape)
            .background(Color.White)
            .clickable {
                onClick()
            }
            .paint(
                painterResource(id = background),
                contentScale = ContentScale.Crop
            )
    ) {
    }
}