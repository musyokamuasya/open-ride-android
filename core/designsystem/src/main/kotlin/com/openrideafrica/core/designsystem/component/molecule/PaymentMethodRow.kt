package com.openrideafrica.core.designsystem.component.molecule

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Schedule
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.openrideafrica.core.designsystem.component.atom.IconTile
import com.openrideafrica.core.designsystem.component.atom.TileSize
import com.openrideafrica.core.designsystem.theme.OpenRideTheme
import com.openrideafrica.core.designsystem.theme.brandColors
import com.openrideafrica.core.designsystem.theme.dimensions


@Composable
fun PaymentMethodRow(
    icon: ImageVector,
    label: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    selected: Boolean = false,
    amount: String? = null,
) {
    val brand = MaterialTheme.brandColors
    val shape = MaterialTheme.shapes.large

    Surface(
        onClick = onClick,
        shape = shape,
        color = if (selected) brand.selectedContainer else MaterialTheme.colorScheme.surface,
        border = if (selected) BorderStroke(1.dp, brand.selectedOutline)
        else BorderStroke(1.dp, MaterialTheme.colorScheme.outlineVariant),
        modifier = modifier.fillMaxWidth(),
    ) {
        Row(
            modifier = Modifier.padding(MaterialTheme.dimensions.lg),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(MaterialTheme.dimensions.md),
        ) {
            SelectionIndicator(selected)

            IconTile(
                icon = icon,
                contentDescription = null,
                size = TileSize.Small,
            )

            Text(
                text = label,
                style = MaterialTheme.typography.titleMedium,
                modifier = Modifier.weight(1f),
            )

            amount?.let {
                Text(
                    text = it,
                    style = MaterialTheme.typography.titleMedium,
                )
            }
        }
    }
}

@Composable
private fun SelectionIndicator(selected: Boolean) {
    val dims = MaterialTheme.dimensions
    val shape = CircleShape

    Surface(
        shape = shape,
        color = if (selected)
            MaterialTheme.colorScheme.primary
        else
            MaterialTheme.colorScheme.surface,
        contentColor = if (selected)
            MaterialTheme.colorScheme.onPrimary
        else
            MaterialTheme.colorScheme.outline,
        border = if (!selected)
            BorderStroke(1.dp, MaterialTheme.colorScheme.outline)
        else null,
        modifier = Modifier.size(dims.iconLg),
    ) {
        Box(contentAlignment = Alignment.Center) {
            if (selected) {
                Icon(
                    imageVector = Icons.Filled.Check,
                    contentDescription = null,
                    modifier = Modifier.size(dims.iconSm),
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun PaymentMethodRowPreview_Unselected() {
    OpenRideTheme {
        PaymentMethodRow(
            icon = Icons.Default.Schedule,
            label = "M-Pesa",
            amount = "KES 450",
            selected = false,
            onClick = {}
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun PaymentMethodRowPreview_Selected() {
    OpenRideTheme {
        PaymentMethodRow(
            icon = Icons.Default.Schedule,
            label = "M-Pesa",
            amount = "KES 450",
            selected = true,
            onClick = {}
        )
    }
}