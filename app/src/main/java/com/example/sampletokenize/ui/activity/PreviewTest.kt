package com.example.sampletokenize.ui.activity

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.*
import androidx.compose.runtime.*

import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.paymentsheet.PaymentSheetScreen
import com.example.sampletokenize.ui.theme.Blue
import com.example.sampletokenize.ui.theme.addCardColor
import com.example.sampletokenize.ui.theme.medGray
import com.example.sampletokenize.R


@Composable
fun PaymentSheetLogo(
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
            androidx.compose.material.Text(
                text = stringResource(id = text),
                style = MaterialTheme.typography.h6,
                modifier = Modifier.padding(horizontal = 16.dp)
            )
        }
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CustomTextBox(modifier: Modifier = Modifier,
                  maxCharSize: Int,
                  label: String,
                  requiredField : Boolean = false,
                  hint: String = "",
) {
    var text by remember { mutableStateOf("") }

    Column(
        modifier = modifier
            .height(70.dp)
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
            placeholder = { Text(
                text = hint,
                color = medGray
            ) },
            value = text,
            modifier = modifier
                .height(50.dp)
                .fillMaxWidth()
                .padding(horizontal = 12.dp),
            onValueChange = {
                if (it.length <= maxCharSize) text = it
            },
            shape = RoundedCornerShape(20.dp),
            trailingIcon = {
                if(requiredField) Icon(Icons.Filled.Star, "", tint = Blue)
            },
            colors = TextFieldDefaults.textFieldColors(
                containerColor = addCardColor,
                focusedIndicatorColor = Color.Transparent, //hide the indicator
                unfocusedIndicatorColor = Color.Transparent
            ),

        )
    }
}

@Composable
fun TokenizeButton() {
    Button(onClick = { /*TODO*/ }) {
        Text(text = "Tokenize")
    }
}

@Composable
fun Sheet(
    modifier: Modifier = Modifier,
    @DrawableRes logo: Int = R.drawable.ic_logo,
    @StringRes logoText: Int = R.string.daphneys_corner,
) {
    Surface(
        shape = MaterialTheme.shapes.small,
        modifier = Modifier.padding(8.dp),
        color = Color.White
    ) {
        Column(
            Modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            PaymentSheetLogo(drawable = logo, text = logoText)

            CustomTextBox(
                modifier = Modifier, maxCharSize = 30,
                label = "Name", hint = "First Last"
            )

            CustomTextBox(
                modifier = Modifier,
                maxCharSize = 30, label = "Card Number",
                requiredField = true, hint = "0000 0000 0000 0000"
            )

            Row(
                modifier = Modifier.fillMaxWidth()
            ) {
                CustomTextBox(
                    modifier = Modifier.weight(1f),
                    maxCharSize = 7,
                    label = "Expiry",
                    hint = "MM/YYYY"
                )
                CustomTextBox(
                    modifier = Modifier.weight(1f),
                    maxCharSize = 7,
                    label = "CVV/CVC",
                    hint = "111"
                )
            }

            CustomTextBox(
                modifier = Modifier,
                maxCharSize = 60, label = "Address", hint = "123 Main Street"
            )
            Row(
                Modifier.height(70.dp)
            ) {
                CustomTextBox(
                    modifier = Modifier.weight(.6f),
                    maxCharSize = 30,
                    label = "Address 2",
                    hint = "Apt 123"
                )
                CustomTextBox(
                    modifier = Modifier.weight(.4f),
                    maxCharSize = 2,
                    label = "State",
                    hint = "CA"
                )
            }
            Row(
                Modifier.height(70.dp)
            ) {
                CustomTextBox(
                    modifier = Modifier.weight(.6f),
                    maxCharSize = 40,
                    label = "City",
                    hint = "City"
                )
                CustomTextBox(
                    modifier = Modifier.weight(.4f),
                    maxCharSize = 5,
                    label = "Zip Code",
                    hint = "00000"
                )
            }
        }
    }
}


@Preview(showBackground = true, backgroundColor = 0xFFFFFFFF)
@Composable
fun SheetPreview() {
    Surface(
        color = Color.White,
        contentColor = Color.White,
        modifier = Modifier.fillMaxSize()
    ){
        Sheet()
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PaymentSheetScreenM() {
    Scaffold {
            paddingValues ->
        Sheet(Modifier.padding(paddingValues))
    }
}

@Preview(showBackground = true, backgroundColor = 0xFFFFFFFF)
@Composable
fun CustomTextBoxPreview() {
    Surface(
        color = Color.White,
        contentColor = Color.White
    ){
        PaymentSheetScreenM()
    }
}

@Preview(showBackground = true, backgroundColor = 0xFFFFFFFF)
@Composable
fun CustomTextBoxPreview2() {
    Surface(
        Modifier.fillMaxSize(),
        color = Color.White,
        contentColor = Color.White
    ){
        PaymentSheetScreen(Modifier)
    }
}


