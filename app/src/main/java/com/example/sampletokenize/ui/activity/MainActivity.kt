package com.example.sampletokenize.ui.activity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.example.paymentsheet.PaymentSheetA
import com.example.paymentsheet.PaymentSheetScreen
import com.example.sampletokenize.R
import com.example.sampletokenize.ui.theme.SampleTokenizeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SampleTokenizeTheme {
                Surface(Modifier.fillMaxSize()) {
                    PaymentSheetA(
                        logo = R.drawable.ic_logo,
                        logoText = R.string.daphneys_corner
                    )
                }
            }
        }
    }
}

