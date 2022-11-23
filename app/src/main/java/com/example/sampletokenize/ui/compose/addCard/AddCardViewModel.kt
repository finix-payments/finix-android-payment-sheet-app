package com.example.sampletokenize.ui.compose.addCard

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel


class AddCardViewModel : ViewModel() {

    var state by mutableStateOf(AddCardState())

    fun setShowPaymentSheet(showPaymentSheet:Boolean){
        state = state.copy(showPaymentSheet = showPaymentSheet)
    }
}