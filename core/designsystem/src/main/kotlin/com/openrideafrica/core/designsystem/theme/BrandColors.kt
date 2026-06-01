package com.openrideafrica.core.designsystem.theme

import androidx.compose.runtime.Immutable
import androidx.compose.ui.graphics.Color

@Immutable
data class BrandColors(
    val brand: Color,
    val onBrand: Color,
    val success: Color,
    val onSuccess: Color,
    val successContainer: Color,
    val warning: Color,
    val onWarning: Color,
    val rideActive: Color,
    val rideActiveContainer: Color,
)

internal val LightBrandColors = BrandColors(
    brand = Palette.Yellow500,
    onBrand = Palette.Ink900,
    success = Palette.Green500,
    onSuccess = Palette.White,
    successContainer = Palette.Green100,
    warning = Palette.Amber500,
    onWarning = Palette.Ink900,
    rideActive = Palette.Green500,
    rideActiveContainer = Palette.Green100,
)

internal val DarkBrandColors = LightBrandColors.copy(
    onBrand = Palette.Ink900,
    successContainer = Palette.Ink700,
    rideActiveContainer = Palette.Ink700,
)