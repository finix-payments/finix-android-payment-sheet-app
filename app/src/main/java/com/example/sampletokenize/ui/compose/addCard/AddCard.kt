package com.example.sampletokenize.ui.compose.addCard

import android.widget.Toast
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.sampletokenize.R
import com.example.sampletokenize.ui.compose.common.HorizontalPartialDivider
import com.example.sampletokenize.ui.theme.*
import com.finix.finixpaymentsheet.ui.viewModel.PaymentSheetWithResults


@Composable
fun Banner(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .height(180.dp)
            .fillMaxWidth()
            .background(lightGray)
    ) {

    }
}

@Preview(showBackground = true, backgroundColor = 0xFFF0EAE2)
@Composable
fun BannerPreview(){
    Banner()
}

@Composable
fun RoundedLogo(
    @DrawableRes drawable: Int,
) {
    Image(
        painter = painterResource(id = drawable),
        contentDescription = null,
        contentScale = ContentScale.Crop,
        modifier = Modifier
            .clip(CircleShape)
            .border(6.dp, Color.White, CircleShape)
    )
}

@Composable
fun DaphneysCorner(
    @StringRes text: Int,
    modifier: Modifier = Modifier
) {
    Text(
        modifier = modifier,
        text = stringResource(id = text),
        style = DaphnesCustomTypography.h5,
    )
}

@Preview(showBackground = true, backgroundColor = 0xFFF0EAE2)
@Composable
fun DaphneysCornerPreview() {
    DaphneysCorner(text = R.string.daphneys_corner)
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddCardButton(
    modifier: Modifier = Modifier,
    onClick: (Boolean) -> Unit
) {
    Card(
        onClick = {
                  onClick(true)
        },
        elevation = CardDefaults.cardElevation(6.dp),
        modifier = modifier
            .width(296.dp)
            .height(170.dp),
        shape = RoundedCornerShape(20.dp),
        border = BorderStroke(1.dp,Color.LightGray),
        ) {
        Image(
            painter = painterResource(id = R.drawable.ic_add),
            contentDescription = null,
            modifier = modifier
                .background(addCardColor)
                .padding(vertical = 74.dp)
                .fillMaxWidth()
                .height(25.dp)
        )
    }
}


@Composable
fun AddCardScreen(
    modifier: Modifier = Modifier
) {

    //we can also use viewModel for state
    val viewModel = viewModel<AddCardViewModel>()
    val state = viewModel.state

    var showFinixPaymentSheet by remember { mutableStateOf(false) }
    val context = LocalContext.current

    if (showFinixPaymentSheet) {
        PaymentSheetWithResults(
            // add any methods that would happen once the sheet is dismissed by a side swipe, or leave empty if you don't want anything to happen
            onDismiss = {
                showFinixPaymentSheet = !showFinixPaymentSheet
                Toast.makeText(context, "Dialog dismissed!", Toast.LENGTH_SHORT).show()
            },
            // add any methods that would happen when the user clicks the cancel button, or leave empty if you don't want anything to happen
            onNegativeClick = {
                showFinixPaymentSheet = !showFinixPaymentSheet
                Toast.makeText(context, "Negative Button Clicked!", Toast.LENGTH_SHORT).show()

            },
            // add any methods that would happen when the user clicks on the tokenize button and a token response is returned; you should save this token for your own use
            onPositiveClick = { Token ->
                showFinixPaymentSheet = !showFinixPaymentSheet
                Toast.makeText(context, "Tokenize Response: $Token", Toast.LENGTH_SHORT).show()
            },
            finixId = "APjMB6owJ7542dehJ6hCojzR", // change to your own application ID
            isSandbox = true, // you can change to false to set it to a production environment
            /** You can use the below fields to customize the paymnet sheet
            logo = R.drawable.ic_default_logo // this would define the logo that's passed
            logoText = = R.string.default_logo_text // this would define the title of the payment sheet
             **/
        )
    }


    Box(modifier = modifier, contentAlignment = Alignment.BottomCenter){
        Banner()
    }
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(10.dp),
        modifier = modifier
            .fillMaxWidth()
            .padding(top = 110.dp)
    ) {
        RoundedLogo(drawable = R.drawable.ic_logo)
        DaphneysCorner(text = R.string.daphneys_corner)
    }
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(40.dp),
        modifier = modifier
            .fillMaxWidth()
            .padding(top = 372.dp)
    ) {
        HorizontalPartialDivider(widthDP = 321.dp)
        AddCardButton(onClick = { clicked ->
            showFinixPaymentSheet = clicked
        })
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Preview(showBackground = true, backgroundColor = 0xFFFFFFFF)
@Composable
fun MyAppHome() {
    SampleTokenizeTheme() {
        Scaffold { paddingValues ->
        AddCardScreen(Modifier.padding(paddingValues))
        }
    }
}
