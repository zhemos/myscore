package com.zm.myscore.core.designsystem.component

import androidx.annotation.StringRes
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clipToBounds
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.zm.myscore.core.designsystem.icon.MyScoreIcons
import com.zm.myscore.core.designsystem.theme.MyScoreColors

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyScoreTopAppBar(
    @StringRes titleRes: Int,
    modifier: Modifier = Modifier,
    interactionSource: MutableInteractionSource = remember { MutableInteractionSource() },
    onSearchClick: () -> Unit = {},
    onSettingsClick: () -> Unit = {},
) {
    Row(
        modifier = modifier
            .windowInsetsPadding(TopAppBarDefaults.windowInsets)
            .clipToBounds()
            .fillMaxWidth()
            .height(56.dp)
            .background(MaterialTheme.colorScheme.primary)
            .padding(horizontal = 12.dp),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Box(
            modifier = Modifier.size(32.dp),
        ) {
            Icon(
                imageVector = MyScoreIcons.Ball,
                contentDescription = "Ball",
                tint = MyScoreColors.White,
                modifier = Modifier.fillMaxSize(),
            )
        }
        Spacer(modifier = Modifier.width(6.dp))
        Text(
            text = stringResource(id = titleRes),
            style = MaterialTheme.typography.titleMedium,
            color = MyScoreColors.White,
        )
        Row(
            modifier = modifier.fillMaxSize(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.End,
        ) {
            Box(
                modifier = modifier
                    .size(28.dp)
                    .clickable(
                        onClick = onSearchClick,
                        enabled = true,
                        role = Role.Button,
                        interactionSource = interactionSource,
                        indication = null
                    ),
            ) {
                Icon(
                    imageVector = MyScoreIcons.Search,
                    contentDescription = "Search",
                    tint = MyScoreColors.White,
                    modifier = Modifier.fillMaxSize(),
                )
            }
            Spacer(modifier = Modifier.width(8.dp))
            Box(
                modifier = modifier
                    .size(28.dp)
                    .clickable(
                        onClick = onSettingsClick,
                        enabled = true,
                        role = Role.Button,
                        interactionSource = interactionSource,
                        indication = null
                    ),
            ) {
                Icon(
                    imageVector = MyScoreIcons.Settings,
                    contentDescription = "Settings",
                    tint = MyScoreColors.White,
                    modifier = Modifier.fillMaxSize(),
                )
            }
        }
    }
}

@Preview("Top App Bar")
@Composable
private fun MyScoreTopAppBarPreview() {
    MyScoreTopAppBar(
        titleRes = android.R.string.untitled,
    )
}