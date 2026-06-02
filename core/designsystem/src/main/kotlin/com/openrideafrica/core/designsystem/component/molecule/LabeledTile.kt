package com.openrideafrica.core.designsystem.component.molecule

import android.content.res.Configuration
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DirectionsCar
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import com.openrideafrica.core.designsystem.component.atom.IconTile
import com.openrideafrica.core.designsystem.component.atom.TileSize
import com.openrideafrica.core.designsystem.theme.OpenRideTheme
import com.openrideafrica.core.designsystem.theme.brandColors
import com.openrideafrica.core.designsystem.theme.dimensions

@Composable
fun LabeledTile(
    icon: ImageVector,
    label: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    tileColor: Color = MaterialTheme.brandColors.tile,
    tileContentColor: Color = MaterialTheme.brandColors.onTile,
    tileSize: TileSize = TileSize.Large,
    enabled: Boolean = true,
) {
    val interactionSource = remember { MutableInteractionSource() }

    Column(
        modifier = modifier.clickable(
            enabled = enabled,
            interactionSource = interactionSource,
            indication = null,
            role = Role.Button,
            onClick = onClick,
        ),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(MaterialTheme.dimensions.sm),
    ) {
        IconTile(
            icon = icon,
            contentDescription = label,
            container = tileColor,
            content = tileContentColor,
            size = tileSize,
        )

        Text(
            text = label,
            style = MaterialTheme.typography.bodyMedium,
            color = MaterialTheme.colorScheme.onSurface,
            textAlign = TextAlign.Center,
        )
    }
}
@Preview(
    name = "Rating Stars Dark",
    showBackground = true,
    uiMode = Configuration.UI_MODE_NIGHT_YES,
)
@Preview(showBackground = true)
@Composable
private fun LabeledTilePreview() {
    OpenRideTheme {
        LabeledTile(
            icon = Icons.Filled.DirectionsCar,
            label = "Ride",
            onClick = {}
        )
    }
}