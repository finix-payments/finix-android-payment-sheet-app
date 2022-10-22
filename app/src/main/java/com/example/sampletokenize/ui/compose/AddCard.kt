package com.example.sampletokenize.ui.compose

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
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.sampletokenize.R
import com.example.sampletokenize.ui.compose.common.HorizontalPartialDivider
import com.example.sampletokenize.ui.theme.*


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
fun AddCardButton(modifier: Modifier = Modifier) {
    Card(
        onClick = {

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


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddCardButton2(modifier: Modifier = Modifier) {
    Card(
        onClick = {},
        elevation = CardDefaults.cardElevation(6.dp),
        modifier = modifier
            .width(296.dp)
            .height(170.dp),
        shape = RoundedCornerShape(20.dp),
        border = BorderStroke(1.dp,Color.LightGray),

        ) {
//        Icon(
//            imageVector = Icons.Default.Add,
//            contentDescription = null,
//            modifier = modifier
//                .background(lightGray)
//                .padding(60.dp)
//        )
//        Image(
//            painter = painterResource(id = R.drawable.ic_add),
//            contentDescription = null,
//            modifier = modifier
//                .background(lightGray)
//                .padding(70.dp)
//        )
    }

}


@Preview(showBackground = true, backgroundColor = 0xFFF0EAE2)
@Composable
fun AddCardButtonPreview(){
    AddCardButton()
}

@Preview(showBackground = true, backgroundColor = 0xFFF0EAE2)
@Composable
fun AddCardButton2Preview(){
    AddCardButton2()
}


@Composable
fun AddCardScreen(
    modifier: Modifier = Modifier
) {
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
        AddCardButton()
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Preview(showBackground = true, backgroundColor = 0xFFFFFFFF)
@Composable
fun IconPreview() {
    SampleTokenizeTheme() {
        Scaffold { paddingValues ->
        AddCardScreen(Modifier.padding(paddingValues))
        }
    }
}
