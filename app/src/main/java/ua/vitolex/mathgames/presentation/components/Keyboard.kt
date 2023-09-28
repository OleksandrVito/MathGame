package ua.vitolex.mathgames.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ua.vitolex.mathgames.R
import ua.vitolex.mathgames.util.scaledSp

@Composable
fun KeyboardButton(
    modifier: Modifier = Modifier,
    key: String,
    onClick: (String) -> Unit,
) {
    Button(
        modifier = modifier.then(
            Modifier
                .size(75.dp)
                .clip(CircleShape)
                .background(
                    brush = LightGrayGradient
                )
        ),
        border = LightGrayBorder,
        onClick = {
            onClick(key)
        },
        colors = ButtonDefaults.buttonColors(
            containerColor = Color.Transparent,
            contentColor = Color.Black,
        ),
        contentPadding = PaddingValues(0.dp)
    ) {
        if (key != "<=") {
            Text(text = key, fontSize = 24.scaledSp(), style = MaterialTheme.typography.displayMedium)
        } else {
            Icon(imageVector = ImageVector.vectorResource(R.drawable.outline_backspace_24), contentDescription = "clear")
        }
    }
}