package ua.vitolex.mathgames.main

import android.annotation.SuppressLint
import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.RequiresApi
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.hilt.navigation.compose.hiltViewModel
import com.google.accompanist.navigation.animation.rememberAnimatedNavController
import com.google.android.gms.ads.MobileAds
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.map
import ua.vitolex.buns.presentation.navigation.SetupNavHost
import ua.vitolex.mathgames.app.dataStore
import ua.vitolex.mathgames.ui.theme.MathGamesTheme



//@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    @SuppressLint("FlowOperatorInvokedInComposition", "SuspiciousIndentation")
    @RequiresApi(Build.VERSION_CODES.O)
    @OptIn(ExperimentalAnimationApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberAnimatedNavController()
            val viewModel: MainViewModel = hiltViewModel()

            var context = LocalContext.current

            val listScore = listOf(
                "easy60", "easy180", "easy300",
                "medium60", "medium180", "medium300",
                "hard60", "hard180", "hard300"
            )
            listScore.forEach {
                val key = stringPreferencesKey(it)
                val score =
                    context.dataStore.data.map {
                        it[key]
                    }.collectAsState(initial = "")
                viewModel.mapScores += it to score.value.toString()
            }

            MathGamesTheme(appTheme = viewModel.stateApp.theme)
            {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    SetupNavHost(
                        navController = navController,
                        viewModel = viewModel,
                    )
                }
            }
        }
        MobileAds.initialize(this)
    }
}

