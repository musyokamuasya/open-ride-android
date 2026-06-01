package com.openrideafrica.core.designsystem.component.molecule

import android.content.res.Configuration
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.openrideafrica.core.designsystem.theme.OpenRideTheme
import com.openrideafrica.core.designsystem.theme.dimensions


@Composable
fun SearchEntryField(
    modifier: Modifier = Modifier,
    placeholder: String,
    onClick: () -> Unit,
) {
    Surface(
        modifier = modifier.fillMaxWidth(),
        onClick = onClick,
        shape = MaterialTheme.shapes.large,
        color = MaterialTheme.colorScheme.surfaceVariant,
        contentColor = MaterialTheme.colorScheme.onSurfaceVariant,
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(MaterialTheme.dimensions.md),
            modifier = modifier.padding(
                horizontal = MaterialTheme.dimensions.lg,
                vertical = MaterialTheme.dimensions.lg,
            ),
        ) {
            Icon(
                imageVector = Icons.Filled.Search,
                contentDescription = placeholder,
                modifier = modifier.size(MaterialTheme.dimensions.iconMd),
            )
            Text(text = placeholder, style = MaterialTheme.typography.bodyLarge)
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun SearchEntryFieldPreviewLight() {
    OpenRideTheme {
        Box(Modifier.padding(MaterialTheme.dimensions.lg)) {
            SearchEntryField(
                placeholder = "Where are you going?",
                onClick = {},
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
private fun SearchEntryFieldPreviewDark() {
    OpenRideTheme(darkTheme = true) {
        Box(Modifier.padding(MaterialTheme.dimensions.lg)) {
            SearchEntryField(
                placeholder = "Where are you going?",
                onClick = {},
            )
        }
    }
}