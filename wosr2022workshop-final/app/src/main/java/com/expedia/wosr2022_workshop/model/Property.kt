package com.expedia.wosr2022_workshop.model

import com.expedia.wosr2022_workshop.ui.modifiers.TextStyle
import java.util.UUID

data class Property(
    val id: UUID = UUID.randomUUID(),
    val name: String,
    val rating: String,
    val image: String,
    var nameFontStyle: TextStyle = TextStyle.Medium,
    var ratingFontStyle: TextStyle = TextStyle.Medium
)