package com.finix.sampletokenize.ui.compose.addCard

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class AddCardViewModel : ViewModel() {

    var state by mutableStateOf(AddCardState())

    fun setTokenResponse(response: String) {
        state = state.copy(tokenResponseString = response)
    }

    fun setShowFinixPaymentSheetSelection(show: Boolean) {
        state = state.copy(showFinixPaymentSheetSelection = show)
    }

    fun setShowCompletePaymentSheet(show: Boolean) {
        state = state.copy(showCompletePaymentSheet = show)
    }

    fun setShowPartialPaymentSheet(show: Boolean) {
        state = state.copy(showPartialPaymentSheet = show)
    }

    fun setShowBasicPaymentSheet(show: Boolean) {
        state = state.copy(showBasicPaymentSheet = show)
    }

    fun setShowMinimalPaymentSheet(show: Boolean) {
        state = state.copy(showMinimalPaymentSheet = show)
    }

    fun setShowInternationalPaymentSheet(show: Boolean) {
        state = state.copy(showInternationalPaymentSheet = show)
    }
}
