package com.finix.sampletokenize.ui.compose.addCard.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import com.finix.sampletokenize.ui.compose.addCard.PaymentSheetVariant
import com.finix.sampletokenize.ui.compose.common.HorizontalDivider
import com.finix.sampletokenize.ui.theme.Typography

@OptIn(ExperimentalMaterial3Api::class, ExperimentalComposeUiApi::class)
@Composable
fun PaymentSheetSelectionDialog(onSelect: (PaymentSheetVariant) -> Unit, onDismiss: () -> Unit) {
    val textColor = Color.Black
    val paddingTop = 14.dp
    val cardColorbg = CardDefaults.cardColors(Color.White)
    val variants = PaymentSheetVariant.entries

    Dialog(
        onDismissRequest = onDismiss,
        properties = DialogProperties(
            usePlatformDefaultWidth = false
        )
    ) {
        Column(
            modifier = Modifier
                .padding(horizontal = 32.dp)
                .heightIn(max = 400.dp)
                .verticalScroll(rememberScrollState())
                .background(
                    color = Color.Transparent,
                    shape = RoundedCornerShape(18.dp)
                ),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            variants.forEachIndexed { index, variant ->
                if (index > 0) {
                    HorizontalDivider()
                }
                val shape = when (index) {
                    0 -> RoundedCornerShape(topStart = 10.dp, topEnd = 10.dp)
                    variants.lastIndex -> RoundedCornerShape(bottomEnd = 10.dp, bottomStart = 10.dp)
                    else -> RoundedCornerShape(0.dp)
                }
                Card(
                    colors = cardColorbg,
                    onClick = { onSelect(variant) },
                    elevation = CardDefaults.cardElevation(6.dp),
                    modifier = Modifier.fillMaxWidth(),
                    shape = shape,
                    content = {
                        Text(
                            text = AnnotatedString(variant.label),
                            color = textColor,
                            style = Typography.bodyLarge,
                            overflow = TextOverflow.Ellipsis,
                            modifier = Modifier
                                .align(Alignment.CenterHorizontally)
                                .padding(paddingTop)
                        )
                    }
                )
            }
        }
    }
}
