package com.openrideafrica.core.designsystem.component.atom

import android.content.res.Configuration
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import com.openrideafrica.core.designsystem.theme.OpenRideTheme
import com.openrideafrica.core.designsystem.theme.brandColors
import com.openrideafrica.core.designsystem.theme.dimensions

@Composable
fun IconTile(
    modifier: Modifier = Modifier,
    icon: ImageVector,
    contentDescription: String?,
    container: Color = MaterialTheme.brandColors.tile,
    content: Color = MaterialTheme.brandColors.onTile,
    size: TileSize = TileSize.Medium,
) {
    val dims = MaterialTheme.dimensions

    val boxSize = when (size) {
        TileSize.Small -> dims.xxl
        TileSize.Medium -> dims.xxxl
        TileSize.Large -> dims.tileLarge
    }

    val iconSize = when (size) {
        TileSize.Small -> dims.iconSm
        TileSize.Medium -> dims.iconMd
        TileSize.Large -> dims.iconLg
    }

    Surface(
        shape = MaterialTheme.shapes.medium,
        color = container,
        contentColor = content,
        modifier = modifier.size(boxSize),
    ) {
        Box(
            contentAlignment = Alignment.Center,
        ) {
            Icon(
                imageVector = icon,
                contentDescription = contentDescription,
                modifier = Modifier.size(iconSize),
            )
        }
    }
}

enum class TileSize { Small, Medium, Large }

@Preview(showBackground = true)
@Composable
private fun IconTileSmallPreview() {
    OpenRideTheme {
        IconTile(
            icon = Icons.Default.Home,
            contentDescription = "Home",
            size = TileSize.Small,
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun IconTileMediumPreview() {
    OpenRideTheme {
        IconTile(
            icon = Icons.Default.Home,
            contentDescription = "Home",
            size = TileSize.Medium,
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun IconTileLargePreview() {
    OpenRideTheme {
        IconTile(
            icon = Icons.Default.Home,
            contentDescription = "Home",
            size = TileSize.Large,
        )
    }
}

@Preview(
    name = "All Sizes Dark",
    showBackground = true,
    uiMode = Configuration.UI_MODE_NIGHT_YES,
)

@Preview(
    name = "All Sizes",
    showBackground = true,
    widthDp = 320,
)
@Composable
private fun IconTileGalleryPreview() {
    OpenRideTheme {
        Row(
            horizontalArrangement = Arrangement.spacedBy(
                MaterialTheme.dimensions.md
            ),
            modifier = Modifier.padding(
                MaterialTheme.dimensions.lg
            )
        ) {
            IconTile(
                icon = Icons.Default.Home,
                contentDescription = "Small",
                size = TileSize.Small,
            )

            IconTile(
                icon = Icons.Default.Home,
                contentDescription = "Medium",
                size = TileSize.Medium,
            )

            IconTile(
                icon = Icons.Default.Home,
                contentDescription = "Large",
                size = TileSize.Large,
            )
        }
    }
}