package com.zm.myscore

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.SystemBarStyle
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.Text
import androidx.compose.material3.windowsizeclass.ExperimentalMaterial3WindowSizeClassApi
import androidx.compose.material3.windowsizeclass.calculateWindowSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.lifecycle.lifecycleScope
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.zm.myscore.MainActivityUiState.Loading
import com.zm.myscore.MainActivityUiState.Success
import com.zm.myscore.core.designsystem.theme.MyScoreTheme
import com.zm.myscore.core.designsystem.theme.getStatusBarColor
import com.zm.myscore.ui.MyScoreApp
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3WindowSizeClassApi::class)
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        val splashScreen = installSplashScreen()
        super.onCreate(savedInstanceState)
        var uiState: MainActivityUiState by mutableStateOf(Loading)

        // Update the uiState
        lifecycleScope.launch {
            delay(1000)
            uiState = Success
        }

        splashScreen.setKeepOnScreenCondition {
            when (uiState) {
                is Loading -> true
                is Success -> false
            }
        }
        setContent {
            val darkTheme = isSystemInDarkTheme()
            val systemUiController = rememberSystemUiController()
            SideEffect {
                val statusBarColor = getStatusBarColor(darkTheme)
                systemUiController.setStatusBarColor(statusBarColor)
            }
            DisposableEffect(darkTheme) {
                enableEdgeToEdge(
                    statusBarStyle = SystemBarStyle.auto(
                        android.graphics.Color.TRANSPARENT,
                        android.graphics.Color.TRANSPARENT,
                    ) { darkTheme },
                    navigationBarStyle = SystemBarStyle.auto(
                        lightScrim,
                        darkScrim,
                    ) { darkTheme },
                )
                onDispose {}
            }
            MyScoreTheme(
                darkTheme = darkTheme,
            ) {
                MyScoreApp(
                    windowSizeClass = calculateWindowSizeClass(this),
                )
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MyScoreTheme {
        Greeting("Android")
    }
}

//@Composable
//private fun shouldUseDarkTheme(
//    uiState: MainActivityUiState,
//): Boolean = when (uiState) {
//    is MainActivityUiState.Loading -> isSystemInDarkTheme()
//    is MainActivityUiState.Success -> true
//}

private val lightScrim = android.graphics.Color.argb(0xe6, 0xFF, 0xFF, 0xFF)
private val darkScrim = android.graphics.Color.argb(0x80, 0x1b, 0x1b, 0x1b)
