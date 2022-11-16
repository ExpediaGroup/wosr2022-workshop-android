package com.expedia.wosr2022_workshop.application

import android.app.Application
import androidx.compose.runtime.compositionLocalOf
import androidx.compose.runtime.mutableStateOf
import com.expedia.design_tokens.IColorTokensSource
import com.expedia.design_tokens.IFontTokensSource
import com.expedia.design_tokens.TokensProvider
import com.expedia.design_tokens.brandATokens.BrandATokenActivator
import com.expedia.design_tokens.brandATokens.BrandATokensSource
import com.expedia.wosr2022_workshop.R
import com.expedia.wosr2022_workshop.model.Places
import com.expedia.wosr2022_workshop.model.Property
import com.expedia.wosr2022_workshop.utils.Brands

val DarkTheme = mutableStateOf(false)

class WOSRWorkshopApp: Application() {
    override fun onCreate() {
        super.onCreate()
        BrandATokenActivator.activate()
    }
}

val mockPlaces = arrayListOf(
    Property(name = "Hotel beach", rating = "very good", image = "stay1"),
    Property(name = "Hotel beach", rating = "very good", image = "stay1"),
    Property(name = "Hotel beach", rating = "very good", image = "stay1"),
    Property(name = "Hotel deluxe", rating = "not bad", image = "stay2"),
    Property(name = "Motel deluxe inn", rating = "very good", image = "stay3")
)
