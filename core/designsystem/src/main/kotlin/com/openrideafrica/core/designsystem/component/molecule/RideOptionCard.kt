package com.openrideafrica.core.designsystem.component.molecule

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Schedule
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.openrideafrica.core.designsystem.component.atom.PriceTag
import com.openrideafrica.core.designsystem.theme.OpenRideTheme
import com.openrideafrica.core.designsystem.theme.brandColors
import com.openrideafrica.core.designsystem.theme.dimensions

/**
 * A selectable ride option (Muve Economy / Premium). Selected = pale-yellow fill
 * + thin dark outline + rounded. Shows vehicle icon, name, ETA + capacity, and a
 * [PriceTag] with optional promo. "Recommended" badge intentionally omitted.
 */
@Composable
fun RideOptionCard(
    vehicleIcon: ImageVector,
    name: String,
    etaMinutes: Int,
    capacity: Int,
    price: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    originalPrice: String? = null,
    selected: Boolean = false,
) {
    val brand = MaterialTheme.brandColors
    val container = if (selected) brand.selectedContainer else MaterialTheme.colorScheme.surface

    Surface(
        onClick = onClick,
        shape = MaterialTheme.shapes.large,
        color = container,
        modifier = modifier
            .fillMaxWidth()
            .then(
                if (selected) {
                    Modifier.border(1.dp, brand.selectedOutline, MaterialTheme.shapes.large)
                } else {
                    Modifier
                }
            ),
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(MaterialTheme.dimensions.lg),
            modifier = Modifier.padding(MaterialTheme.dimensions.lg),
        ) {
            Icon(
                imageVector = vehicleIcon,
                contentDescription = null,
                modifier = Modifier.size(MaterialTheme.dimensions.tileLarge),
            )
            Column(
                verticalArrangement = Arrangement.spacedBy(MaterialTheme.dimensions.xs),
                modifier = Modifier.weight(1f),
            ) {
                Text(
                    text = name,
                    style = MaterialTheme.typography.titleMedium,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                )
                Row(
                    horizontalArrangement = Arrangement.spacedBy(MaterialTheme.dimensions.lg),
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    MetaItem(Icons.Filled.Schedule, "$etaMinutes min")
                    MetaItem(Icons.Filled.Person, capacity.toString())
                }
            }
            PriceTag(price = price, originalPrice = originalPrice)
        }
    }
}

@Composable
private fun MetaItem(icon: ImageVector, text: String) {
    Row(
        horizontalArrangement = Arrangement.spacedBy(MaterialTheme.dimensions.xs),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Icon(
            imageVector = icon,
            contentDescription = null,
            tint = MaterialTheme.colorScheme.onSurfaceVariant,
            modifier = Modifier.size(MaterialTheme.dimensions.iconSm),
        )
        Text(
            text = text,
            style = MaterialTheme.typography.bodyMedium,
            color = MaterialTheme.colorScheme.onSurfaceVariant,
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun RideOptionCardPreview_Unselected() {
    OpenRideTheme {
        RideOptionCard(
            vehicleIcon = Icons.Filled.Person,
            name = "Standard Ride",
            etaMinutes = 5,
            capacity = 4,
            price = "KSh 450",
            originalPrice = "KSh 600",
            selected = false,
            onClick = {}
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun RideOptionCardPreview_Selected() {
    OpenRideTheme {
        RideOptionCard(
            vehicleIcon = Icons.Filled.Person,
            name = "Premium Ride",
            etaMinutes = 3,
            capacity = 3,
            price = "KSh 900",
            originalPrice = "KSh 1200",
            selected = true,
            onClick = {}
        )
    }
}