package com.expedia.wosr2022_workshop.ui.theme

import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.compositionLocalOf
import com.expedia.design_tokens.ITokensProvider
import com.expedia.design_tokens.TokensProvider

val LocalColorTokensProvider = compositionLocalOf { TokensProvider.tokensSource.lightColorTokens }
val LocalFontsTokensProvider = compositionLocalOf { TokensProvider.tokensSource.fontTokens }

@Composable
fun WOSRWorkshopTheme(
    darkTheme: Boolean,
    brandTokens: ITokensProvider,
    content: @Composable () -> Unit
) {
    val colorTokens = if (darkTheme)
        brandTokens.darkColorTokens
    else
        brandTokens.lightColorTokens

    CompositionLocalProvider(
        values =
        arrayOf(
            LocalColorTokensProvider provides colorTokens,
            LocalFontsTokensProvider provides brandTokens.fontTokens
        )
    ) {
        MaterialTheme(content = content)
    }
}