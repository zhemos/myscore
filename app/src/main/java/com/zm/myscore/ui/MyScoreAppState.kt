package com.zm.myscore.ui

import android.util.Log
import androidx.compose.material3.windowsizeclass.WindowSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import androidx.compose.runtime.remember
import androidx.compose.ui.util.trace
import androidx.navigation.NavDestination
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navOptions
import com.zm.myscore.feature.all_games.navigation.allGamesNavigationRoute
import com.zm.myscore.feature.all_games.navigation.navigateToAllGames
import com.zm.myscore.feature.favourites.navigation.favouritesRoute
import com.zm.myscore.feature.favourites.navigation.navigateToFavourites
import com.zm.myscore.feature.live.navigation.liveRoute
import com.zm.myscore.feature.live.navigation.navigateToLive
import com.zm.myscore.feature.standings.navigation.navigateToStandings
import com.zm.myscore.feature.standings.navigation.standingsRoute
import com.zm.myscore.navigation.TopLevelDestination
import com.zm.myscore.navigation.TopLevelDestination.ALL_GAMES
import com.zm.myscore.navigation.TopLevelDestination.FAVOURITES
import com.zm.myscore.navigation.TopLevelDestination.LIVE
import com.zm.myscore.navigation.TopLevelDestination.STANDINGS

@Composable
fun rememberMyScoreAppState(
    windowSizeClass: WindowSizeClass,
    navController: NavHostController = rememberNavController(),
): MyScoreAppState {
    NavigationTrackingSideEffect(navController)
    return remember(navController, windowSizeClass) {
        MyScoreAppState(navController, windowSizeClass)
    }
}

@Stable
class MyScoreAppState(
    val navController: NavHostController,
    val windowSizeClass: WindowSizeClass,
) {
    val currentDestination: NavDestination?
        @Composable get() = navController.currentBackStackEntryAsState().value?.destination

    val currentTopLevelDestination: TopLevelDestination?
        @Composable get() = when (currentDestination?.route) {
            allGamesNavigationRoute -> ALL_GAMES
            liveRoute -> LIVE
            favouritesRoute -> FAVOURITES
            standingsRoute -> STANDINGS
            else -> null
        }

    val topLevelDestination: List<TopLevelDestination> = TopLevelDestination.entries

    fun navigateToTopLevelDestination(topLevelDestination: TopLevelDestination) {
        Log.d("zm1996", "Navigation: ${topLevelDestination.name}")
        trace("Navigation: ${topLevelDestination.name}") {
            val topLevelNavOptions = navOptions {
                // Pop up to the start destination of the graph to
                // avoid building up a large stack of destinations
                // on the back stack as users select items
                popUpTo(navController.graph.findStartDestination().id) {
                    saveState = true
                }
                // Avoid multiple copies of the same destination when
                // reselecting the same item
                launchSingleTop = true
                // Restore state when reselecting a previously selected item
                restoreState = true
            }
            when (topLevelDestination) {
                ALL_GAMES -> { navController.navigateToAllGames(topLevelNavOptions) }
                LIVE -> { navController.navigateToLive(topLevelNavOptions) }
                FAVOURITES -> { navController.navigateToFavourites(topLevelNavOptions) }
                STANDINGS -> { navController.navigateToStandings(topLevelNavOptions) }
            }
        }
    }
}

@Composable
private fun NavigationTrackingSideEffect(navController: NavHostController) {
    //???
}