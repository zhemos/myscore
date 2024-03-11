package com.zm.myscore.navigation

import androidx.compose.ui.graphics.vector.ImageVector
import com.zm.myscore.core.designsystem.icon.MyScoreIcons
import com.zm.myscore.feature.all_games.R as allGamesR
import com.zm.myscore.feature.favourites.R as favouritesR
import com.zm.myscore.feature.live.R as liveR
import com.zm.myscore.feature.standings.R as standingsR

enum class TopLevelDestination(
    val selectedIcon: ImageVector,
    val unselectedIcon: ImageVector,
    val iconTextId: Int,
) {
    ALL_GAMES(
        selectedIcon = MyScoreIcons.AllGames,
        unselectedIcon = MyScoreIcons.AllGamesBorder,
        iconTextId = allGamesR.string.all_games,
    ),
    LIVE(
        selectedIcon = MyScoreIcons.Live,
        unselectedIcon = MyScoreIcons.LiveBorder,
        iconTextId = liveR.string.live,
    ),
    FAVOURITES(
        selectedIcon = MyScoreIcons.Favourites,
        unselectedIcon = MyScoreIcons.FavouritesBorder,
        iconTextId = favouritesR.string.favourites,
    ),
    STANDINGS(
        selectedIcon = MyScoreIcons.Standings,
        unselectedIcon = MyScoreIcons.StandingsBorder,
        iconTextId = standingsR.string.standings,
    ),
}