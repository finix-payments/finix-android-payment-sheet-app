package com.finix.sampletokenize.ui.compose.configuration

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuAnchorType
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import com.finix.finixpaymentsheet.PaymentSheetEnvironment
import com.finix.sampletokenize.ui.compose.addCard.PaymentSheetConfigState
import java.util.Locale

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ConfigurationScreen(
    state: PaymentSheetConfigState,
    onFormChange: ((PaymentSheetConfigState) -> PaymentSheetConfigState) -> Unit,
    onDone: () -> Unit,
    modifier: Modifier = Modifier
) {
    Scaffold(
        modifier = modifier,
        topBar = {
            TopAppBar(
                title = { Text("Configuration") },
                navigationIcon = {

                },
                actions = {
                    TextButton(onClick = onDone, enabled = state.isAmountValid) {
                        Text("Save")
                    }
                }
            )
        }
    ) { paddingValues ->
        ConfigurationForm(
            form = state,
            onFormChange = onFormChange,
            modifier = Modifier.padding(paddingValues)
        )
    }
}

@Composable
private fun ConfigurationForm(
    form: PaymentSheetConfigState,
    onFormChange: ((PaymentSheetConfigState) -> PaymentSheetConfigState) -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(20.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        OutlinedTextField(
            value = form.applicationId,
            onValueChange = { value -> onFormChange { it.copy(applicationId = value) } },
            label = { Text("Application ID") },
            modifier = Modifier.fillMaxWidth(),
            singleLine = true
        )

        EnvironmentDropdown(
            selected = form.environment,
            onSelected = { value -> onFormChange { it.copy(environment = value) } }
        )

        HorizontalDivider()

        OutlinedTextField(
            value = form.amount,
            onValueChange = { value -> onFormChange { it.copy(amount = value) } },
            label = { Text("Amount (e.g. 10.00)") },
            isError = !form.isAmountValid,
            supportingText = {
                if (!form.isAmountValid) {
                    Text("Enter a valid amount")
                }
            },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Decimal),
            modifier = Modifier.fillMaxWidth(),
            singleLine = true
        )

        OutlinedTextField(
            value = form.currency,
            onValueChange = { value -> onFormChange { it.copy(currency = value.uppercase(Locale.ROOT)) } },
            label = { Text("Currency (e.g. USD)") },
            modifier = Modifier.fillMaxWidth(),
            singleLine = true
        )

        HorizontalDivider()

        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(text = "Enable 3DS")
            Switch(
                checked = form.threeDSEnabled,
                onCheckedChange = { value -> onFormChange { it.copy(threeDSEnabled = value) } }
            )
        }

        OutlinedTextField(
            value = form.merchantId,
            onValueChange = { value -> onFormChange { it.copy(merchantId = value) } },
            label = { Text("Merchant ID") },
            modifier = Modifier.fillMaxWidth(),
            singleLine = true
        )

        OutlinedTextField(
            value = form.apiUsername,
            onValueChange = { value -> onFormChange { it.copy(apiUsername = value) } },
            label = { Text("API Username") },
            modifier = Modifier.fillMaxWidth(),
            singleLine = true
        )

        OutlinedTextField(
            value = form.apiPassword,
            onValueChange = { value -> onFormChange { it.copy(apiPassword = value) } },
            label = { Text("API Password") },
            visualTransformation = PasswordVisualTransformation(),
            modifier = Modifier.fillMaxWidth(),
            singleLine = true
        )

    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun EnvironmentDropdown(
    selected: PaymentSheetEnvironment,
    onSelected: (PaymentSheetEnvironment) -> Unit
) {
    var expanded by remember { mutableStateOf(false) }
    ExposedDropdownMenuBox(
        expanded = expanded,
        onExpandedChange = { expanded = it }
    ) {
        OutlinedTextField(
            value = selected.displayName(),
            onValueChange = {},
            readOnly = true,
            label = { Text("Environment") },
            trailingIcon = { ExposedDropdownMenuDefaults.TrailingIcon(expanded = expanded) },
            modifier = Modifier
                .fillMaxWidth()
                .menuAnchor(ExposedDropdownMenuAnchorType.PrimaryNotEditable)
        )
        ExposedDropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false }
        ) {
            PaymentSheetEnvironment.entries.forEach { environment ->
                DropdownMenuItem(
                    text = { Text(environment.displayName()) },
                    onClick = {
                        onSelected(environment)
                        expanded = false
                    }
                )
            }
        }
    }
}

private fun PaymentSheetEnvironment.displayName(): String = when (this) {
    PaymentSheetEnvironment.LIVE -> "Production"
    PaymentSheetEnvironment.SANDBOX -> "Sandbox"
    PaymentSheetEnvironment.QA -> "QA"
}
