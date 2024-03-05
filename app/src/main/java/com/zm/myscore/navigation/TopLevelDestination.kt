package com.zm.myscore.navigation

import androidx.compose.ui.graphics.vector.ImageVector
import com.zm.myscore.R
import com.zm.myscore.core.designsystem.icon.MyScoreIcons

enum class TopLevelDestination(
    val selectedIcon: ImageVector,
    val unselectedIcon: ImageVector,
    val iconTextId: Int,
    val titleTextId: Int,
) {
    ALL_GAMES(
        selectedIcon = MyScoreIcons.AllGames,
        unselectedIcon = MyScoreIcons.AllGamesBorder,
        iconTextId = R.string.all_games,
        titleTextId = R.string.all_games,
    ),
    LIVE(
        selectedIcon = MyScoreIcons.Live,
        unselectedIcon = MyScoreIcons.LiveBorder,
        iconTextId = R.string.live,
        titleTextId = R.string.live,
    ),
    FAVOURITES(
        selectedIcon = MyScoreIcons.Favourites,
        unselectedIcon = MyScoreIcons.FavouritesBorder,
        iconTextId = R.string.favourites,
        titleTextId = R.string.favourites,
    ),
    STANDINGS(
        selectedIcon = MyScoreIcons.Standings,
        unselectedIcon = MyScoreIcons.StandingsBorder,
        iconTextId = R.string.standings,
        titleTextId = R.string.standings,
    ),
}