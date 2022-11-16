package com.expedia.wosr2022_workshop.ui.views.composables

import android.content.Context
import android.content.res.Resources
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.expedia.wosr2022_workshop.R
import com.expedia.wosr2022_workshop.ui.theme.LocalColorTokensProvider

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun RoundedImage(modifier: Modifier = Modifier, imageId: Int) {
    val isSelected = remember { mutableStateOf(false) }

    Surface(
        modifier = modifier
            .size(120.dp, 100.dp),
        shape = RoundedCornerShape(8),
        onClick = {
            isSelected.value = !isSelected.value
        }
    ) {
        Box(contentAlignment = Alignment.TopEnd) {
            Image(
                painterResource(imageId),
                contentDescription = "",
                contentScale = ContentScale.Crop,
                modifier = modifier.fillMaxSize()
            )
            Favorite(
                isSelected = isSelected.value,
                modifier = modifier
                    .padding(end = 8.dp)
                    .size(24.dp, 24.dp)
            )
        }
    }
}

@Composable
fun Favorite(modifier: Modifier = Modifier, isSelected: Boolean) {
    val contentDescription: String
    val drawableResource: Int = if (isSelected) {
        contentDescription = "Icon, Favorite property"
        com.expedia.design_tokens.R.drawable.icon__favorite
    } else {
        contentDescription = "Icon, Non favorite property"
        com.expedia.design_tokens.R.drawable.icon__favorite_border
    }

    Image(
        painterResource(drawableResource),
        contentDescription = contentDescription,
        contentScale = ContentScale.Crop,
        colorFilter = ColorFilter.tint(Color.Red),
        modifier = modifier.fillMaxSize()
    )

}

@Composable
fun RoundedImageHolder(modifier: Modifier = Modifier) {
    Surface(
        modifier = modifier
            .size(120.dp, 100.dp),
        shape = RoundedCornerShape(8)
    ) {
        Surface(color = colorResource(id = LocalColorTokensProvider.current.secondaryBackground)) {}
    }
}


fun getDrawableId(drawableName: String, context: Context): Int {
    val resources: Resources = context.resources
    return resources.getIdentifier(
        drawableName, "drawable",
        context.packageName
    )
}

@Preview
@Composable
fun PreviewRoundedImage() {
    RoundedImage(imageId = R.drawable.stay1)
}

@Preview
@Composable
fun PreviewRoundedImageHolder() {
    RoundedImageHolder()
}