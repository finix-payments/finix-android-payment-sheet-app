package com.example.sampletokenize.data.network.model.payments

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

/**
 * New Payment Card Body
 *
 * Note that "billing*" fields defined by the APIs are not used at this time.
 */
@JsonClass(generateAdapter = true)
data class NewPaymentCardBody(
    @Json(name = "tokenizedAccountNumber") val accountToken: String,
    @Json(name = "cardHolderName") val cardHolderName: String?,
    @Json(name = "lastFourAccountNumbers") val lastFourAccountNumbers: String,
    @Json(name = "paymentMethod") val paymentMethod: String,
    @Json(name = "paymentProviderId") val paymentProviderId: String,

    /**
     * Null for Gift Cards
     */
    @Json(name = "expiration") val expiration: String?,
    @Json(name = "billingZip") val billingZip: String?,

    /**
     * Null for Non-Gift Card Payments
     */
    @Json(name = "recaptchaAccount") val recaptchaAccount: String?,

    /**
     * Null for Non-Gift Card Payments
     */
    @Json(name = "recaptchaToken") val recaptchaToken: String?
)