package com.zm.myscore.ui

import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.WindowInsetsSides
import androidx.compose.foundation.layout.consumeWindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.only
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawing
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarDuration
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.SnackbarResult
import androidx.compose.material3.Text
import androidx.compose.material3.windowsizeclass.WindowSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.semantics.testTagsAsResourceId
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import com.zm.myscore.R
import com.zm.myscore.core.designsystem.component.MyScoreBackground
import com.zm.myscore.core.designsystem.component.MyScoreNavigationBar
import com.zm.myscore.core.designsystem.component.MyScoreNavigationBarItem
import com.zm.myscore.core.designsystem.component.MyScoreTopAppBar
import com.zm.myscore.navigation.MyScoreNavHost
import com.zm.myscore.navigation.TopLevelDestination

@OptIn(
    ExperimentalComposeUiApi::class,
)
@Composable
fun MyScoreApp(
    windowSizeClass: WindowSizeClass,
    appState: MyScoreAppState = rememberMyScoreAppState(
        windowSizeClass = windowSizeClass,
    ),
) {
    MyScoreBackground {
        val snackbarHostState = remember { SnackbarHostState() }
        Scaffold(
            modifier = Modifier.semantics {
                testTagsAsResourceId = true
            },
            containerColor = MaterialTheme.colorScheme.primary,
            contentColor = Color.Red,//?
            contentWindowInsets = WindowInsets(0, 0, 0, 0),
            snackbarHost = { SnackbarHost(snackbarHostState) },
            bottomBar = {
                MyScoreBottomBar(
                    destinations = appState.topLevelDestination,
                    onNavigateToDestination = appState::navigateToTopLevelDestination,
                    currentDestination = appState.currentDestination,
                    modifier = Modifier.testTag("NiaBottomBar"),
                )
            },
        ) { padding ->
            Row(
                Modifier
                    .fillMaxSize()
                    .padding(padding)
                    .consumeWindowInsets(padding)
                    .windowInsetsPadding(
                        WindowInsets.safeDrawing.only(
                            WindowInsetsSides.Horizontal,
                        ),
                    ),
            ) {
                Column(Modifier.fillMaxSize()) {
                    MyScoreTopAppBar(
                        titleRes = R.string.app_name,
                        onSearchClick = {
                          Log.d("zm1996", "search")
                        },
                        onSettingsClick = {
                            Log.d("zm1996", "settings")
                        },
                    )
                    MyScoreNavHost(appState = appState, onShowSnackbar = { message, action ->
                        snackbarHostState.showSnackbar(
                            message = message,
                            actionLabel = action,
                            duration = SnackbarDuration.Short,
                        ) == SnackbarResult.ActionPerformed
                    })
                }
            }
        }
    }
}

@Composable
private fun MyScoreBottomBar(
    destinations: List<TopLevelDestination>,
    onNavigateToDestination: (TopLevelDestination) -> Unit,
    currentDestination: NavDestination?,
    modifier: Modifier = Modifier,
) {
    MyScoreNavigationBar(
        modifier = modifier,
    ) {
        destinations.forEach { destination ->
            val selected = currentDestination.isTopLevelDestinationInHierarchy(destination)
            MyScoreNavigationBarItem(
                selected = selected,
                onClick = { onNavigateToDestination(destination) },
                icon = {
                    Icon(
                        imageVector = destination.unselectedIcon,
                        contentDescription = null,
                    )
                },
                selectedIcon = {
                    Icon(
                        imageVector = destination.selectedIcon,
                        contentDescription = null,
                    )
                },
                label = { Text(stringResource(destination.iconTextId)) },
            )
        }
    }
}

private fun NavDestination?.isTopLevelDestinationInHierarchy(destination: TopLevelDestination) =
    this?.hierarchy?.any {
        it.route?.contains(destination.name, true) ?: false
    } ?: false