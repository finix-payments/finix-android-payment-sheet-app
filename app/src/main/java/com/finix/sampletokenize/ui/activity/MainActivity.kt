package com.finix.sampletokenize.ui.activity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.finix.sampletokenize.ui.compose.addCard.MyAppHome
import com.finix.sampletokenize.ui.theme.SampleTokenizeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SampleTokenizeTheme {
                Surface(Modifier.fillMaxSize()) {
                    MyAppHome()
                }
            }
        }
    }
}

