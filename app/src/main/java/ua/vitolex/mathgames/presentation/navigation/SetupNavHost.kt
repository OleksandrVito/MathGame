package ua.vitolex.buns.presentation.navigation

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.google.accompanist.navigation.animation.AnimatedNavHost
import com.google.accompanist.navigation.animation.composable
import ua.vitolex.buns.presentation.screen.SplashScreen
import ua.vitolex.mathgames.presentation.screens.MainScreen
import ua.vitolex.mathgames.main.MainViewModel
import ua.vitolex.mathgames.presentation.screens.PulseCountDownScreen
import ua.vitolex.mathgames.presentation.screens.SettingsScreen

sealed class Screens(val rout: String) {
    object SplashScreen : Screens(rout = "splash_screen")
    object MainScreen : Screens(rout = "main_screen")
    object SettingsScreen : Screens(rout = "settings_screen")
    object PulseCountDownScreen : Screens(rout = "pulse_count_down_screen")
}

@OptIn(ExperimentalAnimationApi::class, ExperimentalMaterial3Api::class)
@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun SetupNavHost(
    navController: NavHostController,
    viewModel: MainViewModel,
) {
    val durationEnter = 300
    val durationPopEnter = 150


    AnimatedNavHost(navController = navController, startDestination = Screens.SplashScreen.rout) {
        composable(
            route = Screens.SplashScreen.rout,
        ) {
            SplashScreen(navController = navController, viewModel = viewModel)
        }
        composable(
            route = Screens.SettingsScreen.rout,
        ) {
            SettingsScreen(
                navController = navController,
                viewModel = viewModel,
            )
        }
        composable(
            route = Screens.PulseCountDownScreen.rout,
        ) {
            PulseCountDownScreen(
                navController = navController,
                viewModel = viewModel,
            )
        }
        composable(
            route = Screens.MainScreen.rout,
        ) {
            MainScreen(
                navController = navController,
                viewModel = viewModel,
            )
        }
    }
}

