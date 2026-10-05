package com.finix.sampletokenize.ui.compose.addCard.components

import androidx.compose.runtime.Composable
import com.finix.finixpaymentsheet.FinixErrorCode
import com.finix.finixpaymentsheet.PaymentSheetConfiguration
import com.finix.finixpaymentsheet.PaymentSheetResponse
import com.finix.finixpaymentsheet.ui.viewModel.paymentSheet.BasicPaymentSheet
import com.finix.finixpaymentsheet.ui.viewModel.paymentSheet.CompletePaymentSheet
import com.finix.finixpaymentsheet.ui.viewModel.paymentSheet.InternationalPaymentSheet
import com.finix.finixpaymentsheet.ui.viewModel.paymentSheet.MinimalPaymentSheet
import com.finix.finixpaymentsheet.ui.viewModel.paymentSheet.PartialPaymentSheet
import com.finix.sampletokenize.ui.compose.addCard.PaymentSheetVariant

/**
 * These are all the payment sheet variations available.
 *
 *  COMPLETE: Name, Card, Expiry, CVV, Address && address Ext, City, State, Zip
 *  PARTIAL: Name, Card, Expiry, CVV, Zip
 *  BASIC: Name, Card, Expiry, CVV
 *  MINIMAL: Card, Expiry, CVV
 *  INTERNATIONAL: Complete fields plus a country selector
 */
@Composable
fun ShowPaymentSheet(
    variant: PaymentSheetVariant,
    configuration: PaymentSheetConfiguration,
    amount: Long,
    currency: String,
    onCancel: () -> Unit,
    onSuccess: (PaymentSheetResponse) -> Unit,
    onFailure: (FinixErrorCode) -> Unit
) {
    when (variant) {
        PaymentSheetVariant.COMPLETE -> CompletePaymentSheet(
            configuration = configuration,
            amount = amount,
            currency = currency,
            onCancel = onCancel,
            onSuccess = onSuccess,
            onFailure = onFailure
        )

        PaymentSheetVariant.PARTIAL -> PartialPaymentSheet(
            configuration = configuration,
            amount = amount,
            currency = currency,
            onCancel = onCancel,
            onSuccess = onSuccess,
            onFailure = onFailure
        )

        PaymentSheetVariant.BASIC -> BasicPaymentSheet(
            configuration = configuration,
            amount = amount,
            currency = currency,
            onCancel = onCancel,
            onSuccess = onSuccess,
            onFailure = onFailure
        )

        PaymentSheetVariant.MINIMAL -> MinimalPaymentSheet(
            configuration = configuration,
            amount = amount,
            currency = currency,
            onCancel = onCancel,
            onSuccess = onSuccess,
            onFailure = onFailure
        )

        PaymentSheetVariant.INTERNATIONAL -> InternationalPaymentSheet(
            configuration = configuration,
            amount = amount,
            currency = currency,
            onCancel = onCancel,
            onSuccess = onSuccess,
            onFailure = onFailure
        )
    }
}
