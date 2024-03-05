package com.zm.myscore.feature.live.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.zm.myscore.feature.live.LiveRoute

const val liveRoute = "live_route"

fun NavController.navigateToLive(navOptions: NavOptions? = null) {
    this.navigate(liveRoute, navOptions)
}

fun NavGraphBuilder.liveScreen() {
    composable(
        route = liveRoute
    ) {
        LiveRoute()
    }
}