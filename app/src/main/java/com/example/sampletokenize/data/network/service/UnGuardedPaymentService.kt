package com.example.sampletokenize.data.network.service

import com.example.sampletokenize.data.network.model.payments.NewPaymentCardBody
import com.example.sampletokenize.data.network.model.payments.PaymentCard
import com.example.sampletokenize.data.network.model.payments.PaymentProviderTokenResponse
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path


/**
// TOKEN REQUEST
curl --location --request POST 'https://finix.sandbox-payments-api.com/applications/APgPDQrLD52TYvqazjHJJchM/tokens' \
--header 'Content-Type: application/json' \
--data-raw '{
        "type":"PAYMENT_CARD",
        "number":"4111111111111111",
        "security_code": "111",
        "expiration_month": 10,
        "expiration_year": 2025,
        "name": "Joe Doe",
        "address":{
        "line1": "123 May Street",
        "line2": "#123",
        "city": "Santa Monica",
        "region": "CA",
        "postal_code": "90404",
        "country": "United States"
    }
}'


/**
{
    "id" : "TKcHHcB9e1GrG3rifyfLEtoM",
    "fingerprint" : "FPRrcobjtdU98gr4sjiqYR1Qg",
    "created_at" : "2022-07-03T00:03:24.48Z",
    "updated_at" : "2022-07-03T00:03:24.48Z",
    "instrument_type" : "PAYMENT_CARD",
    "expires_at" : "2022-07-04T00:03:24.48Z",
    "currency" : "USD"
}%
*/
 **/

// hopefully its guarded lol
interface UnGuardedPaymentService {

    @GET("stuff/stuff/stuff")
    suspend fun getWallet(): List<PaymentCard>

    @POST("stuff/stuff/stuff")
    suspend fun addCardToWallet(@Body saveTokenRequest: NewPaymentCardBody)
//
//    @GET("transaction/v3/wallet/provider/{restaurantNumber}")
//    suspend fun getPaymentProvidersForRestaurant(@Path("restaurantNumber") restaurantId: Int): List<PaymentProvider>
//
//    @POST("transaction/v3/wallet/provider/initialize/{providerId}")
//    suspend fun initializePaymentProviderSession(@Path("providerId") providerId: String): InitializeProviderResponse
//
//    @POST("transaction/v3/wallet/provider/initialize/{providerId}")
//    suspend fun initializePaymentProviderSession(
//        @Path("providerId") providerId: String,
//        @Body paymentProviderRequest: InitializePaymentProviderBody
//    ): InitializeProviderResponse
//
    @GET("transaction/v3/wallet/provider/convert/{providerId}/{clientToken}")
    suspend fun getPaymentProviderToken(
        @Path("providerId") providerId: String,
        @Path("clientToken") clientToken: String
    ): PaymentProviderTokenResponse
//
//    @GET("transaction/v3/wallet/provider")
//    suspend fun getDefaultPaymentProvidersForCustomer(): List<PaymentProvider>
//
//    @GET("transaction/v3/payment/giftcard/balance/{cardNumber}")
//    suspend fun getGiftCardBalance(@Path("cardNumber") cardNumber: String): GiftCardBalance
}
/*
package com.chipotle.data.respository

import androidx.room.withTransaction
import com.chipotle.data.database.ChipotleDatabase
import com.chipotle.data.database.entity.PaymentCardEntity
import com.chipotle.data.network.model.payments.InitializePaymentProviderBody
import com.chipotle.data.network.model.payments.NewPaymentCardBody
import com.chipotle.data.network.model.payments.PaymentCard
import com.chipotle.data.network.service.GuardedPaymentService
import com.chipotle.data.network.service.PaymentService
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.flow.map

private const val GATEWAY_PROVIDER_CHASE_FORM_TYPE = 4
private const val GATEWAY_PROVIDER_CHASE_LANGUAGE = "en_US"

/**
 * Payment Repository
 *
 * Access to saved payment methods and payment gateways.
 */
class PaymentRepository(
    private val service: PaymentService,
    private val guardedService: GuardedPaymentService,
    private val database: ChipotleDatabase
) : BaseRepository() {

    suspend fun health() = execute { service.health() }

    suspend fun getWallet() = execute { service.getWallet() }

    suspend fun addCardToWallet(
        accountToken: String,
        cardHolderName: String,
        lastFourAccountNumbers: String,
        paymentMethod: String,
        paymentProviderId: String,
        expiration: String?,
        billingZip: String?,
        recaptchaAccount: String?,
        recaptchaToken: String?
    ) = execute {
        guardedService.addCardToWallet(
            NewPaymentCardBody(
                accountToken,
                cardHolderName,
                lastFourAccountNumbers,
                paymentMethod,
                paymentProviderId,
                expiration,
                billingZip,
                recaptchaAccount,
                recaptchaToken
            )
        )
    }

    suspend fun deleteCard(cardId: Long) = execute { service.deleteCardFromWallet(cardId) }

    suspend fun getGiftCardBalance(cardNumber: String) =
        execute { guardedService.getGiftCardBalance(cardNumber) }

    suspend fun getPaymentProviders(restaurantId: Int) =
        execute { guardedService.getPaymentProvidersForRestaurant(restaurantId) }

    suspend fun initializePaymentProviderSessionPayeezy(providerId: String) =
        execute { guardedService.initializePaymentProviderSession(providerId) }

    suspend fun initializePaymentProviderSessionChase(providerId: String) =
        execute {
            guardedService.initializePaymentProviderSession(
                providerId = providerId,
                paymentProviderRequest = InitializePaymentProviderBody(
                    formType = GATEWAY_PROVIDER_CHASE_FORM_TYPE,
                    lang = GATEWAY_PROVIDER_CHASE_LANGUAGE
                )
            )
        }

    suspend fun initializePaymentProviderSessionChaseUK(
        providerId: String,
        restaurantId: Int? = null,
        amount: Double? = null,
        token: Long? = null,
        shouldAuthorizeAmount: Boolean,
        shouldPersist: Boolean
    ) = execute {
        guardedService.initializePaymentProviderSession(
            providerId = providerId,
            paymentProviderRequest = InitializePaymentProviderBody(
                restaurantId = restaurantId,
                amount = amount,
                token = token,
                shouldAuthorizeAmount = shouldAuthorizeAmount,
                shouldPersist = shouldPersist,
                redirectUrl = "https://payeezystrgdev.z19.web.core.windows.net/CallbackUK.html"
            )
        )
    }

    suspend fun getPaymentProviderToken(providerId: String, clientToken: String) =
        execute { guardedService.getPaymentProviderToken(providerId, clientToken) }

    suspend fun savePaymentCardsToDatabase(paymentCards: List<PaymentCard>) {
        database.withTransaction {
            database.paymentCardDao.deleteAll()
            database.paymentCardDao.insertAll(
                paymentCards
                    .filter { it.cardId != null }
                    .map {
                        PaymentCardEntity(
                            id = it.cardId!!,
                            paymentCard = it
                        )
                    }
            )
        }
    }

    suspend fun deletePaymentCardFromDatabase(cardId: Long) =
        database.paymentCardDao.deletePaymentCard(cardId)

    suspend fun deleteAllPaymentCardsFromDatabase() = database.paymentCardDao.deleteAll()

    fun getSavedPaymentCardsFlow() =
        database.paymentCardDao.getPaymentCardFlow()
            .map { list -> list.filterNotNull().map { entity -> entity.paymentCard } }
            .distinctUntilChanged()

    suspend fun getSavedPaymentCards() =
        database.paymentCardDao.getPaymentCards().mapNotNull {
            it?.paymentCard
        }

    suspend fun getDefaultPaymentProviders() =
        execute { guardedService.getDefaultPaymentProvidersForCustomer() }
}

 */