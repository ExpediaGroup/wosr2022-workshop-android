package com.expedia.wosr2022_workshop.ui.views.composables

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.expedia.wosr2022_workshop.ui.theme.LocalColorTokensProvider

@Composable
fun PropertyViewHolder() {
    Column(horizontalAlignment = Alignment.Start) {
        RoundedImageHolder()
        Spacer(modifier = Modifier.height(4.dp))
        GrayBarText(
            modifier = Modifier
                .height(12.dp)
                .width(60.dp)
        )
        Spacer(modifier = Modifier.height(2.dp))
        GrayBarText(
            modifier = Modifier
                .height(12.dp)
                .width(90.dp)
        )
    }
}

@Composable
fun GrayBarText(modifier: Modifier) {
    Surface(
        modifier = modifier,
        shape = RoundedCornerShape(8)
    ) {
        Surface(color = colorResource(id = LocalColorTokensProvider.current.secondaryBackground)) {}
    }
}

@Composable
@Preview
fun PreviewGrayBarText() {
    GrayBarText(
        modifier = Modifier
            .height(12.dp)
            .width(80.dp)
    )
}