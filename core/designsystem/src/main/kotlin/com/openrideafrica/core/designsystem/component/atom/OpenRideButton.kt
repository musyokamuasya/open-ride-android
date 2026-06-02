package com.openrideafrica.core.designsystem.component.atom

import android.content.res.Configuration
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.openrideafrica.core.designsystem.theme.OpenRideTheme
import com.openrideafrica.core.designsystem.theme.dimensions

@Composable
fun OpenRidePrimaryButton(
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
) {
    Button(
        onClick = onClick,
        enabled = enabled,
        shape = MaterialTheme.shapes.large,
        colors = ButtonDefaults.buttonColors(
            containerColor = MaterialTheme.colorScheme.primary,
            contentColor = MaterialTheme.colorScheme.onPrimary,
        ),
        modifier = modifier
            .fillMaxWidth()
            .heightIn(min = MaterialTheme.dimensions.buttonHeight),
    ) {
        Text(text = text, style = MaterialTheme.typography.labelLarge)
    }
}


@Composable
fun OpenRideAccentButton(
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
) {
    Button(
        onClick = onClick,
        enabled = enabled,
        shape = MaterialTheme.shapes.large,
        colors = ButtonDefaults.buttonColors(
            containerColor = MaterialTheme.colorScheme.secondary,
            contentColor = MaterialTheme.colorScheme.onSecondary,
        ),
        modifier = modifier
            .fillMaxWidth()
            .heightIn(min = MaterialTheme.dimensions.buttonHeight),
    ) {
        Text(text = text, style = MaterialTheme.typography.labelLarge)
    }
}

@Preview(
    name = "Dark Theme",
    showBackground = true,
    uiMode = Configuration.UI_MODE_NIGHT_YES
)

@Preview(name = "Light Theme", showBackground = true)
@Composable
private fun PrimaryButtonPreviewLight() {
    OpenRideTheme(darkTheme = false) {
        Box(Modifier.padding(MaterialTheme.dimensions.lg)) {
            OpenRidePrimaryButton(
                text = "Confirm ride",
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
private fun AccentButtonPreviewLight() {
    OpenRideTheme {
        Box(Modifier.padding(MaterialTheme.dimensions.lg)) {
            OpenRideAccentButton(
                text = "Confirm ride",
                onClick = {}
            )
        }
    }
}