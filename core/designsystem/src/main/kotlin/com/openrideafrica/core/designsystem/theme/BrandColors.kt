package com.openrideafrica.core.designsystem.theme

import androidx.compose.runtime.Immutable
import androidx.compose.ui.graphics.Color

@Immutable
data class BrandColors(
    val tile: Color,
    val onTile: Color,
    val selectedContainer: Color,
    val selectedOutline: Color,
    val success: Color,
    val onSuccess: Color,
    val successContainer: Color,
    val warning: Color,
    val onWarning: Color,
    val rideActive: Color,
    val rideActiveContainer: Color,
)

internal val LightBrandColors = BrandColors(
    tile = Palette.Yellow500,
    onTile = Palette.Ink900,
    selectedContainer = Palette.YellowTint,
    selectedOutline = Palette.Ink900,
    success = Palette.Green500,
    onSuccess = Palette.White,
    successContainer = Palette.Green100,
    warning = Palette.Amber500,
    onWarning = Palette.Ink900,
    rideActive = Palette.Green500,
    rideActiveContainer = Palette.Green100,
)

internal val DarkBrandColors = LightBrandColors.copy(
    selectedContainer = Palette.Ink700,
    selectedOutline = Palette.Yellow500,
    successContainer = Palette.Ink700,
    rideActiveContainer = Palette.Ink700,
)
