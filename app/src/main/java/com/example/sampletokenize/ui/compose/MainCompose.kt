package com.example.sampletokenize.ui.compose


import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.sampletokenize.ui.theme.SampleTokenizeTheme


@Composable
fun MyApp() {
    SampleTokenizeTheme {
        AddCardScreen()
    }
}

@Preview(widthDp = 360, heightDp = 640)
@Composable
fun MyAppPreview() {
    SampleTokenizeTheme() {
        MyApp()
    }
}

