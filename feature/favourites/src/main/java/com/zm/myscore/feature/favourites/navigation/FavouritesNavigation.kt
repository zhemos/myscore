package com.zm.myscore.feature.favourites.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.zm.myscore.feature.favourites.FavouritesRoute

const val favouritesRoute = "favourites_route"

fun NavController.navigateToFavourites(navOptions: NavOptions? = null) {
    this.navigate(favouritesRoute, navOptions)
}

fun NavGraphBuilder.favouritesScreen() {
    composable(
        route = favouritesRoute
    ) {
        FavouritesRoute()
    }
}