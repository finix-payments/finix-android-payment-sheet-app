package com.example.sampletokenize.data.network.model.payments

import android.os.Parcelable
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import kotlinx.parcelize.Parcelize

/**
 * CardInfo
 *
 * Represents a card info coming back from payeezy or chase
 */
@Parcelize
@JsonClass(generateAdapter = true)
data class CardInfo(
    @Json(name = "bin") val bin: String?,
    @Json(name = "brand") val brand: String?,
    @Json(name = "exp") val expiration: CardExpiration?,
    @Json(name = "last4") val last4: String?,
    @Json(name = "name") val name: String?,
    @Json(name = "billingZip") val billingZip: String?,
    @Json(name = "token") val token: String?,
    @Json(name = "masked") val masked: String?
) : Parcelable