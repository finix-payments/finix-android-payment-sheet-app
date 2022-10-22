package com.example.sampletokenize.data.network.model.payments

import android.os.Parcelable
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import kotlinx.parcelize.Parcelize

/**
 * CardExpiration
 *
 * Represents a cards expiration month and year
 */
@JsonClass(generateAdapter = true)
@Parcelize
data class CardExpiration(
    @Json(name = "month") val month: String,
    @Json(name = "year") val year: String
) : Parcelable
