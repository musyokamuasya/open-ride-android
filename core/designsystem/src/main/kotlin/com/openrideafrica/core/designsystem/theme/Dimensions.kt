package com.openrideafrica.core.designsystem.theme

import androidx.compose.runtime.Immutable
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Immutable
data class Dimensions(
    val none: Dp = 0.dp,
    val xs: Dp = 4.dp,
    val sm: Dp = 8.dp,
    val md: Dp = 12.dp,
    val lg: Dp = 16.dp,
    val xl: Dp = 24.dp,
    val xxl: Dp = 32.dp,
    val xxxl: Dp = 48.dp,

    // Component sizing
    val buttonHeight: Dp = 56.dp,
    val buttonHeightSmall: Dp = 40.dp,
    val iconSm: Dp = 16.dp,
    val iconMd: Dp = 24.dp,
    val iconLg: Dp = 28.dp,
    val tileLarge: Dp = 64.dp,
    val touchTarget: Dp = 48.dp,
)