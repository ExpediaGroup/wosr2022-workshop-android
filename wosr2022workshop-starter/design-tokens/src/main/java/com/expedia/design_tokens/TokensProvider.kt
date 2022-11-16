package com.expedia.design_tokens

import androidx.compose.runtime.mutableStateOf
import com.expedia.design_tokens.brandATokens.BrandATokensSource

val BrandTokens = mutableStateOf(TokensProvider.tokensSource)

object TokensProvider : ITokensSource {
    override var tokensSource: ITokensProvider = BrandATokensSource()
}

interface ITokensProvider {
    var fontTokens: IFontTokensSource
    val darkColorTokens: IColorTokensSource
    val lightColorTokens: IColorTokensSource
}

interface ITokensSource {
    var tokensSource: ITokensProvider
}

interface IFontTokensSource {
    var large: Float
    var medium: Float
    var small: Float
    var subText: Float
    var buttonText: Float
}

interface IColorTokensSource {
    var primaryBackground: Int
    var secondaryBackground: Int
    var headingText: Int
    var buttonText: Int
    var subText: Int
}
