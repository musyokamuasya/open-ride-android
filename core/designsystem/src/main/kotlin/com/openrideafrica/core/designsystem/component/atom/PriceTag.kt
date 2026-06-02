package com.openrideafrica.core.designsystem.component.atom

import android.content.res.Configuration
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import com.openrideafrica.core.designsystem.theme.OpenRideTheme
import com.openrideafrica.core.designsystem.theme.dimensions

@Composable
fun PriceTag(
    price: String,
    modifier: Modifier = Modifier,
    originalPrice: String? = null,
) {
    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.spacedBy(MaterialTheme.dimensions.sm),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Text(
            text = price,
            style = MaterialTheme.typography.titleMedium,
            color = MaterialTheme.colorScheme.onSurface,
        )
        originalPrice?.let { op ->
            Text(
                text = op,
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onSurfaceVariant,
                textDecoration = TextDecoration.LineThrough,
            )
        }
    }
}

@Preview(
    name = "Light",
    showBackground = true,
)
@Preview(
    name = "Dark",
    showBackground = true,
    uiMode = Configuration.UI_MODE_NIGHT_YES,
)
@Composable
private fun PriceTagPreview() {
    OpenRideTheme {
        PriceTag(
            price = "KES 2500",
            originalPrice = "KES 4000",
        )
    }
}

@Preview(
    name = "Current Price Only",
    showBackground = true,
)
@Composable
private fun PriceTagCurrentOnlyPreview() {
    OpenRideTheme {
        PriceTag(
            price = "KES 25",
        )
    }
}

@Preview(
    name = "Price Variants",
    showBackground = true,
    widthDp = 320,
)
@Composable
private fun PriceTagGalleryPreview() {
    OpenRideTheme {
        Column(
            verticalArrangement = Arrangement.spacedBy(
                MaterialTheme.dimensions.md
            ),
            modifier = Modifier.padding(
                MaterialTheme.dimensions.lg
            )
        ) {
            PriceTag(
                price = "KES 2500",
            )

            PriceTag(
                price = "KES 2500",
                originalPrice = "KES 4000",
            )

            PriceTag(
                price = "KES 1,499",
                originalPrice = "KES 2,299",
            )
        }
    }
}