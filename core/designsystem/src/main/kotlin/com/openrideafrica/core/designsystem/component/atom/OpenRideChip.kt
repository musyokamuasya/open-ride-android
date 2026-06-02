package com.openrideafrica.core.designsystem.component.atom

import android.content.res.Configuration
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
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
import com.openrideafrica.core.designsystem.theme.OpenRideTheme
import com.openrideafrica.core.designsystem.theme.dimensions


@Composable
fun OpenRideChip(
    label: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    icon: ImageVector? = null,
    selected: Boolean = false,
) {
    val container = if (selected) {
        MaterialTheme.colorScheme.primary
    } else {
        MaterialTheme.colorScheme.surfaceVariant
    }
    val content = if (selected) {
        MaterialTheme.colorScheme.onPrimary
    } else {
        MaterialTheme.colorScheme.onSurfaceVariant
    }

    Surface(
        onClick = onClick,
        shape = RoundedCornerShape(percent = 50),
        color = container,
        contentColor = content,
        border = if (selected) null else BorderStroke(1.dp, MaterialTheme.colorScheme.outline),
        modifier = modifier,
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(MaterialTheme.dimensions.sm),
            modifier = Modifier.padding(
                horizontal = MaterialTheme.dimensions.lg,
                vertical = MaterialTheme.dimensions.md,
            ),
        ) {
            if (icon != null) {
                Icon(
                    imageVector = icon,
                    contentDescription = null,
                    modifier = Modifier.size(MaterialTheme.dimensions.iconSm),
                )
            }
            Text(text = label, style = MaterialTheme.typography.labelLarge)
        }
    }
}
@Preview(
    name = "Dark Theme",
    showBackground = true,
    uiMode = Configuration.UI_MODE_NIGHT_YES
)
@Preview(showBackground = true)
@Composable
private fun ChipPreviewLight() {
    OpenRideTheme {
        Box(Modifier.padding(MaterialTheme.dimensions.lg)) {
            OpenRideChip(
                label = "Confirm",
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

@Preview(showBackground = true)
@Composable
private fun ChipPreviewLightWithIcon() {
    OpenRideTheme {
        Box(Modifier.padding(MaterialTheme.dimensions.lg)) {
            OpenRideChip(
                label = "Confirm",
                onClick = {},
                icon = Icons.Default.Check
            )
        }
    }
}
@Preview(
    name = "Dark Theme",
    showBackground = true,
    uiMode = Configuration.UI_MODE_NIGHT_YES
)
@Preview(showBackground = true)
@Composable
private fun SelectedChipPreview() {
    OpenRideTheme {
        Box(Modifier.padding(MaterialTheme.dimensions.lg)) {
            OpenRideChip(
                label = "Confirm",
                onClick = {},
                selected = true
            )
        }
    }
}