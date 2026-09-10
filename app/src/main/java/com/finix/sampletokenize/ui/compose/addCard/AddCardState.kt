package com.finix.sampletokenize.ui.compose.addCard

import com.finix.finixpaymentsheet.domain.model.tokenize.TokenizedResponse

data class AddCardState(

    val tokenResponseString: String = "",
    val tokenResponse: TokenizedResponse? = null,

    val showFinixPaymentSheetSelection: Boolean = false,

    val showCompletePaymentSheet: Boolean = false,
    val showPartialPaymentSheet: Boolean = false,
    val showBasicPaymentSheet: Boolean = false,
    val showMinimalPaymentSheet: Boolean = false,
    val showInternationalPaymentSheet: Boolean = false,
)
