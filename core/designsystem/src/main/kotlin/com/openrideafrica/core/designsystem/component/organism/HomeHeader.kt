package com.openrideafrica.core.designsystem.component.organism

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.openrideafrica.core.designsystem.component.molecule.SearchEntryField
import com.openrideafrica.core.designsystem.theme.OpenRideTheme
import com.openrideafrica.core.designsystem.theme.brandColors
import com.openrideafrica.core.designsystem.theme.dimensions

/**
 * The Home screen header: circular avatar (yellow ring) + greeting on the left,
 * a black circular menu button on the right, then the "Where to?" search entry.
 * Stateless — data in, events out.
 */
@Composable
fun HomeHeader(
    greetingName: String,
    searchPlaceholder: String,
    onSearchClick: () -> Unit,
    onMenuClick: () -> Unit,
    onAvatarClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(MaterialTheme.dimensions.lg),
        verticalArrangement = Arrangement.spacedBy(MaterialTheme.dimensions.lg),
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(MaterialTheme.dimensions.md),
            modifier = Modifier.fillMaxWidth(),
        ) {
            Avatar(onClick = onAvatarClick)
            Text(
                text = "Hi $greetingName",
                style = MaterialTheme.typography.titleMedium,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
                modifier = Modifier.weight(1f),
            )
            MenuButton(onClick = onMenuClick)
        }

        SearchEntryField(
            placeholder = searchPlaceholder,
            onClick = onSearchClick,
        )
    }
}

@Composable
private fun Avatar(onClick: () -> Unit) {
    val dims = MaterialTheme.dimensions
    Surface(
        onClick = onClick,
        shape = CircleShape,
        color = MaterialTheme.brandColors.tile,
        contentColor = MaterialTheme.brandColors.onTile,
        modifier = Modifier
            .size(dims.xxxl)
            .border(2.dp, MaterialTheme.brandColors.tile, CircleShape),
    ) {
        Box(contentAlignment = Alignment.Center) {
            Icon(
                imageVector = Icons.Filled.Person,
                contentDescription = "Profile",
                modifier = Modifier.size(dims.iconMd),
            )
        }
    }
}

@Composable
private fun MenuButton(onClick: () -> Unit) {
    val dims = MaterialTheme.dimensions
    Surface(
        onClick = onClick,
        shape = CircleShape,
        color = MaterialTheme.colorScheme.primary,
        contentColor = MaterialTheme.colorScheme.onPrimary,
        modifier = Modifier.size(dims.touchTarget),
    ) {
        Box(contentAlignment = Alignment.Center) {
            Icon(
                imageVector = Icons.Filled.Menu,
                contentDescription = "Menu",
                modifier = Modifier.size(dims.iconMd),
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun HomeHeaderPreview() {
    OpenRideTheme {
        HomeHeader(
            greetingName = "Joseph",
            searchPlaceholder = "Where to?",
            onSearchClick = {},
            onMenuClick = {},
            onAvatarClick = {},
        )
    }
}

@Preview(showBackground = true, name = "Dark")
@Composable
private fun HomeHeaderDarkPreview() {
    OpenRideTheme(darkTheme = true) {
        HomeHeader(
            greetingName = "Joseph",
            searchPlaceholder = "Where to?",
            onSearchClick = {},
            onMenuClick = {},
            onAvatarClick = {},
        )
    }
}