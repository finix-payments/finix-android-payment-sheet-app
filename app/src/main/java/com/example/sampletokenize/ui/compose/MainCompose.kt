package com.example.sampletokenize.ui.compose


import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Surface
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.sampletokenize.ui.theme.SampleTokenizeTheme


@Composable
fun MyApp(modifier: Modifier) {
    Surface(modifier = modifier) {
        AddCardScreen()
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Preview
@Composable
fun MyAppPreview() {
    SampleTokenizeTheme() {
        Surface(color = Color.White) {
            AddCardScreen(Modifier.padding())
        }
    }
}

