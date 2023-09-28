package ua.vitolex.mathgames.main

import android.content.Context
import androidx.compose.runtime.State
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.TileMode
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import ua.vitolex.mathgames.R
import ua.vitolex.mathgames.app.AppPreferences
import ua.vitolex.mathgames.app.dataStore
import ua.vitolex.mathgames.ui.theme.AppTheme
import ua.vitolex.mathgames.ui.theme.colorBlue
import ua.vitolex.mathgames.ui.theme.colorGreen
import ua.vitolex.mathgames.ui.theme.colorRed1
import ua.vitolex.mathgames.ui.theme.colorRed2
import ua.vitolex.mathgames.ui.theme.colorRed3
import ua.vitolex.mathgames.ui.theme.colorRed4
import ua.vitolex.mathgames.ui.theme.colorRed5
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor() : ViewModel() {
    val numFirst = mutableStateOf(1)
    val numSecond = mutableStateOf(2)
    val currentOperation = mutableStateOf("+")

    var score by mutableStateOf(0)

    fun getRandomNumberForDivide() {
        currentOperation.value = _mathOperations.value[(0.._mathOperations.value.size - 1).random()]
        when (currentOperation.value) {
            "/" -> {
                when (level) {
                    "easy" -> {
                        numSecond.value = (2..9).random()
                        numFirst.value = numSecond.value * (2..10).random()
                    }

                    "medium" -> {
                        numSecond.value = listOf(2, 5).random()
                        numFirst.value = numSecond.value * (11..99).random()
                    }

                    "hard" -> {
                        numSecond.value = (2..9).random()
                        numFirst.value = numSecond.value * numSecond.value * (11..99).random()
                    }
                }
            }

            "+" -> {
                when (level) {
                    "easy" -> {
                        numFirst.value = (2..99).random()
                        numSecond.value = (2..9).random()
                    }

                    "medium" -> {
                        numFirst.value = (101..999).random()
                        numSecond.value = (11..99).random()
                    }

                    "hard" -> {
                        numFirst.value = (101..999).random()
                        numSecond.value = (101..999).random()
                    }
                }

            }

            "-" -> {
                when (level) {
                    "easy" -> {
                        numFirst.value = (11..99).random()
                        numSecond.value = (2..9).random()
                    }

                    "medium" -> {
                        numFirst.value = (11..99).random()
                        var num = 1

                        do {
                            num = (11..99).random()
                        } while (num > numFirst.value)
                        numSecond.value = num
                    }

                    "hard" -> {
                        numFirst.value = (101..999).random()
                        numSecond.value = (11..99).random()
                    }

                }
            }

            "*" -> {
                when (level) {
                    "easy" -> {
                        numFirst.value = (2..9).random()
                        numSecond.value = (2..9).random()
                    }

                    "medium" -> {
                        numFirst.value = (11..99).random()
                        numSecond.value = listOf(2, 5).random()
                    }

                    "hard" -> {
                        numFirst.value = (11..99).random()
                        numSecond.value = (2..9).random()
                    }
                }
            }
        }


    }

    private var _mathOperations = mutableStateOf(
        listOf(
            "+"
        )
    )

    val mathOperations: State<List<String>> = _mathOperations

    fun selectOperations(operation: String) {
        val list = _mathOperations.value
        if (operation in _mathOperations.value && _mathOperations.value.size > 1) {
            viewModelScope.launch {
                _mathOperations.value = list.minus(operation)
            }
        } else {
            viewModelScope.launch {
                _mathOperations.value = list.plus(operation)
            }
        }
    }

    var totalTime by
    mutableStateOf(60L * 1000L)

    var isTimerRunning by
    mutableStateOf(false)

    var value by
    mutableStateOf(1f)

    var startTimer by
    mutableStateOf(false)

    var level by
    mutableStateOf("easy")

    val levelList = listOf<String>("easy", "medium", "hard", )
    var index by  mutableStateOf(0)


    var result by
    mutableStateOf("")

    fun updateResult(value: String) {
        when (value) {
            "C" -> result = ""
            "<=" -> result = result.dropLast(1)
            else -> if (result == "") result = value else result += value
        }
    }

    var showDialog by
    mutableStateOf(false)



    suspend fun saveSettings(context: Context, settings: String, key: String) {
        val key = stringPreferencesKey(key)
        context.dataStore.edit {
            it[key] = settings
        }
    }

    val mapScores = mutableMapOf("easy60" to "", "easy180" to "", "easy300" to "")


    var stateApp by mutableStateOf(MainState())

    fun onEvent(event: MainEvent) {
        when(event) {
            is MainEvent.ThemeChange -> {
                stateApp = stateApp.copy(theme = event.theme)
            }
            is MainEvent.OpenDialog -> {
                stateApp = stateApp.copy(openDialog = event.openDialog)
            }
        }
    }

    //background
    val backgroundImage = when (stateApp.theme) {
        AppTheme.Blue -> {
            R.drawable.blue
        }
        AppTheme.Gradient -> {
            R.drawable.gradient
        }
        AppTheme.Colorful -> {
            R.drawable.colorful
        }
        AppTheme.DarkBlue -> {
            R.drawable.dark_blue
        }
        AppTheme.RedBlueBlack -> {
            R.drawable.red_blue_black
        }
        AppTheme.Magenta -> {
            R.drawable.magenta
        }
    }

    var background by
    mutableStateOf(
        backgroundImage
    )
}

sealed class MainEvent {
    data class ThemeChange(val theme: AppTheme): MainEvent()
    data class OpenDialog(val openDialog: Boolean): MainEvent()
}

data class MainState(
    val theme: AppTheme = AppPreferences.getTheme(),
    val openDialog: Boolean = false
)