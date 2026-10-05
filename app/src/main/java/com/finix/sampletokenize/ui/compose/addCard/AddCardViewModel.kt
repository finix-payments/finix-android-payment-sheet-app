package com.finix.sampletokenize.ui.compose.addCard

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.finix.finixpaymentsheet.FinixErrorCode
import com.finix.finixpaymentsheet.PaymentSheetConfiguration
import com.finix.finixpaymentsheet.PaymentSheetResponse
import com.finix.finixpaymentsheet.ThreeDSConfiguration
import java.math.RoundingMode

/**
 * The scheme the 3DS challenge redirects back to once the cardholder completes authentication.
 * This is handled entirely in-app: the library's 3DS challenge WebView watches for navigation
 * to this scheme and, on a match, closes itself and resumes the payment flow -- it's never
 * actually launched by the OS, so it's fixed to this app rather than user-configurable.
 */
const val THREE_DS_REDIRECT_SCHEME = "sampletokenize"

class AddCardViewModel : ViewModel() {

    var state by mutableStateOf(AddCardState())
        private set

    fun updateConfigForm(update: (PaymentSheetConfigState) -> PaymentSheetConfigState) {
        state = state.copy(configForm = update(state.configForm))
    }

    fun openConfiguration() {
        state = state.copy(screen = DemoScreen.CONFIGURATION)
    }

    fun closeConfiguration() {
        state = state.copy(screen = DemoScreen.MAIN)
    }

    fun setShowFinixPaymentSheetSelection(show: Boolean) {
        state = state.copy(showFinixPaymentSheetSelection = show)
    }

    fun showPaymentSheet(variant: PaymentSheetVariant) {
        state = state.copy(showFinixPaymentSheetSelection = false, activeSheet = variant)
    }

    fun dismissPaymentSheet() {
        state = state.copy(activeSheet = null)
    }

    fun onPaymentSheetSuccess(response: PaymentSheetResponse) {
        state = state.copy(successResponse = response)
    }

    fun onPaymentSheetFailure(error: FinixErrorCode) {
        state = state.copy(errorMessage = error.message)
    }

    fun dismissResultDialog() {
        state = state.copy(successResponse = null, errorMessage = null)
    }

    fun buildPaymentSheetConfiguration(): PaymentSheetConfiguration {
        val form = state.configForm
        return PaymentSheetConfiguration(
            applicationId = form.applicationId,
            environment = form.environment,
            merchantId = form.merchantId.ifBlank { null },
            apiUsername = form.apiUsername.ifBlank { null },
            apiPassword = form.apiPassword.ifBlank { null },
            threeDSConfiguration = if (form.threeDSEnabled) {
                ThreeDSConfiguration(isEnabled = true, redirectScheme = THREE_DS_REDIRECT_SCHEME)
            } else {
                null
            }
        )
    }

    /** The library's PaymentSheet APIs take `amount` as an integer minor-unit (cent) value. */
    fun amountInMinorUnits(): Long {
        return state.configForm.amount.toBigDecimalOrNull()
            ?.movePointRight(2)
            ?.setScale(0, RoundingMode.HALF_UP)
            ?.toLong() ?: 0L
    }
}
