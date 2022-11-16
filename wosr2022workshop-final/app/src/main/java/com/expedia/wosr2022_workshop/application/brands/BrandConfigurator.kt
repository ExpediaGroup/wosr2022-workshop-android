package com.expedia.wosr2022_workshop.utils

import com.expedia.design_tokens.TokensProvider
import com.expedia.design_tokens.brandATokens.BrandATokenActivator
import com.expedia.design_tokens.brandBTokens.BrandBTokenActivator
import com.expedia.wosr2022_workshop.application.brands.TokenConfigurator


enum class Brands {
    BrandA, BrandB
}

class Brand(var brand: Brands = Brands.BrandA) {

    constructor(brand: String) : this() {
        when (brand) {
            Brands.BrandA.name -> this.brand = Brands.BrandA
            Brands.BrandB.name -> this.brand = Brands.BrandB
            else -> this.brand = Brands.BrandA
        }
    }

    fun setUp() {
        when (brand) {
            Brands.BrandA -> {
                BrandATokenActivator.activate()
            }
            Brands.BrandB -> {
                BrandBTokenActivator.activate()
            }
        }
        TokenConfigurator.initializeTokens(TokensProvider.tokensSource)
    }
}

fun Array<Brands>.toStringList(): List<String> {
    val retList = arrayListOf<String>()
    this.forEach {
        retList.add(it.name)
    }
    return retList
}