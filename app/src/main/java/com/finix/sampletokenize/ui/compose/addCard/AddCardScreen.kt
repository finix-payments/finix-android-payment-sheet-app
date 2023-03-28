package com.finix.sampletokenize.ui.compose.addCard


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.selection.SelectionContainer
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import androidx.lifecycle.viewmodel.compose.viewModel
import com.finix.sampletokenize.R
import com.finix.sampletokenize.ui.compose.common.HorizontalPartialDivider
import com.finix.sampletokenize.ui.theme.*
import com.finix.finixpaymentsheet.ui.viewModel.*
import com.finix.sampletokenize.ui.compose.addCard.components.*


@Composable
fun AddCardScreen(
    modifier: Modifier = Modifier
) {

    val viewModel = viewModel<AddCardViewModel>()
    val state = viewModel.state
    val context = LocalContext.current


    /**
     * These are all the payment sheet variations available,
     *
     * options are COMPLETE, PARTIAL, BASIC, MINIMAL,
     * variations are 1. default 2. Outlined
     *
     *  COMPLETE: Name, Card, Expiry, CVV, Address && address Ext, City, State, Zip
     *  PARTIAL: Name, Card, Expiry, CVV, Zip
     *  BASIC: Name, Card, Expiry, CVV
     *  MINIMAL: Card, Expiry, CVV
     *
     * ShowCompletePaymentSheetOutlined
     * ShowPartialPaymentSheetOutlined
     * ShowBasicPaymentSheetOutlined
     * ShowMinimalPaymentSheetOutlined
     * ShowCompletePaymentSheet
     * ShowPartialPaymentSheet
     * ShowBasicPaymentSheet
     * ShowMinimalPaymentSheet
     *
     */




    Box(modifier = modifier, contentAlignment = Alignment.BottomCenter){
        Banner()
    }

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(10.dp),
        modifier = modifier.fillMaxWidth().padding(top = 110.dp)
    ) {
        RoundedLogo(drawable = R.drawable.ic_logo)
        DaphneysCorner(text = R.string.daphneys_corner)
    }

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(40.dp),
        modifier = modifier.fillMaxWidth().padding(top = 372.dp)
    ) {

        HorizontalPartialDivider(widthDP = 321.dp)
        AddCardButton(
            onClick = { clicked ->
                //TODO when this button is clicked, we should show the payment sheet we've selected
            }
        )
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


