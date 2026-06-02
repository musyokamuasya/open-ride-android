package com.openrideafrica.core.designsystem.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.runtime.staticCompositionLocalOf

/**
 * Extra token systems i.e. [Dimensions] and [BrandColors] Material 3 has no slot for.
 * We back them with staticCompositionLocalOf because the design system is set once at the root and
 * never mutates during composition — reads aren't individually tracked, which is
 * the performance win the official CompositionLocal guidance calls out.
 *
 * Both have real defaults so @Preview and tests can render without the full theme.
 */
internal val LocalDimensions = staticCompositionLocalOf { Dimensions() }
internal val LocalBrandColors = staticCompositionLocalOf { LightBrandColors }

/**
 * The app theme. Extends MaterialTheme rather than replacing it, so all stock
 * Material components keep working and read our color/type/shape automatically.
 */
@Composable
fun OpenRideTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit,
) {
    val colorScheme = if (darkTheme) DarkColors else LightColors
    val brandColors = if (darkTheme) DarkBrandColors else LightBrandColors

    CompositionLocalProvider(
        LocalDimensions provides Dimensions(),
        LocalBrandColors provides brandColors,
    ) {
        MaterialTheme(
            colorScheme = colorScheme,
            typography = AppTypography,
            shapes = AppShapes,
            content = content,
        )
    }
}

/**
 * Accessors that extend the MaterialTheme object. This gives one consistent
 * access pattern: MaterialTheme.colorScheme.primary for anything M3 covers, and
 * MaterialTheme.dimensions.lg / MaterialTheme.brandColors.rideActive for ours.
 *
 * @ReadOnlyComposable: these getters only read composition state and never emit
 * UI, mirroring how MaterialTheme's own accessors are defined.
 */
val MaterialTheme.dimensions: Dimensions
    @Composable @ReadOnlyComposable get() = LocalDimensions.current

val MaterialTheme.brandColors: BrandColors
    @Composable @ReadOnlyComposable get() = LocalBrandColors.current