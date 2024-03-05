package com.zm.myscore.feature.standings.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.zm.myscore.feature.standings.StandingsRoute

const val standingsRoute = "standings_route"

fun NavController.navigateToStandings(navOptions: NavOptions? = null) {
    this.navigate(standingsRoute, navOptions)
}

fun NavGraphBuilder.standingsScreen() {
    composable(
        route = standingsRoute
    ) {
        StandingsRoute()
    }
}