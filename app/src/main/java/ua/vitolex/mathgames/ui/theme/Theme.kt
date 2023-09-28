package ua.vitolex.mathgames.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import com.google.accompanist.systemuicontroller.rememberSystemUiController

enum class AppTheme {
   Blue, Gradient, Colorful, DarkBlue, Magenta, RedBlueBlack
}

private val BlueColorScheme = lightColorScheme(
    primary = blue,
    secondary = colorBlue1,
    background = pink,
    onPrimary = colorWhite,
    onSecondary = colorWhite,
    onBackground = colorBlack,
)


private val GradientColorScheme = lightColorScheme(
    primary = violet,
    secondary = colorBlue1,
    background = lightViolet,
    onPrimary = colorWhite,
    onSecondary = colorWhite,
    onBackground = colorBlack,
)


private val ColorfulColorScheme = lightColorScheme(
    primary = darkGreen,
    secondary = colorBlue1,
    background = yellow,
    onPrimary = colorWhite,
    onSecondary = colorWhite,
    onBackground = colorBlack,
)
private val DarkBlueColorScheme = lightColorScheme(
    primary = darkBlue,
    secondary = colorBlue1,
    background = darkPink,
    onPrimary = colorWhite,
    onSecondary = colorWhite,
    onBackground = colorBlack,
)
private val MagentaColorScheme = lightColorScheme(
    primary = dark,
    secondary = colorBlue1,
    background = lightPink,
    onPrimary = colorWhite,
    onSecondary = colorWhite,
    onBackground = colorBlack,
)
private val RedBlueBlackColorScheme = lightColorScheme(
    primary = orangeRed,
    secondary = colorBlue1,
    background = lightOrange,
    onPrimary = colorWhite,
    onSecondary = colorWhite,
    onBackground = colorBlack,
)


@Composable
fun MathGamesTheme(
    appTheme: AppTheme,
    isDarkMode: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {

    val colorScheme = when (appTheme) {
        AppTheme.Blue -> {
            BlueColorScheme
        }
        AppTheme.Gradient -> {
            GradientColorScheme
        }
        AppTheme.Colorful -> {
            ColorfulColorScheme
        }
        AppTheme.DarkBlue -> {
            DarkBlueColorScheme
        }
        AppTheme.Magenta -> {
           MagentaColorScheme
        }
        AppTheme.RedBlueBlack -> {
            RedBlueBlackColorScheme
        }
    }

    val systemUiController = rememberSystemUiController()
    SideEffect {
        systemUiController.setStatusBarColor(
            color = colorScheme.primary,
            darkIcons = false,
        )
    }
    MaterialTheme(
        colorScheme = colorScheme, typography = Typography, content = content
    )
}