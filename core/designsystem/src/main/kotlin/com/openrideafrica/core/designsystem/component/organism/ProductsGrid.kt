package com.openrideafrica.core.designsystem.component.organism

import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.DirectionsBike
import androidx.compose.material.icons.filled.DirectionsCar
import androidx.compose.material.icons.filled.Inventory2
import androidx.compose.material.icons.filled.Restaurant
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import com.openrideafrica.core.designsystem.component.molecule.LabeledTile
import com.openrideafrica.core.designsystem.theme.OpenRideTheme
import com.openrideafrica.core.designsystem.theme.dimensions

data class Product(
    val id: String,
    val label: String,
    val icon: ImageVector,
)

@Composable
fun ProductsGrid(
    title: String,
    products: List<Product>,
    onProductClick: (Product) -> Unit,
    modifier: Modifier = Modifier,
    onSeeAllClick: (() -> Unit)? = null,
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(MaterialTheme.dimensions.lg),
        verticalArrangement = Arrangement.spacedBy(MaterialTheme.dimensions.lg),
    ) {
        SectionHeader(title = title, onSeeAllClick = onSeeAllClick)
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(MaterialTheme.dimensions.md),
        ) {
            products.forEach { product ->
                LabeledTile(
                    icon = product.icon,
                    label = product.label,
                    onClick = { onProductClick(product) },
                    modifier = Modifier.weight(1f),
                )
            }
        }
    }
}

@Composable
fun SectionHeader(
    title: String,
    modifier: Modifier = Modifier,
    onSeeAllClick: (() -> Unit)? = null,
) {
    Row(
        modifier = modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
    ) {
        Text(text = title, style = MaterialTheme.typography.headlineSmall)
        onSeeAllClick?.let {
            Text(
                text = "See all",
                style = MaterialTheme.typography.labelLarge,
                color = MaterialTheme.colorScheme.onSurface,
                textDecoration = TextDecoration.Underline,
                modifier = Modifier.clickable(
                    interactionSource = remember { MutableInteractionSource() },
                    indication = null,
                    onClick = it,
                ),
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun ProductsGridPreview() {
    OpenRideTheme {
        ProductsGrid(
            title = "Our Products",
            products = listOf(
                Product("package", "Package", Icons.Filled.Inventory2),
                Product("rides", "Rides", Icons.Filled.DirectionsCar),
                Product("errands", "Errands", Icons.AutoMirrored.Filled.DirectionsBike),
                Product("food", "Restaurants", Icons.Filled.Restaurant),
            ),
            onProductClick = {},
            onSeeAllClick = {},
        )
    }
}