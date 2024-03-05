package com.zm.myscore.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import com.zm.myscore.feature.all_games.navigation.allGamesNavigationRoute
import com.zm.myscore.feature.all_games.navigation.allGamesScreen
import com.zm.myscore.feature.favourites.navigation.favouritesScreen
import com.zm.myscore.feature.live.navigation.liveScreen
import com.zm.myscore.feature.standings.navigation.standingsScreen
import com.zm.myscore.ui.MyScoreAppState

@Composable
fun MyScoreNavHost(
    appState: MyScoreAppState,
    onShowSnackbar: suspend (String, String?) -> Boolean,
    modifier: Modifier = Modifier,
    startDestination: String = allGamesNavigationRoute,
) {
    val navController = appState.navController
    NavHost(
        navController = navController,
        startDestination = startDestination,
        modifier = modifier,
    ) {
        allGamesScreen()
        favouritesScreen()
        liveScreen()
        standingsScreen()
    }
}