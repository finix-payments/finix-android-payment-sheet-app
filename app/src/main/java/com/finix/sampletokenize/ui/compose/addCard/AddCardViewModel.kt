package com.finix.sampletokenize.ui.compose.addCard

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.ViewModel
import com.finix.finixpaymentsheet.domain.model.PaymentSheetColors
import com.finix.finixpaymentsheet.domain.model.PaymentSheetResources
import com.finix.sampletokenize.R
import com.finix.sampletokenize.ui.theme.*



class AddCardViewModel : ViewModel() {

    var state by mutableStateOf(AddCardState())


    fun setTokenResponse(response: String){
        state = state.copy(tokenResponseString = response)
    }

    fun setShowCompletePaymentSheetOutlined(show: Boolean){
        state = state.copy(showCompletePaymentSheetOutlined = show)
    }

    fun setShowPartialPaymentSheetOutlined(show: Boolean){
        state = state.copy(showPartialPaymentSheetOutlined = show)
    }

    fun setShowBasicPaymentSheetOutlined(show: Boolean){
        state = state.copy(showBasicPaymentSheetOutlined = show)
    }

    fun setShowMinimalPaymentSheetOutlined(show: Boolean){
        state = state.copy(showMinimalPaymentSheetOutlined = show)
    }

    fun setShowCompletePaymentSheet(show: Boolean){
        state = state.copy(showCompletePaymentSheet = show)
    }

    fun setShowPartialPaymentSheet(show: Boolean){
        state = state.copy(showPartialPaymentSheet = show)
    }

    fun setShowBasicPaymentSheet(show: Boolean){
        state = state.copy(showBasicPaymentSheet = show)
    }

    fun setShowMinimalPaymentSheet(show: Boolean){
        state = state.copy(showMinimalPaymentSheet = show)
    }

}
