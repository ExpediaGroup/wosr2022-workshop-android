package com.expedia.wosr2022_workshop.ui.modifiers

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.TextUnit
import com.expedia.design_tokens.buttonText
import com.expedia.design_tokens.large
import com.expedia.design_tokens.medium
import com.expedia.design_tokens.small
import com.expedia.design_tokens.subText
import com.expedia.wosr2022_workshop.ui.theme.LocalColorTokensProvider
import com.google.gson.annotations.SerializedName

enum class TextStyle {
    @SerializedName("small")
    Small,

    @SerializedName("medium")
    Medium,

    @SerializedName("large")
    Large,

    @SerializedName("subText")
    SubText,

    @SerializedName("buttonText")
    ButtonText
}

@Composable
fun TextStyle.color(): Color {
        return when (this) {
            TextStyle.Small -> colorResource(id = LocalColorTokensProvider.current.subText)
            TextStyle.Large -> colorResource(id = LocalColorTokensProvider.current.headingText)
            TextStyle.SubText -> colorResource(id = LocalColorTokensProvider.current.headingText)
            TextStyle.Medium -> colorResource(id = LocalColorTokensProvider.current.subText)
            TextStyle.ButtonText -> colorResource(id = LocalColorTokensProvider.current.subText)
        }
    }

val TextStyle.fontSize: TextUnit
    get() {
        return when (this) {
            TextStyle.Small -> TextUnit.small
            TextStyle.Large -> TextUnit.large
            TextStyle.SubText -> TextUnit.subText
            TextStyle.Medium -> TextUnit.medium
            TextStyle.ButtonText -> TextUnit.buttonText
        }
    }

val TextStyle.fontWeight: FontWeight
    get() {
        return when (this) {
            TextStyle.Small -> FontWeight.Normal
            TextStyle.Large -> FontWeight.ExtraBold
            TextStyle.SubText -> FontWeight.ExtraBold
            TextStyle.Medium -> FontWeight.ExtraBold
            TextStyle.ButtonText -> FontWeight.Normal
        }
    }
