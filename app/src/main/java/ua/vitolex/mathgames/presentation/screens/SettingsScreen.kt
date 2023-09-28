package ua.vitolex.mathgames.presentation.screens

import android.annotation.SuppressLint
import android.util.Log
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonColors
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawWithCache
import androidx.compose.ui.draw.paint
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.BlendMode
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.modifier.modifierLocalProvider
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.DpOffset
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import ua.vitolex.buns.presentation.navigation.Screens
import ua.vitolex.mathgames.main.MainViewModel
import ua.vitolex.mathgames.R
import ua.vitolex.mathgames.main.MainEvent
import ua.vitolex.mathgames.presentation.components.DarkGrayGradient
import ua.vitolex.mathgames.presentation.components.LevelSelection
import ua.vitolex.mathgames.presentation.components.LightGrayBorder
import ua.vitolex.mathgames.presentation.components.LightGrayGradient
import ua.vitolex.mathgames.presentation.components.OperationsSelection
import ua.vitolex.mathgames.presentation.components.RecordsTable
import ua.vitolex.mathgames.presentation.components.TimeSelection
import ua.vitolex.mathgames.select_theme.SelectThemeDialog
import ua.vitolex.mathgames.util.scaledSp


@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter", "FlowOperatorInvokedInComposition")
@Composable
fun SettingsScreen(
    viewModel: MainViewModel,
    navController: NavHostController,
) {
    var showDropdownMenu by rememberSaveable {
        mutableStateOf(false)
    }

    var showRecords by rememberSaveable {
        mutableStateOf(false)
    }


    val configuration = LocalConfiguration.current

    val screenWidth = configuration.screenWidthDp.dp

    if (viewModel.stateApp.openDialog) {
        SelectThemeDialog(mainViewModel = viewModel, setShowDialog = {
            viewModel.onEvent(MainEvent.OpenDialog(it))
        }, returnValue = {})
    }


    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = {},
                navigationIcon = {

                    IconButton(
                        onClick = {
                            showRecords = true
                        },
                    ) {
                        Icon(
                            imageVector = ImageVector.vectorResource(R.drawable.baseline_emoji_events_24),
                            contentDescription = "Records",
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
                        DropdownMenu(
                            expanded = showRecords,
                            onDismissRequest = { showRecords = false },
                            offset = DpOffset((-2).dp, 12.dp),
                            modifier = Modifier
                                .width(screenWidth - 52.dp)
                                .background(MaterialTheme.colorScheme.background)
                                .padding(start = 10.dp, end = 10.dp) .clip(RoundedCornerShape(8.dp))
                        ) {
                            RecordsTable(viewModel = viewModel)
                        }
                    }
                },
                actions = {
                    IconButton(
                        onClick = {
                            showDropdownMenu = true
                        },
                    ) {
                        Icon(
                            imageVector = Icons.Default.Settings,
                            contentDescription = "Settings",
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
                        DropdownMenu(
                            expanded = showDropdownMenu,
                            onDismissRequest = { showDropdownMenu = false },
                            offset = DpOffset((-2).dp, 12.dp),
                            modifier = Modifier
                                .width(screenWidth - 52.dp)
                                .background(MaterialTheme.colorScheme.background)
                        ) {
                            SelectThemeDialog(mainViewModel = viewModel,
                                setShowDialog = { showDropdownMenu = false },
                                returnValue = {})
                        }
                    }
                },
                colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                    containerColor = Color.Transparent
                ),
                modifier = Modifier
                    .padding(top = 0.dp, start = 0.dp, end = 0.dp, bottom = 0.dp),
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
            Modifier
                .fillMaxSize()
                .padding(top = 60.dp)
                .clip(RoundedCornerShape(8.dp))
                .background(
                    Brush.verticalGradient(
                        listOf(
                            Color.White, Color(0x80ffffff)
                        )
                    )
                ),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceAround
        ) {

            item {
                OperationsSelection(viewModel = viewModel)
            }
            item {
                LevelSelection(viewModel = viewModel)
            }
            item {
                TimeSelection(viewModel = viewModel)
            }

            item {
                Button(
                    modifier = Modifier
                        .size(120.dp)
                        .clip(CircleShape)
                        .background(
                            brush = Brush.sweepGradient(
                                0.0f to Color.DarkGray.copy(0.8f),
                                0.14f to Color(android.graphics.Color.parseColor("#01B500")).copy(
                                    0.8f
                                ),
                                1f to Color(android.graphics.Color.parseColor("#01C200")),
                                center = Offset(0.2f, 0.2f)
                            )
                        ),
                    onClick = {
                        navController.navigate(Screens.PulseCountDownScreen.rout)
                    },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color.Transparent,
                        contentColor = Color.White,
                    ),
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
                        text = stringResource(R.string.Start),
                        style = MaterialTheme.typography.bodyMedium,
                        fontSize = 24.scaledSp()
                    )
                }
            }
        }
        if (showRecords|| showDropdownMenu){
            Box(Modifier
                .fillMaxSize().padding(top = 60.dp).clip(RoundedCornerShape(8.dp)).background(Color.White.copy(0.8f)))
        }

    }

}