package com.zm.myscore.feature.all_games.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.zm.myscore.feature.all_games.AllGamesRoute

const val allGamesNavigationRoute = "all_games_route"

fun NavController.navigateToAllGames(navOptions: NavOptions? = null) {
    this.navigate(allGamesNavigationRoute, navOptions)
}

fun NavGraphBuilder.allGamesScreen() {
    composable(
        route = allGamesNavigationRoute
    ) {
        AllGamesRoute()
    }
}