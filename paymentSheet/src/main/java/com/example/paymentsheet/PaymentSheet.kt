package com.example.paymentsheet

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.paymentsheet.ui.theme.SampleTokenizeTheme
import com.example.paymentsheet.ui.theme.lightGray

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SampleTokenizeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {

                }
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

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

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    SampleTokenizeTheme {
        Greeting("Android")
    }
}
