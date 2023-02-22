package com.finix.sampletokenize.ui.compose.addCard

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.finix.sampletokenize.R
import com.finix.sampletokenize.ui.theme.addCardColor

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddCardButton(
    modifier: Modifier = Modifier,
    onClick: (Boolean) -> Unit
) {
    Card(
        onClick = {
            onClick(true)
        },
        elevation = CardDefaults.cardElevation(6.dp),
        modifier = modifier
            .width(296.dp)
            .height(170.dp),
        shape = RoundedCornerShape(20.dp),
        border = BorderStroke(1.dp, Color.LightGray),
    ) {
        Image(
            painter = painterResource(id = R.drawable.ic_add),
            contentDescription = null,
            modifier = modifier
                .background(addCardColor)
                .padding(vertical = 74.dp)
                .fillMaxWidth()
                .height(25.dp)
        )
    }

}
