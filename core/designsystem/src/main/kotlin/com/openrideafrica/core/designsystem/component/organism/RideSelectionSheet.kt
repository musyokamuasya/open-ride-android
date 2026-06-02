package com.openrideafrica.core.designsystem.component.organism

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.DirectionsCar
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.Payments
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.openrideafrica.core.designsystem.component.atom.IconTile
import com.openrideafrica.core.designsystem.component.atom.OpenRidePrimaryButton
import com.openrideafrica.core.designsystem.component.atom.TileSize
import com.openrideafrica.core.designsystem.component.molecule.RideOptionCard
import com.openrideafrica.core.designsystem.theme.OpenRideTheme
import com.openrideafrica.core.designsystem.theme.brandColors
import com.openrideafrica.core.designsystem.theme.dimensions


data class RideOption(
    val id: String,
    val name: String,
    val etaMinutes: Int,
    val capacity: Int,
    val price: String,
    val originalPrice: String? = null,
    val icon: androidx.compose.ui.graphics.vector.ImageVector = Icons.Filled.DirectionsCar,
)

@Composable
fun RideSelectionSheet(
    options: List<RideOption>,
    selectedOptionId: String?,
    paymentLabel: String,
    paymentSubtitle: String,
    onOptionSelect: (RideOption) -> Unit,
    onPaymentClick: () -> Unit,
    onSelectRide: () -> Unit,
    modifier: Modifier = Modifier,
    promoText: String? = null,
) {

    Column(modifier = modifier.fillMaxWidth()) {
        promoText?.let {
            PromoBanner(text = it)
        }
        
        Column(
            modifier = Modifier.padding(MaterialTheme.dimensions.lg),
            verticalArrangement = Arrangement.spacedBy(MaterialTheme.dimensions.md),
        ) {
            options.forEach { option ->
                RideOptionCard(
                    vehicleIcon = option.icon,
                    name = option.name,
                    etaMinutes = option.etaMinutes,
                    capacity = option.capacity,
                    price = option.price,
                    originalPrice = option.originalPrice,
                    selected = option.id == selectedOptionId,
                    onClick = { onOptionSelect(option) },
                )
            }

            PaymentSummaryRow(
                label = paymentLabel,
                subtitle = paymentSubtitle,
                onClick = onPaymentClick,
            )

            OpenRidePrimaryButton(
                text = "Select ride",
                onClick = onSelectRide,
                enabled = selectedOptionId != null,
            )
        }
    }
}

@Composable
private fun PromoBanner(text: String) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(MaterialTheme.brandColors.tile)
            .padding(
                horizontal = MaterialTheme.dimensions.lg,
                vertical = MaterialTheme.dimensions.md,
            ),
        horizontalArrangement = Arrangement.spacedBy(MaterialTheme.dimensions.sm,
            Alignment.CenterHorizontally),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Icon(
            imageVector = Icons.Filled.Check,
            contentDescription = null,
            tint = MaterialTheme.brandColors.onTile,
            modifier = Modifier.size(MaterialTheme.dimensions.iconSm),
        )
        Text(
            text = text,
            style = MaterialTheme.typography.titleMedium,
            color = MaterialTheme.brandColors.onTile,
        )
    }
}

@Composable
private fun PaymentSummaryRow(
    label: String,
    subtitle: String,
    onClick: () -> Unit,
) {
    val interactionSource = remember { MutableInteractionSource() }
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable(
                interactionSource = interactionSource,
                indication = null,
                onClick = onClick,
            ),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(MaterialTheme.dimensions.md),
    ) {
        IconTile(
            icon = Icons.Filled.Payments,
            contentDescription = null,
            size = TileSize.Small,
        )
        Column(modifier = Modifier.weight(1f)) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Text(text = label, style = MaterialTheme.typography.titleMedium)
                Icon(
                    imageVector = Icons.Filled.KeyboardArrowDown,
                    contentDescription = null,
                    modifier = Modifier.size(MaterialTheme.dimensions.iconMd),
                )
            }
            Text(
                text = subtitle,
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onSurfaceVariant,
            )
        }
    }
}

@Preview(showBackground = true, heightDp = 560)
@Composable
private fun RideSelectionSheetPreview() {
    OpenRideTheme {
        var selected by remember { mutableStateOf("economy") }
        RideSelectionSheet(
            promoText = "50% promo applied",
            options = listOf(
                RideOption("economy", "Economy", 2, 4, "KES 1,000", "#1,800"),
                RideOption("standard", "Standard", 2, 4, "KES 2,000", "#1,800"),
                RideOption("premium", "Premium", 5, 4, "KES 4,000"),
            ),
            selectedOptionId = selected,
            paymentLabel = "Cash",
            paymentSubtitle = "Personal ride",
            onOptionSelect = { selected = it.id },
            onPaymentClick = {},
            onSelectRide = {},
        )
    }
}