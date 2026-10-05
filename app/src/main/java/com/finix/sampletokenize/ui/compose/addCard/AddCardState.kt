package com.finix.sampletokenize.ui.compose.addCard

import com.finix.finixpaymentsheet.PaymentSheetEnvironment
import com.finix.finixpaymentsheet.PaymentSheetResponse

enum class DemoScreen {
    MAIN,
    CONFIGURATION
}

enum class PaymentSheetVariant(val label: String) {
    COMPLETE("Complete Payment Sheet"),
    PARTIAL("Partial Payment Sheet"),
    BASIC("Basic Payment Sheet"),
    MINIMAL("Minimal Payment Sheet"),
    INTERNATIONAL("International Payment Sheet")
}

/**
 * Values entered on the configuration screen. `merchantId`, `apiUsername` and `apiPassword`
 * are required by the library whenever 3DS is enabled (they're used to authenticate the
 * 3DS session network calls). The 3DS redirect scheme itself isn't part of this form -- it's
 * fixed to this app (see [com.finix.sampletokenize.ui.compose.addCard.THREE_DS_REDIRECT_SCHEME]),
 * since it's how the library's in-app 3DS challenge WebView recognizes the challenge finished.
 */
data class PaymentSheetConfigState(
    val applicationId: String = "APjMB6owJ7542dehJ6hCojzR",
    val environment: PaymentSheetEnvironment = PaymentSheetEnvironment.SANDBOX,
    val merchantId: String = "",
    val apiUsername: String = "",
    val apiPassword: String = "",
    val currency: String = "USD",
    val amount: String = "10.00",
    val threeDSEnabled: Boolean = false
) {
    val isAmountValid: Boolean
        get() = amount.toBigDecimalOrNull() != null
}

data class AddCardState(
    val screen: DemoScreen = DemoScreen.MAIN,
    val configForm: PaymentSheetConfigState = PaymentSheetConfigState(),

    val showFinixPaymentSheetSelection: Boolean = false,
    val activeSheet: PaymentSheetVariant? = null,

    val successResponse: PaymentSheetResponse? = null,
    val errorMessage: String? = null
)
