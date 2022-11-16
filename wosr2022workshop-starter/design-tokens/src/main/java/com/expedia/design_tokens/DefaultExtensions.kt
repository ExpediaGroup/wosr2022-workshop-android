@file:OptIn(ExperimentalUnitApi::class)

package com.expedia.design_tokens

import androidx.compose.ui.unit.ExperimentalUnitApi
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType

val TextUnit.Companion.large: TextUnit
    get() {
        return TextUnit(TokensProvider.tokensSource.fontTokens.large, TextUnitType.Sp)
    }

val TextUnit.Companion.medium: TextUnit
    get() {
        return TextUnit(TokensProvider.tokensSource.fontTokens.medium, TextUnitType.Sp)
    }

val TextUnit.Companion.small: TextUnit
    get() {
        return TextUnit(TokensProvider.tokensSource.fontTokens.small, TextUnitType.Sp)
    }

val TextUnit.Companion.subText: TextUnit
    get() {
        return TextUnit(TokensProvider.tokensSource.fontTokens.subText, TextUnitType.Sp)
    }

val TextUnit.Companion.buttonText: TextUnit
    get() {
        return TextUnit(
            TokensProvider.tokensSource.fontTokens.buttonText,
            TextUnitType.Sp
        )
    }
