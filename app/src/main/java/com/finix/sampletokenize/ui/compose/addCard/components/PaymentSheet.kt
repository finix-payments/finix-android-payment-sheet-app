package com.finix.sampletokenize.ui.compose.addCard.components

import android.content.Context
import android.widget.Toast
import androidx.compose.runtime.Composable
import com.finix.finixpaymentsheet.ui.viewModel.paymentSheet.*
import com.finix.sampletokenize.ui.compose.addCard.AddCardViewModel


/**
 * These are all the payment sheet variations available
 *
 *  Required: onDismiss, onNegativeClick, onPositiveClick
 *  all else is optional
 *
 *  SEE viewModel.state.paymentSheetColors for color defaults
 *  SEE viewModel.state.paymentSheetResources for resource defaults
 */

@Composable
fun ShowCompletePaymentSheetOutlined(viewModel: AddCardViewModel, context: Context) {

    CompletePaymentSheetOutlined(
        // add any methods that would happen once the sheet is dismissed by a side swipe, or leave empty if you don't want anything to happen
        onDismiss = {
            viewModel.setShowCompletePaymentSheetOutlined(false)
            viewModel.setShowFinixPaymentSheetSelection(show = true)
            Toast.makeText(context, "onDismiss!", Toast.LENGTH_SHORT).show()
        },
        // add any methods that would happen when the user clicks the cancel button, or leave empty if you don't want anything to happen
        onNegativeClick = {
            viewModel.setShowCompletePaymentSheetOutlined(false)
            viewModel.setShowFinixPaymentSheetSelection(show = true)
            Toast.makeText(context, "onNegativeClick", Toast.LENGTH_SHORT).show()

        },
        // add any methods that would happen when the user clicks on the tokenize button and a token response is returned; you should save this token for your own use
        onPositiveClick = { Token ->
            viewModel.setShowCompletePaymentSheetOutlined(false)
            viewModel.setShowFinixPaymentSheetSelection(show = true)
            Toast.makeText(context, "onPositiveClick: Response: $Token", Toast.LENGTH_SHORT).show()
            viewModel.setTokenResponse(Token.toString())

        },
        applicationId = "APjMB6owJ7542dehJ6hCojzR", // change to your own application ID, otherwise sandbox id will be used
        isSandbox = true, // change to false for live
        paymentSheetColors = viewModel.state.paymentSheetColors, // optional
        paymentSheetResources = viewModel.state.paymentSheetResources, // optional
    )

}

@Composable
fun ShowPartialPaymentSheetOutlined(viewModel: AddCardViewModel, context: Context) {
    PartialPaymentSheetOutlined(
        // add any methods that would happen once the sheet is dismissed by a side swipe, or leave empty if you don't want anything to happen
        onDismiss = {
            viewModel.setShowPartialPaymentSheetOutlined(false)
            Toast.makeText(context, "Dialog dismissed!", Toast.LENGTH_SHORT).show()
        },
        // add any methods that would happen when the user clicks the cancel button, or leave empty if you don't want anything to happen
        onNegativeClick = {
            viewModel.setShowPartialPaymentSheetOutlined(false)
            Toast.makeText(context, "Negative Button Clicked!", Toast.LENGTH_SHORT).show()

        },
        // add any methods that would happen when the user clicks on the tokenize button and a token response is returned; you should save this token for your own use
        onPositiveClick = { Token ->
            viewModel.setShowPartialPaymentSheetOutlined(false)
            Toast.makeText(context, "Tokenize Response: $Token", Toast.LENGTH_SHORT).show()
            viewModel.setTokenResponse(Token.toString())

        },
        applicationId = "APjMB6owJ7542dehJ6hCojzR", // change to your own application ID, otherwise sandbox id will be used
        isSandbox = true, // change to false for live
        paymentSheetColors = viewModel.state.paymentSheetColors, // optional
        paymentSheetResources = viewModel.state.paymentSheetResources, // optional
    )

}

@Composable
fun ShowBasicPaymentSheetOutlined(viewModel: AddCardViewModel, context: Context) {
    BasicPaymentSheetOutlined(
        // add any methods that would happen once the sheet is dismissed by a side swipe, or leave empty if you don't want anything to happen
        onDismiss = {
            viewModel.setShowBasicPaymentSheetOutlined(false)
            Toast.makeText(context, "Dialog dismissed!", Toast.LENGTH_SHORT).show()
        },
        // add any methods that would happen when the user clicks the cancel button, or leave empty if you don't want anything to happen
        onNegativeClick = {
            viewModel.setShowBasicPaymentSheetOutlined(false)
            Toast.makeText(context, "Negative Button Clicked!", Toast.LENGTH_SHORT).show()

        },
        // add any methods that would happen when the user clicks on the tokenize button and a token response is returned; you should save this token for your own use
        onPositiveClick = { Token ->
            viewModel.setShowBasicPaymentSheetOutlined(false)
            Toast.makeText(context, "Tokenize Response: $Token", Toast.LENGTH_SHORT).show()
            viewModel.setTokenResponse(Token.toString())

        },

        applicationId = "APjMB6owJ7542dehJ6hCojzR", // change to your own application ID, otherwise sandbox id will be used
        isSandbox = true, // change to false for live
        paymentSheetColors = viewModel.state.paymentSheetColors, // optional
        paymentSheetResources = viewModel.state.paymentSheetResources, // optional
    )

}

@Composable
fun ShowMinimalPaymentSheetOutlined(viewModel: AddCardViewModel, context: Context) {
    MinimalPaymentSheetOutlined(
        // add any methods that would happen once the sheet is dismissed by a side swipe, or leave empty if you don't want anything to happen
        onDismiss = {
            viewModel.setShowMinimalPaymentSheetOutlined(false)
            Toast.makeText(context, "Dialog dismissed!", Toast.LENGTH_SHORT).show()
        },
        // add any methods that would happen when the user clicks the cancel button, or leave empty if you don't want anything to happen
        onNegativeClick = {
            viewModel.setShowMinimalPaymentSheetOutlined(false)
            Toast.makeText(context, "Negative Button Clicked!", Toast.LENGTH_SHORT).show()

        },
        // add any methods that would happen when the user clicks on the tokenize button and a token response is returned; you should save this token for your own use
        onPositiveClick = { Token ->
            viewModel.setShowMinimalPaymentSheetOutlined(false)
            Toast.makeText(context, "Tokenize Response: $Token", Toast.LENGTH_SHORT).show()
            viewModel.setTokenResponse(Token.toString())

        },

        applicationId = "APjMB6owJ7542dehJ6hCojzR", // change to your own application ID, otherwise sandbox id will be used
        isSandbox = true, // change to false for live
        paymentSheetColors = viewModel.state.paymentSheetColors, // optional
        paymentSheetResources = viewModel.state.paymentSheetResources, // optional
    )

}

@Composable
fun ShowCompletePaymentSheet(viewModel: AddCardViewModel, context: Context) {
    CompletePaymentSheet(
        // add any methods that would happen once the sheet is dismissed by a side swipe, or leave empty if you don't want anything to happen
        onDismiss = {
            viewModel.setShowCompletePaymentSheet(false)
            Toast.makeText(context, "Dialog dismissed!", Toast.LENGTH_SHORT).show()
        },
        // add any methods that would happen when the user clicks the cancel button, or leave empty if you don't want anything to happen
        onNegativeClick = {
            viewModel.setShowCompletePaymentSheet(false)
            Toast.makeText(context, "Negative Button Clicked!", Toast.LENGTH_SHORT).show()

        },
        // add any methods that would happen when the user clicks on the tokenize button and a token response is returned; you should save this token for your own use
        onPositiveClick = { Token ->
            viewModel.setShowCompletePaymentSheet(false)
            Toast.makeText(context, "Tokenize Response: $Token", Toast.LENGTH_SHORT).show()
            viewModel.setTokenResponse(Token.toString())

        },

        applicationId = "APjMB6owJ7542dehJ6hCojzR", // change to your own application ID, otherwise sandbox id will be used
        isSandbox = true, // change to false for live
        paymentSheetColors = viewModel.state.paymentSheetColors, // optional
        paymentSheetResources = viewModel.state.paymentSheetResources, // optional
    )

}

@Composable
fun ShowPartialPaymentSheet(viewModel: AddCardViewModel, context: Context) {
    PartialPaymentSheet(
        // add any methods that would happen once the sheet is dismissed by a side swipe, or leave empty if you don't want anything to happen
        onDismiss = {
            viewModel.setShowPartialPaymentSheet(false)
            Toast.makeText(context, "Dialog dismissed!", Toast.LENGTH_SHORT).show()
        },
        // add any methods that would happen when the user clicks the cancel button, or leave empty if you don't want anything to happen
        onNegativeClick = {
            viewModel.setShowPartialPaymentSheet(false)
            Toast.makeText(context, "Negative Button Clicked!", Toast.LENGTH_SHORT).show()

        },
        // add any methods that would happen when the user clicks on the tokenize button and a token response is returned; you should save this token for your own use
        onPositiveClick = { Token ->
            viewModel.setShowPartialPaymentSheet(false)
            Toast.makeText(context, "Tokenize Response: $Token", Toast.LENGTH_SHORT).show()
            viewModel.setTokenResponse(Token.toString())

        },
        applicationId = "APjMB6owJ7542dehJ6hCojzR", // change to your own application ID, otherwise sandbox id will be used
        isSandbox = true, // change to false for live
        paymentSheetColors = viewModel.state.paymentSheetColors, // optional
        paymentSheetResources = viewModel.state.paymentSheetResources, // optional
    )

}

@Composable
fun ShowBasicPaymentSheet(viewModel: AddCardViewModel, context: Context) {
    BasicPaymentSheet(
        // add any methods that would happen once the sheet is dismissed by a side swipe, or leave empty if you don't want anything to happen
        onDismiss = {
            viewModel.setShowBasicPaymentSheet(false)
            Toast.makeText(context, "Dialog dismissed!", Toast.LENGTH_SHORT).show()
        },
        // add any methods that would happen when the user clicks the cancel button, or leave empty if you don't want anything to happen
        onNegativeClick = {
            viewModel.setShowBasicPaymentSheet(false)
            Toast.makeText(context, "Negative Button Clicked!", Toast.LENGTH_SHORT).show()

        },
        // add any methods that would happen when the user clicks on the tokenize button and a token response is returned; you should save this token for your own use
        onPositiveClick = { Token ->
            viewModel.setShowBasicPaymentSheet(false)
            Toast.makeText(context, "Tokenize Response: $Token", Toast.LENGTH_SHORT).show()
            viewModel.setTokenResponse(Token.toString())

        },
        applicationId = "APjMB6owJ7542dehJ6hCojzR", // change to your own application ID, otherwise sandbox id will be used
        isSandbox = true, // change to false for live
        paymentSheetColors = viewModel.state.paymentSheetColors, // optional
        paymentSheetResources = viewModel.state.paymentSheetResources, // optional
    )

}

@Composable
fun ShowMinimalPaymentSheet(viewModel: AddCardViewModel, context: Context) {
    MinimalPaymentSheet(
        // add any methods that would happen once the sheet is dismissed by a side swipe, or leave empty if you don't want anything to happen
        onDismiss = {
            viewModel.setShowMinimalPaymentSheet(false)
            Toast.makeText(context, "Dialog dismissed!", Toast.LENGTH_SHORT).show()
        },
        // add any methods that would happen when the user clicks the cancel button, or leave empty if you don't want anything to happen
        onNegativeClick = {
            viewModel.setShowMinimalPaymentSheet(false)
            Toast.makeText(context, "Negative Button Clicked!", Toast.LENGTH_SHORT).show()

        },
        // add any methods that would happen when the user clicks on the tokenize button and a token response is returned; you should save this token for your own use
        onPositiveClick = { Token ->
            viewModel.setShowMinimalPaymentSheet(false)
            Toast.makeText(context, "Tokenize Response: $Token", Toast.LENGTH_SHORT).show()
            viewModel.setTokenResponse(Token.toString())

        },
        applicationId = "APjMB6owJ7542dehJ6hCojzR", // change to your own application ID, otherwise sandbox id will be used
        isSandbox = true, // change to false for live
        paymentSheetColors = viewModel.state.paymentSheetColors, // optional
        paymentSheetResources = viewModel.state.paymentSheetResources, // optional
    )

}

