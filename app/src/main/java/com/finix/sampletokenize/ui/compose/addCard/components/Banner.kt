package com.finix.sampletokenize.ui.compose.addCard

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.finix.sampletokenize.R
import com.finix.sampletokenize.ui.theme.DaphnesCustomTypography
import com.finix.sampletokenize.ui.theme.lightGray


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






