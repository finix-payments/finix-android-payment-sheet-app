package com.example.sampletokenize.data.network.model.payments

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

/**
 * PaymentProviderTokenResponse
 *
 * Response after a client token has been exchanged for a payment.
 */
@JsonClass(generateAdapter = true)
data class PaymentProviderTokenResponse(
    @Json(name = "authCode") val authCode: String?,
    @Json(name = "card") val card: CardInfo?,
    @Json(name = "errorReason") val errorReason: String?,
    @Json(name = "isSuccess") val isSuccess: Boolean,
    @Json(name = "paymentToken") val paymentToken: String?
)
