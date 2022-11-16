package com.expedia.wosr2022_workshop.ui.views.composables

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.expedia.wosr2022_workshop.model.Property
import com.expedia.wosr2022_workshop.ui.modifiers.color
import com.expedia.wosr2022_workshop.ui.modifiers.fontSize
import com.expedia.wosr2022_workshop.ui.modifiers.fontWeight
import com.expedia.wosr2022_workshop.ui.theme.LocalColorTokensProvider

@Composable
fun PropertyView(property: Property) {
    val context = LocalContext.current
    Column(horizontalAlignment = Alignment.Start) {
        RoundedImage(imageId = getDrawableId(property.image, context))
        Spacer(modifier = Modifier.height(4.dp))
        Text(
            text = property.name,
            color = property.nameFontStyle.color(),
            fontSize = property.nameFontStyle.fontSize,
            fontWeight = property.nameFontStyle.fontWeight
        )
        Spacer(modifier = Modifier.height(2.dp))
        Text(
            text = property.rating,
            color = property.ratingFontStyle.color(),
            fontSize = property.ratingFontStyle.fontSize,
            fontWeight = property.ratingFontStyle.fontWeight
        )
    }
}
