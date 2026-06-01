package com.openrideafrica.core.designsystem.theme

import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme

internal val LightColors = lightColorScheme(
    primary = Palette.Ink900,
    onPrimary = Palette.White,
    primaryContainer = Palette.Ink800,
    onPrimaryContainer = Palette.White,

    secondary = Palette.Yellow500,
    onSecondary = Palette.Ink900,
    secondaryContainer = Palette.Yellow400,
    onSecondaryContainer = Palette.Ink900,

    tertiary = Palette.Yellow600,
    onTertiary = Palette.Ink900,

    background = Palette.White,
    onBackground = Palette.Ink900,
    surface = Palette.White,
    onSurface = Palette.Ink900,
    surfaceVariant = Palette.Grey100,
    onSurfaceVariant = Palette.Grey600,

    outline = Palette.Grey200,
    outlineVariant = Palette.Grey100,

    error = Palette.Red500,
    onError = Palette.White,
)

internal val DarkColors = darkColorScheme(
    primary = Palette.Yellow500,
    onPrimary = Palette.Ink900,
    primaryContainer = Palette.Yellow600,
    onPrimaryContainer = Palette.Ink900,

    secondary = Palette.Yellow500,
    onSecondary = Palette.Ink900,
    secondaryContainer = Palette.Ink700,
    onSecondaryContainer = Palette.Yellow400,

    tertiary = Palette.Yellow400,
    onTertiary = Palette.Ink900,

    background = Palette.Ink900,
    onBackground = Palette.White,
    surface = Palette.Ink800,
    onSurface = Palette.White,
    surfaceVariant = Palette.Ink700,
    onSurfaceVariant = Palette.Grey400,

    outline = Palette.Ink700,
    outlineVariant = Palette.Ink800,

    error = Palette.Red500,
    onError = Palette.White,
)