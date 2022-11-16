package com.expedia.wosr2022_workshop.model

import com.google.gson.annotations.SerializedName

data class PlacesToStay(
    @SerializedName("places") val places: Places
)

data class Places(
    @SerializedName("recentlyViewed")
    val recentlyViewed: List<Property>,
    @SerializedName("recommendedStays")
    val recommendedStays: List<Property>
)