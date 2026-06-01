package com.openrideafrica.core.designsystem.component.molecule

import android.content.res.Configuration
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CarCrash
import androidx.compose.material.icons.filled.DirectionsCar
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import com.openrideafrica.core.designsystem.R
import com.openrideafrica.core.designsystem.theme.OpenRideTheme
import com.openrideafrica.core.designsystem.theme.dimensions


@Composable
fun RideTypeRow(
    modifier: Modifier = Modifier,
    icon: ImageVector,
    name: String,
    etaMinutes: Int,
    price: String,
    onClick: () -> Unit,
    selected: Boolean = false,
) {
    val container = if (selected) MaterialTheme.colorScheme.secondaryContainer
    else MaterialTheme.colorScheme.surface

    Surface(
        onClick = onClick,
        shape = MaterialTheme.shapes.medium,
        color = container,
        modifier = modifier.fillMaxWidth(),
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(MaterialTheme.dimensions.lg),
            modifier = modifier.padding(MaterialTheme.dimensions.lg),
        ) {
            Icon(
                imageVector = icon,
                contentDescription = name,
                modifier = modifier.size(MaterialTheme.dimensions.iconLg),
            )
            Column(
                verticalArrangement = Arrangement.spacedBy(MaterialTheme.dimensions.xs),
                modifier = modifier.weight(1f),
            ) {
                Text(
                    text = name,
                    style = MaterialTheme.typography.titleMedium,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                )
                Text(
                    text = stringResource(id = R.string.core_designsystem_min_away, etaMinutes),
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.onSurfaceVariant,
                )
            }
            Text(text = price, style = MaterialTheme.typography.titleMedium)
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun RideTypeRowPreviewLight() {
    OpenRideTheme {
        Box(Modifier.padding(MaterialTheme.dimensions.lg)) {
            RideTypeRow(
                name = "Confirm ride",
                icon = Icons.Default.DirectionsCar,
                etaMinutes = 4,
                price = "Ksh 800",
                onClick = {}
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun SelectedRideTypeRowPreviewLight() {
    OpenRideTheme {
        Box(Modifier.padding(MaterialTheme.dimensions.lg)) {
            RideTypeRow(
                name = "Confirm ride",
                icon = Icons.Default.DirectionsCar,
                etaMinutes = 4,
                price = "Ksh 800",
                onClick = {},
                selected = true
            )
        }
    }
}

@Preview(
    name = "Dark Theme",
    showBackground = true,
    uiMode = Configuration.UI_MODE_NIGHT_YES
)
@Composable
private fun RideTypeRowPreviewDark() {
    OpenRideTheme(darkTheme = true) {
        Box(Modifier.padding(MaterialTheme.dimensions.lg)) {
            RideTypeRow(
                name = "Confirm ride",
                icon = Icons.Default.DirectionsCar,
                etaMinutes = 4,
                price = "Ksh 800",
                onClick = {}
            )
        }
    }
}

@Preview(
    name = "Dark Theme",
    showBackground = true,
    uiMode = Configuration.UI_MODE_NIGHT_YES
)
@Composable
private fun SelectedRideTypeRowPreviewDark() {
    OpenRideTheme(darkTheme = true) {
        Box(Modifier.padding(MaterialTheme.dimensions.lg)) {
            RideTypeRow(
                name = "Confirm ride",
                icon = Icons.Default.DirectionsCar,
                etaMinutes = 4,
                price = "Ksh 800",
                onClick = {},
                selected = true
            )
        }
    }
}