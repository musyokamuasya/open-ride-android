package com.openrideafrica.core.designsystem.component.molecule

import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Schedule
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import com.openrideafrica.core.designsystem.component.atom.IconTile
import com.openrideafrica.core.designsystem.component.atom.TileSize
import com.openrideafrica.core.designsystem.theme.OpenRideTheme
import com.openrideafrica.core.designsystem.theme.brandColors
import com.openrideafrica.core.designsystem.theme.dimensions

@Composable
fun ListItemRow(
    modifier: Modifier = Modifier,
    icon: ImageVector,
    title: String,
    onClick: () -> Unit,
    tileColor: Color = MaterialTheme.brandColors.tile,
    tileContentColor: Color = MaterialTheme.brandColors.onTile,
    subtitle: (@Composable () -> Unit)? = null,
    meta: (@Composable () -> Unit)? = null,
    trailing: (@Composable () -> Unit)? = null,
) {
    val interactionSource = remember { MutableInteractionSource() }

    Row(
        modifier = modifier
            .fillMaxWidth()
            .clickable(
                interactionSource = interactionSource,
                indication = null,
                onClick = onClick,
            )
            .padding(vertical = MaterialTheme.dimensions.md),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(MaterialTheme.dimensions.lg),
    ) {
        IconTile(
            icon = icon,
            contentDescription = title,
            container = tileColor,
            content = tileContentColor,
            size = TileSize.Medium,
        )

        Column(
            modifier = Modifier.weight(1f),
            verticalArrangement = Arrangement.spacedBy(MaterialTheme.dimensions.xs),
        ) {
            Text(
                text = title,
                style = MaterialTheme.typography.titleMedium,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
            )

            subtitle?.invoke()
            meta?.invoke()
        }

        trailing?.invoke()
    }
}

@Composable
private fun Meta(icon: ImageVector, text: String) {
    Row(
        horizontalArrangement = Arrangement.spacedBy(MaterialTheme.dimensions.xs),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Icon(
            imageVector = icon,
            contentDescription = null,
            tint = MaterialTheme.colorScheme.onSurface,
            modifier = Modifier.size(MaterialTheme.dimensions.iconSm),
        )
        Text(
            text = text,
            style = MaterialTheme.typography.labelLarge,
            color = MaterialTheme.colorScheme.onSurface,
        )
    }
}

@Preview(showBackground = true)
@Composable
fun ListItemRowPreview_Default() {
    OpenRideTheme {
        ListItemRow(
            icon = Icons.Default.Person,
            title = "James Karani",
            onClick = {}
        )
    }
}


@Preview(showBackground = true)
@Composable
fun ListItemRowPreviewWithMeta() {
    OpenRideTheme {
        ListItemRow(
            icon = Icons.Default.Person,
            title = "James Karani",
            subtitle = {
                Text("Gold member")
            },
            meta = {
                Row {
                    Meta(Icons.Default.Schedule, "5 min")
                    Meta(Icons.Default.Star, "4.8")
                }
            },
            onClick = {}
        )
    }
}