package com.example.finixpaymentsheet.ui.theme

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.finixpaymentsheet.R


@Composable
private fun TokenizeButton(modifier: Modifier = Modifier) {
    ElevatedButton(
        onClick = { /*TODO*/ },
        colors = ButtonDefaults.buttonColors(FinixBlue),
        modifier = modifier
            .height(66.dp)
            .padding(bottom = 8.dp),
    ) {
        Text(
            text = "Tokenize",
            style = MaterialTheme.typography.titleMedium
        )
    }
}

@Composable
private fun CancelButton(modifier: Modifier = Modifier) {
    ElevatedButton(
        onClick = { /*TODO*/ },
        colors = ButtonDefaults.buttonColors(FinixRed),
        modifier = modifier
            .height(66.dp)
            .padding(bottom = 8.dp),
    ) {
        Text(
            text = "Cancel",
            style = MaterialTheme.typography.titleMedium
        )
    }
}

@Composable
private fun PaymentSheetLogo(
    @DrawableRes drawable: Int,
    @StringRes text: Int,
    modifier: Modifier = Modifier
) {
    Surface(
        shape = MaterialTheme.shapes.small,
        modifier = modifier.padding(8.dp),
        color = Color.White
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .padding(2.dp)
        ) {
            Image(
                painter = painterResource(
                    id = drawable
                ),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier.size(76.dp)
            )
            Text(
                text = stringResource(id = text),
                style = MaterialTheme.typography.headlineSmall,
                modifier = Modifier.padding(horizontal = 16.dp)
            )
        }
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun CreditCardBox(modifier: Modifier = Modifier,
                          maxCharSize: Int,
                          label: String,
                          hint: String = "",
) {
    var text by remember { mutableStateOf("") }

    Column(
        modifier = modifier
            .height(74.dp)
    ) {
        //External label
        Text(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 12.dp),
            text = label,
            textAlign = TextAlign.Start,
            color = Color.Black
        )
        TextField(
            maxLines = 1,
            placeholder = {
                Text(
                    text = hint,
                    color = medGray
                ) },
            value = text,
            modifier = modifier
                .fillMaxSize()
                .height(60.dp)
                .padding(horizontal = 12.dp),
            onValueChange = {
                if (it.length <= maxCharSize) text = it
            },
            shape = RoundedCornerShape(20.dp),
            trailingIcon = {
                Icon(Icons.Filled.Star, "", tint = Blue)
            },
            colors = TextFieldDefaults.textFieldColors(
                containerColor = midLightGray,
                focusedIndicatorColor = Color.Transparent, //hide the indicator
                unfocusedIndicatorColor = Color.Transparent
            ),
        )
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun CustomTextBox(modifier: Modifier = Modifier,
                          maxCharSize: Int,
                          label: String,
                          placeHolder: String = "",
) {
    var text by remember { mutableStateOf("") }

    Column(
        modifier = modifier
            .height(74.dp)
    ) {
        //External label
        Text(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 12.dp),
            text = label,
            textAlign = TextAlign.Start,
            color = Color.Black
        )
        TextField(
            singleLine = true,
            placeholder = {
                Text(
                text = placeHolder,
                color = medGray
            ) },
            value = text,
            modifier = modifier
                .fillMaxSize()
                .padding(horizontal = 12.dp),
            onValueChange = {
                if (it.length <= maxCharSize) text = it
            },
            shape = RoundedCornerShape(20.dp),
            colors = TextFieldDefaults.textFieldColors(
                containerColor = midLightGray,
                focusedIndicatorColor = Color.Transparent, //hide the indicator
                unfocusedIndicatorColor = Color.Transparent
            ),
        )
    }
}

@Composable
private fun PaymentSheet(
    modifier: Modifier = Modifier,
    @DrawableRes logo: Int = R.drawable.ic_default_logo,
    @StringRes logoText: Int = R.string.default_logo_text,
) {
    Surface(
        modifier = Modifier.padding(8.dp),
        color = Color.White
    ) {
        Column(
            modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState()),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            PaymentSheetLogo(drawable = logo, text = logoText)

//            CustomTextBox(
//                modifier = Modifier, maxCharSize = 30,
//                label = "Name", placeHolder = "First Last"
//            )
            CustomTextField(label = "Name", placeHolder = "First Last")

            CardNumberField()

            Row(
                modifier = Modifier.fillMaxWidth()
            ) {
                CustomTextField(
                    modifier = Modifier.weight(1f),
                    keyboardType = KeyboardType.Number,
                    label = "Expiry",
                    placeHolder = "MM/YYYY",
                    maxCharSize = 7,
                )
                CustomTextField(
                    modifier = Modifier.weight(1f),
                    keyboardType = KeyboardType.Number,
                    label = "CVV/CVC",
                    placeHolder = "111",
                    maxCharSize = 4,
                )
            }

            CustomTextField(label = "Address", placeHolder = "123 Main Street"
            )
            Row(
                modifier = Modifier.fillMaxWidth()
            ) {
                CustomTextField(
                    modifier = Modifier.weight(.6f),
                    maxCharSize = 30,
                    label = "Address 2",
                    placeHolder = "Apt 123"
                )
                CustomTextField(
                    modifier = Modifier.weight(.4f),
                    maxCharSize = 2,
                    label = "State",
                    placeHolder = "CA"
                )
            }
            Row(
                modifier = Modifier.fillMaxWidth()
            ) {
                CustomTextField(
                    modifier = Modifier.weight(.6f),
                    maxCharSize = 50,
                    label = "City",
                    placeHolder = "City"
                )
                CustomTextField(
                    modifier = Modifier.weight(.4f),
                    keyboardType = KeyboardType.Number,
                    label = "Zip Code",
                    placeHolder = "00000",
                    maxCharSize = 5,
                )
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .paddingFromBaseline(56.dp)
                    .padding(horizontal = 12.dp),
                horizontalArrangement = Arrangement.spacedBy(30.dp)
            ) {
                CancelButton(modifier = Modifier.weight(.4f))
                TokenizeButton(modifier = Modifier.weight(.8f))
            }
        }
    }
}


@Composable
fun PaymentSheetScreen() {
    Surface(
        color = Color.White,
        contentColor = Color.White,
        modifier = Modifier.fillMaxSize()
    ) {
        PaymentSheet()
    }
}

@Preview
@Composable
private fun TokenizeButtonPreview() {
    Surface() {
        TokenizeButton()
    }
}

@Preview
@Composable
private fun CancelButtonPreview() {
    Surface() {
        CancelButton()
    }
}

@Preview(showBackground = true, backgroundColor = 0xFFFFFFFF)
@Composable
private fun PaymentSheetPreview(){
    FinixTheme() {
        Surface(
            Modifier.fillMaxSize()
        ) {
            PaymentSheet()
        }
    }

}

@Preview
@Composable
private fun CustomTextBoxPreview() {
    Surface() {
        CustomTextBox(maxCharSize = 99, label = "Nand")
    }

}

@Preview
@Composable
private fun CreditCardBoxPreview() {
    Surface() {
        CreditCardBox(maxCharSize = 99, label = "Credit Card")
    }

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CustomTextField(
    modifier: Modifier = Modifier,
    keyboardType: KeyboardType = KeyboardType.Text,
    label: String,
    errLabel: String = "err",//TODO
    placeHolder: String = "",
    errorMessage: String = "err", //TODO or remove
    maxCharSize: Int = 99,

) {

    var inputText by rememberSaveable { mutableStateOf("") }
    var text by rememberSaveable { mutableStateOf("") }
    var isError by rememberSaveable { mutableStateOf(false) }
    val charLimit = 19

    fun validate(text: String) {
        isError = false
        //make ext function for string and err validations?
    }

    Surface(
        modifier = modifier
            .padding(horizontal = 12.dp)
            .fillMaxWidth()
    ) {
        TextField(
            value = inputText,
            onValueChange = { newText ->
                inputText = newText.trimStart { it == '0' }
                if (newText.length <= maxCharSize) text = newText

            },
            label = { Text(if (isError) errLabel else label) },
            placeholder = { Text(placeHolder) },
            supportingText = {
                if (isError) {
                    Text(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(16.dp),
                        text = "Limit: ${text.length}/$charLimit",
                        textAlign = TextAlign.Start,
                    )
                }
            },
            isError = isError,
            keyboardActions = KeyboardActions {
                validate(text)
            },
            keyboardOptions = KeyboardOptions(keyboardType = keyboardType),
            singleLine = true,
            shape = RoundedCornerShape(20.dp),
            colors = TextFieldDefaults.textFieldColors(
                containerColor = midLightGray,
                focusedIndicatorColor = Color.Transparent, //hide the indicator
                unfocusedIndicatorColor = Color.Transparent,
                focusedLabelColor = FinixBlue,
            ),
            modifier = Modifier.semantics {
                // Provide localized description of the error
                if (isError) error(errorMessage)
            }
                .height(60.dp),
        )
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CardNumberField(errorMessage: String = "err") {

    var inputText by rememberSaveable { mutableStateOf("") }
    var text by rememberSaveable { mutableStateOf("") }
    var isError by rememberSaveable { mutableStateOf(false) }
    val charLimit = 19

    fun validate(text: String) {
        isError = false
        //make ext function for string and err validations?
    }

    Surface(
        Modifier
            .padding(horizontal = 12.dp)
            .fillMaxWidth()
    ) {
        TextField(
            value = inputText,
            onValueChange = { newText ->
                inputText = newText.trimStart { it == '0' }
            },
            label = { Text(if (isError) "Card Number*" else "Card Number") },
            placeholder = { Text("0000 0000 0000 0000") },
            supportingText = {
                if (isError) {
                    Text(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(16.dp),
                        text = "Limit: ${text.length}/$charLimit",
                        textAlign = TextAlign.Start,
                    )
                }
            },
            isError = isError,
            keyboardActions = KeyboardActions {
                validate(text)
            },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            singleLine = true,
            shape = RoundedCornerShape(20.dp),
            trailingIcon = { Icon(Icons.Filled.ShoppingCart, "", tint = Blue) },
            colors = TextFieldDefaults.textFieldColors(
                containerColor = midLightGray,
                focusedIndicatorColor = Color.Transparent, //hide the indicator
                unfocusedIndicatorColor = Color.Transparent,
                focusedLabelColor = FinixBlue,
            ),
            modifier = Modifier.semantics {
                // Provide localized description of the error
                if (isError) error(errorMessage)
            }
                .height(60.dp),
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NoLeadingZeroes() {
    var input by rememberSaveable { mutableStateOf("") }
    TextField(
        value = input,
        onValueChange = { newText ->
            input = newText.trimStart { it == '0' }
        }
    )
}

@Preview
@Composable
private fun M3Preview() {
    Surface(Modifier.fillMaxSize()) {
        Column() {
            CardNumberField("Card")
            CardNumberField("Card")
        }
    }

}
@Preview
@Composable
private fun M4Preview() {
    Surface(Modifier.fillMaxSize()) {
        Column() {
            NoLeadingZeroes()
        }
    }
}

