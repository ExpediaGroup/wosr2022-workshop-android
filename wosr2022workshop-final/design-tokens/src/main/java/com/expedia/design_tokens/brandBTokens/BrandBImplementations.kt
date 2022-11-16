package com.expedia.design_tokens.brandBTokens

import com.expedia.design_tokens.IColorTokensSource
import com.expedia.design_tokens.IFontTokensSource
import com.expedia.design_tokens.ITokensProvider
import com.expedia.design_tokens.R
import com.expedia.design_tokens.TokensProvider

// region Brand B
object BrandBTokenActivator {
    fun activate() {
        TokensProvider.tokensSource = BrandBTokensSource()
    }
}

data class BrandBTokensSource(
    override var fontTokens: IFontTokensSource = BrandBFontTokens(),
    override val lightColorTokens: IColorTokensSource = BrandBColorTokensLight(),
    override val darkColorTokens: IColorTokensSource = BrandBColorTokensDark()
) : ITokensProvider

data class BrandBColorTokensLight(
    override var primaryBackground: Int = R.color.brandBPrimaryColorLight,
    override var secondaryBackground: Int = R.color.brandBSecondaryColorLight,
    override var headingText: Int = R.color.brandBHeadingTextLight,
    override var subText: Int = R.color.brandBSubTextLight,
    override var buttonText: Int = R.color.brandBSubTextLight
) : IColorTokensSource

data class BrandBColorTokensDark(
    override var primaryBackground: Int = R.color.brandBPrimaryColorDark,
    override var secondaryBackground: Int = R.color.brandBSecondaryColorDark,
    override var headingText: Int = R.color.brandBHeadingTextDark,
    override var subText: Int = R.color.brandBSubTextDark,
    override var buttonText: Int = R.color.brandBSubTextDark
) : IColorTokensSource

data class BrandBFontTokens(
    override var large: Float = 36f,
    override var medium: Float = 12f,
    override var small: Float = 12f,
    override var subText: Float = 24f,
    override var buttonText: Float = 12f
) : IFontTokensSource
// endregion