package com.example.sampletokenize.data.network.model.payments

import android.os.Parcelable
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import kotlinx.parcelize.Parcelize
import java.util.*

/**
 * PaymentCard
 *
 * Represents a payment method available to a customer.
 */

@Parcelize
@JsonClass(generateAdapter = true)
data class PaymentCard(
    @Json(name = "tokenId") val cardId: Long?,
    @Json(name = "billingAddress") val billingAddress: String?,
    @Json(name = "billingCity") val billingCity: String?,
    @Json(name = "billingCountry") val billingCountry: String?,
    @Json(name = "billingStateProvince") val billingStateProvince: String?,
    @Json(name = "billingZip") val billingZip: String?,
    @Json(name = "cardHolderName") val cardHolderName: String?,
    @Json(name = "customerId") val customerId: Long?,
    @Json(name = "expiration") val expiration: Date?,
    @Json(name = "expirationMonth") val expirationMonth: String?,
    @Json(name = "expirationYear") val expirationYear: String?,
    @Json(name = "isGiftCard") val isGiftCard: Boolean = false,
    @Json(name = "lastFourAccountNumbers") val lastFourAccountNumbers: String?,
    @Json(name = "paymentMethod") val paymentMethod: String?,
    @Json(name = "paymentProviderDbId") val paymentProviderDbId: Int?,
    @Json(name = "paymentProviderId") val paymentProviderId: String?,
    @Json(name = "paymentTypeId") val paymentTypeId: Int?,
    @Json(name = "tokenizedAccountNumber") val tokenizedAccountNumber: String?
) : Parcelable