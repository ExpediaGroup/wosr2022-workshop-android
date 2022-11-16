package com.expedia.design_tokens.brandATokens

import com.expedia.design_tokens.IColorTokensSource
import com.expedia.design_tokens.IFontTokensSource
import com.expedia.design_tokens.ITokensProvider
import com.expedia.design_tokens.R
import com.expedia.design_tokens.TokensProvider

// region Brand A
object BrandATokenActivator {
    fun activate() {
        TokensProvider.tokensSource = BrandATokensSource()
    }
}

data class BrandATokensSource(
    override var fontTokens: IFontTokensSource = BrandAFontTokens(),
    override val darkColorTokens: IColorTokensSource = BrandAColorTokensDark(),
    override val lightColorTokens: IColorTokensSource = BrandAColorTokensLight()
) : ITokensProvider

data class BrandAColorTokensLight(
    override var primaryBackground: Int = R.color.brandAPrimaryColorLight,
    override var secondaryBackground: Int = R.color.brandASecondaryColorLight,
    override var headingText: Int = R.color.brandAHeadingTextLight,
    override var buttonText: Int = R.color.brandASubTextLight,
    override var subText: Int = R.color.brandASubTextLight
) : IColorTokensSource

data class BrandAColorTokensDark(
    override var primaryBackground: Int = R.color.brandAPrimaryColorDark,
    override var secondaryBackground: Int = R.color.brandASecondaryColorDark,
    override var headingText: Int = R.color.brandAHeadingTextDark,
    override var buttonText: Int = R.color.brandASubTextDark,
    override var subText: Int = R.color.brandASubTextDark
) : IColorTokensSource

data class BrandAFontTokens(
    override var large: Float = 36f,
    override var medium: Float = 12f,
    override var small: Float = 12f,
    override var subText: Float = 24f,
    override var buttonText: Float = 12f
) : IFontTokensSource
// endregion