package com.openrideafrica.core.designsystem.component.atom

import android.content.res.Configuration
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import com.openrideafrica.core.designsystem.theme.OpenRideTheme
import com.openrideafrica.core.designsystem.theme.dimensions

@Composable
fun RatingStars(
    rating: Int,
    modifier: Modifier = Modifier,
    max: Int = 5,
    starSize: Dp = MaterialTheme.dimensions.iconLg,
    onRatingChange: ((Int) -> Unit)? = null,
) {
    RatingStarsInternal(
        rating = rating,
        modifier = modifier,
        max = max,
        starSize = starSize,
        onRatingChange = onRatingChange,
    )
}

@Composable
private fun RatingStarsInternal(
    rating: Int,
    modifier: Modifier,
    max: Int,
    starSize: Dp,
    onRatingChange: ((Int) -> Unit)?,
) {
    val dimensions = MaterialTheme.dimensions
    val colors = MaterialTheme.colorScheme
    val safeRating = rating.coerceIn(0, max)

    val interactionSource = remember {
        MutableInteractionSource()
    }

    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.spacedBy(dimensions.sm),
    ) {
        repeat(max) { index ->
            val starNumber = index + 1
            val filled = starNumber <= safeRating

            Icon(
                imageVector = Icons.Filled.Star,
                contentDescription = if (onRatingChange != null) {
                    "Rate $starNumber stars"
                } else {
                    null
                },
                tint = if (filled) {
                    colors.onSurface
                } else {
                    colors.outline
                },
                modifier = Modifier
                    .size(starSize)
                    .then(
                        if (onRatingChange != null) {
                            Modifier.clickable(
                                interactionSource = interactionSource,
                                indication = null,
                            ) {
                                onRatingChange(starNumber)
                            }
                        } else Modifier
                    ),
            )
        }
    }
}

@Preview(
    name = "Rating Stars Light",
    showBackground = true,
)
@Preview(
    name = "Rating Stars Dark",
    showBackground = true,
    uiMode = Configuration.UI_MODE_NIGHT_YES,
)
@Composable
private fun RatingStarsPreview() {
    OpenRideTheme {
        RatingStars(
            rating = 3,
        )
    }
}