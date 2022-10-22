package com.example.sampletokenize.data.network.model.payments

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class CardToken(
    val providerId: String,
    val paymentToken: String,
    val card: CardInfo
) : Parcelable
