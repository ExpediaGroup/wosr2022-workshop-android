package com.expedia.wosr2022_workshop.application.brands

import com.expedia.design_tokens.ITokensProvider
import com.expedia.design_tokens.TokensProvider

object TokenConfigurator {
    fun initializeTokens(source: ITokensProvider) {
        TokensProvider.tokensSource = source
    }
}