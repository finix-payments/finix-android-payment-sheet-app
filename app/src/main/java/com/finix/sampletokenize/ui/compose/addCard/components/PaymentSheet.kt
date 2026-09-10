package com.finix.sampletokenize.ui.compose.addCard.components

import android.content.Context
import android.widget.Toast
import androidx.compose.runtime.Composable
import com.finix.finixpaymentsheet.PaymentSheetEnvironment
import com.finix.finixpaymentsheet.ui.viewModel.paymentSheet.BasicPaymentSheet
import com.finix.finixpaymentsheet.ui.viewModel.paymentSheet.CompletePaymentSheet
import com.finix.finixpaymentsheet.ui.viewModel.paymentSheet.InternationalPaymentSheet
import com.finix.finixpaymentsheet.ui.viewModel.paymentSheet.MinimalPaymentSheet
import com.finix.finixpaymentsheet.ui.viewModel.paymentSheet.PartialPaymentSheet
import com.finix.sampletokenize.ui.compose.addCard.AddCardViewModel

private const val APPLICATION_ID = "APjMB6owJ7542dehJ6hCojzR"
private const val AMOUNT = 1000L // $10.00 in cents

@Composable
fun ShowCompletePaymentSheet(viewModel: AddCardViewModel, context: Context) {
    CompletePaymentSheet(
        applicationId = APPLICATION_ID,
        environment = PaymentSheetEnvironment.SANDBOX,
        amount = AMOUNT,
        onDismiss = {
            viewModel.setShowCompletePaymentSheet(false)
            viewModel.setShowFinixPaymentSheetSelection(true)
            Toast.makeText(context, "onDismiss!", Toast.LENGTH_SHORT).show()
        },
        onCancel = {
            viewModel.setShowCompletePaymentSheet(false)
            viewModel.setShowFinixPaymentSheetSelection(true)
            Toast.makeText(context, "onCancel", Toast.LENGTH_SHORT).show()
        },
        onTokenized = { token ->
            viewModel.setShowCompletePaymentSheet(false)
            viewModel.setShowFinixPaymentSheetSelection(true)
            viewModel.setTokenResponse(token.toString())
            Toast.makeText(context, "onTokenized: $token", Toast.LENGTH_SHORT).show()
        },
    )
}

@Composable
fun ShowPartialPaymentSheet(viewModel: AddCardViewModel, context: Context) {
    PartialPaymentSheet(
        applicationId = APPLICATION_ID,
        environment = PaymentSheetEnvironment.SANDBOX,
        amount = AMOUNT,
        onDismiss = {
            viewModel.setShowPartialPaymentSheet(false)
            Toast.makeText(context, "onDismiss!", Toast.LENGTH_SHORT).show()
        },
        onCancel = {
            viewModel.setShowPartialPaymentSheet(false)
            Toast.makeText(context, "onCancel", Toast.LENGTH_SHORT).show()
        },
        onTokenized = { token ->
            viewModel.setShowPartialPaymentSheet(false)
            viewModel.setTokenResponse(token.toString())
            Toast.makeText(context, "onTokenized: $token", Toast.LENGTH_SHORT).show()
        },
    )
}

@Composable
fun ShowBasicPaymentSheet(viewModel: AddCardViewModel, context: Context) {
    BasicPaymentSheet(
        applicationId = APPLICATION_ID,
        environment = PaymentSheetEnvironment.SANDBOX,
        amount = AMOUNT,
        onDismiss = {
            viewModel.setShowBasicPaymentSheet(false)
            Toast.makeText(context, "onDismiss!", Toast.LENGTH_SHORT).show()
        },
        onCancel = {
            viewModel.setShowBasicPaymentSheet(false)
            Toast.makeText(context, "onCancel", Toast.LENGTH_SHORT).show()
        },
        onTokenized = { token ->
            viewModel.setShowBasicPaymentSheet(false)
            viewModel.setTokenResponse(token.toString())
            Toast.makeText(context, "onTokenized: $token", Toast.LENGTH_SHORT).show()
        },
    )
}

@Composable
fun ShowMinimalPaymentSheet(viewModel: AddCardViewModel, context: Context) {
    MinimalPaymentSheet(
        applicationId = APPLICATION_ID,
        environment = PaymentSheetEnvironment.SANDBOX,
        amount = AMOUNT,
        onDismiss = {
            viewModel.setShowMinimalPaymentSheet(false)
            Toast.makeText(context, "onDismiss!", Toast.LENGTH_SHORT).show()
        },
        onCancel = {
            viewModel.setShowMinimalPaymentSheet(false)
            Toast.makeText(context, "onCancel", Toast.LENGTH_SHORT).show()
        },
        onTokenized = { token ->
            viewModel.setShowMinimalPaymentSheet(false)
            viewModel.setTokenResponse(token.toString())
            Toast.makeText(context, "onTokenized: $token", Toast.LENGTH_SHORT).show()
        },
    )
}

@Composable
fun ShowInternationalPaymentSheet(viewModel: AddCardViewModel, context: Context) {
    InternationalPaymentSheet(
        applicationId = APPLICATION_ID,
        environment = PaymentSheetEnvironment.SANDBOX,
        amount = AMOUNT,
        onDismiss = {
            viewModel.setShowInternationalPaymentSheet(false)
            Toast.makeText(context, "onDismiss!", Toast.LENGTH_SHORT).show()
        },
        onCancel = {
            viewModel.setShowInternationalPaymentSheet(false)
            Toast.makeText(context, "onCancel", Toast.LENGTH_SHORT).show()
        },
        onTokenized = { token ->
            viewModel.setShowInternationalPaymentSheet(false)
            viewModel.setTokenResponse(token.toString())
            Toast.makeText(context, "onTokenized: $token", Toast.LENGTH_SHORT).show()
        },
    )
}
