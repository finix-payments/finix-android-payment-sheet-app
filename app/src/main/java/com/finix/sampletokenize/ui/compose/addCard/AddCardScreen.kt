package com.finix.sampletokenize.ui.compose.addCard

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.selection.SelectionContainer
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import androidx.lifecycle.viewmodel.compose.viewModel
import com.finix.sampletokenize.R
import com.finix.sampletokenize.ui.compose.addCard.components.PaymentSheetSelectionDialog
import com.finix.sampletokenize.ui.compose.addCard.components.ShowPaymentSheet
import com.finix.sampletokenize.ui.compose.configuration.ConfigurationScreen
import com.finix.sampletokenize.ui.theme.FinixErrorRed
import com.finix.sampletokenize.ui.theme.White

@Composable
fun AddCardScreen(modifier: Modifier = Modifier) {
    val viewModel = viewModel<AddCardViewModel>()
    val state = viewModel.state

    when (state.screen) {
        DemoScreen.MAIN -> MainDemoScreen(viewModel = viewModel, modifier = modifier)
        DemoScreen.CONFIGURATION -> {
            BackHandler(onBack = viewModel::closeConfiguration)
            ConfigurationScreen(
                modifier = modifier,
                state = state.configForm,
                onFormChange = viewModel::updateConfigForm,
                onDone = viewModel::closeConfiguration
            )
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun MainDemoScreen(viewModel: AddCardViewModel, modifier: Modifier = Modifier) {
    val state = viewModel.state

    Scaffold(
        modifier = modifier.fillMaxSize(),
        topBar = {
            TopAppBar(
                title = { Text("Finix Tokenization Demo") },
                actions = {
                    TextButton(onClick = viewModel::openConfiguration) {
                        Text("Configuration")
                    }
                }
            )
        }
    ) { paddingValues ->
        Box(modifier = Modifier.fillMaxSize().padding(paddingValues)) {
            if (state.showFinixPaymentSheetSelection) {
                PaymentSheetSelectionDialog(
                    onSelect = viewModel::showPaymentSheet,
                    onDismiss = { viewModel.setShowFinixPaymentSheetSelection(false) }
                )
            }

            state.activeSheet?.let { variant ->
                ShowPaymentSheet(
                    variant = variant,
                    configuration = viewModel.buildPaymentSheetConfiguration(),
                    amount = viewModel.amountInMinorUnits(),
                    currency = state.configForm.currency,
                    onCancel = viewModel::dismissPaymentSheet,
                    onSuccess = { response ->
                        viewModel.dismissPaymentSheet()
                        viewModel.onPaymentSheetSuccess(response)
                    },
                    onFailure = { error ->
                        viewModel.dismissPaymentSheet()
                        viewModel.onPaymentSheetFailure(error)
                    }
                )
            }

            Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.BottomCenter) {
                Banner()
            }

            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(10.dp),
                modifier = Modifier.fillMaxWidth().padding(top = 48.dp)
            ) {
                RoundedLogo(drawable = R.drawable.ic_logo)
            }

            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(40.dp),
                modifier = Modifier.fillMaxWidth().padding(top = 300.dp)
            ) {
                HorizontalDivider()
                AddCardButton(
                    onClick = { clicked ->
                        viewModel.setShowFinixPaymentSheetSelection(clicked)
                    }
                )
            }
        }
    }

    state.successResponse?.let { response ->
        ResultDialog(onDismiss = viewModel::dismissResultDialog) {
            Text(text = "Success", style = MaterialTheme.typography.titleLarge, fontWeight = FontWeight.Bold)
            LabeledValue(label = "Token ID", value = response.tokenizedResponse.id)
            LabeledValue(
                label = "3DS Session ID",
                value = response.threeDSResponse?.sessionId ?: "Not created (3DS was not triggered)"
            )
        }
    }

    state.errorMessage?.let { message ->
        ResultDialog(onDismiss = viewModel::dismissResultDialog) {
            Text(
                text = "Failed",
                style = MaterialTheme.typography.titleLarge,
                fontWeight = FontWeight.Bold,
                color = FinixErrorRed
            )
            Text(text = message)
        }
    }
}

@Composable
private fun ResultDialog(onDismiss: () -> Unit, content: @Composable () -> Unit) {
    Dialog(
        onDismissRequest = onDismiss,
        properties = DialogProperties(dismissOnBackPress = true, dismissOnClickOutside = false)
    ) {
        Column(
            modifier = Modifier
                .width(320.dp)
                .background(White, shape = RoundedCornerShape(12.dp))
                .padding(20.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            content()
            Button(onClick = onDismiss, modifier = Modifier.fillMaxWidth()) {
                Text("OK")
            }
        }
    }
}

@Composable
private fun LabeledValue(label: String, value: String) {
    Column {
        Text(text = label, style = MaterialTheme.typography.labelMedium)
        SelectionContainer {
            Text(text = value, style = MaterialTheme.typography.bodyMedium)
        }
    }
}
