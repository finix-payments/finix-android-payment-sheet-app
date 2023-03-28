package com.finix.sampletokenize.ui.compose.addCard.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
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
import com.finix.sampletokenize.ui.compose.addCard.AddCardViewModel
import com.finix.sampletokenize.ui.compose.common.HorizontalDivider
import com.finix.sampletokenize.ui.theme.Typography

@OptIn(ExperimentalMaterial3Api::class, ExperimentalComposeUiApi::class)
@Composable
fun PaymentSheetSelectionDialog(viewModel: AddCardViewModel) {
    val textColor = Color.Black
    val paddingTop = 14.dp
    val cardColorbg = CardDefaults.cardColors(Color.White)
    Dialog(
        onDismissRequest = {

        },
        properties = DialogProperties(
            usePlatformDefaultWidth = false
        )
    ) {
        Column(
            modifier = Modifier
                .verticalScroll(rememberScrollState())
                .padding(horizontal = 32.dp)
                .height(400.dp)
                .background(
                    color = Color.Transparent,
                    shape = RoundedCornerShape(18.dp)
                ),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Card(
                colors = cardColorbg,
                onClick = {
                    viewModel.setShowCompletePaymentSheetOutlined(true)
                },
                elevation = CardDefaults.cardElevation(6.dp),
                modifier = Modifier
                    .weight(1f)
                    .fillMaxWidth(),
                shape = RoundedCornerShape(topStart = 10.dp, topEnd = 10.dp),
                content = {
                    Text(
                        text = AnnotatedString("Complete Payment Sheet Outlined"),
                        color = textColor,
                        overflow = TextOverflow.Ellipsis,
                        modifier = Modifier
                            .align(Alignment.CenterHorizontally)
                            .padding(paddingTop)
                    )
                }
            )

            HorizontalDivider()

            Card(
                onClick = {
                    viewModel.setShowPartialPaymentSheetOutlined(true)
                },
                elevation = CardDefaults.cardElevation(6.dp),
                modifier = Modifier
                    .weight(1f)
                    .fillMaxWidth(),
                shape = RoundedCornerShape(0.dp),
                content = {
                    Text(
                        text = AnnotatedString("Partial Payment Sheet Outlined"),
                        color = textColor,
                        style = Typography.bodyLarge,
                        overflow = TextOverflow.Ellipsis,
                        modifier = Modifier
                            .align(Alignment.CenterHorizontally)
                            .padding(paddingTop)
                    )
                }
            )

            HorizontalDivider()

            Card(
                onClick = {
                    viewModel.setShowBasicPaymentSheetOutlined(true)
                },
                elevation = CardDefaults.cardElevation(6.dp),
                modifier = Modifier
                    .weight(1f)
                    .fillMaxWidth(),
                shape = RoundedCornerShape(0.dp),
                content = {
                    Text(
                        text = AnnotatedString("Basic Payment Sheet Outlined"),
                        color = textColor,
                        style = Typography.bodyLarge,
                        modifier = Modifier
                            .align(Alignment.CenterHorizontally)
                            .padding(paddingTop)
                    )
                }
            )

            HorizontalDivider()

            Card(
                onClick = {
                    viewModel.setShowMinimalPaymentSheetOutlined(true)
                },
                elevation = CardDefaults.cardElevation(6.dp),
                modifier = Modifier
                    .weight(1f)
                    .fillMaxWidth(),
                shape = RoundedCornerShape(0.dp),
                content = {
                    Text(
                        text = AnnotatedString("Minimal Payment Sheet Outlined"),
                        color = textColor,
                        style = Typography.bodyLarge,
                        modifier = Modifier
                            .align(Alignment.CenterHorizontally)
                            .padding(paddingTop)
                    )
                }
            )

            HorizontalDivider()

            Card(
                onClick = {
                    viewModel.setShowCompletePaymentSheet(true)
                },
                elevation = CardDefaults.cardElevation(6.dp),
                modifier = Modifier
                    .weight(1f)
                    .fillMaxWidth(),
                shape = RoundedCornerShape(0.dp),
                content = {
                    Text(
                        text = AnnotatedString("Complete Payment Sheet"),
                        color = textColor,
                        style = Typography.bodyLarge,
                        modifier = Modifier
                            .align(Alignment.CenterHorizontally)
                            .padding(paddingTop)
                    )
                }
            )

            HorizontalDivider()

            Card(
                onClick = {
                    viewModel.setShowPartialPaymentSheet(true)
                },
                elevation = CardDefaults.cardElevation(6.dp),
                modifier = Modifier
                    .weight(1f)
                    .fillMaxWidth(),
                shape = RoundedCornerShape(0.dp),
                content = {
                    Text(
                        text = AnnotatedString("Partial Payment Sheet"),
                        color = textColor,
                        style = Typography.bodyLarge,
                        modifier = Modifier
                            .align(Alignment.CenterHorizontally)
                            .padding(paddingTop)
                    )
                }
            )
            HorizontalDivider()

            Card(
                onClick = {
                    viewModel.setShowBasicPaymentSheet(true)
                },
                elevation = CardDefaults.cardElevation(6.dp),
                modifier = Modifier
                    .weight(1f)
                    .fillMaxWidth(),
                shape = RoundedCornerShape(0.dp),
                content = {
                    Text(
                        text = AnnotatedString("Basic Payment Sheet"),
                        color = textColor,
                        style = Typography.bodyLarge,
                        modifier = Modifier
                            .align(Alignment.CenterHorizontally)
                            .padding(paddingTop)
                    )
                }
            )
            HorizontalDivider()

            Card(
                onClick = {
                    viewModel.setShowMinimalPaymentSheet(true)
                },
                elevation = CardDefaults.cardElevation(6.dp),
                modifier = Modifier
                    .weight(1f)
                    .fillMaxWidth(),
                shape = RoundedCornerShape(bottomEnd = 10.dp, bottomStart = 10.dp),
                content = {
                    Text(
                        text = AnnotatedString("Minimal Payment Sheet"),
                        color = textColor,
                        style = Typography.bodyLarge,
                        modifier = Modifier
                            .align(Alignment.CenterHorizontally)
                            .padding(paddingTop)
                    )
                }
            )
        }
    }
}