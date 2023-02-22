package com.finix.sampletokenize.ui.compose.common

import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material.Divider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.finix.sampletokenize.ui.theme.lightGray

@Composable
fun HorizontalDivider() {
    Divider(
        modifier = Modifier
            .height(1.dp)
            .fillMaxWidth(),
        color = lightGray
    )
}

@Composable
fun HorizontalPartialDivider(widthDP:Dp) {
    Divider(
        modifier = Modifier
            .height(1.dp)
            .width(widthDP),
        color = lightGray
    )
}

@Composable
fun VerticalDivider() {
    Divider(
        modifier = Modifier
            .width(1.dp)
            .fillMaxHeight(),
        color = Color.Gray
    )
}
