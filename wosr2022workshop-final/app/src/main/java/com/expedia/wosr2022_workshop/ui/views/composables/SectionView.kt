package com.expedia.wosr2022_workshop.ui.views.composables

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.expedia.wosr2022_workshop.application.mockPlaces
import com.expedia.wosr2022_workshop.model.Property
import com.expedia.wosr2022_workshop.ui.modifiers.TextStyle
import com.expedia.wosr2022_workshop.ui.modifiers.color
import com.expedia.wosr2022_workshop.ui.modifiers.fontSize
import com.expedia.wosr2022_workshop.ui.modifiers.fontWeight

@Composable
fun SectionView(
    modifier: Modifier = Modifier,
    sectionName: String, places: List<Property>,
    isLoading: Boolean
) {
    Box(
        modifier = modifier.padding(0.dp).height(height = 200.dp),
        contentAlignment = Alignment.TopStart
    ) {
        Column(modifier = modifier) {
            Text(
                sectionName,
                color = TextStyle.SubText.color(),
                fontSize = TextStyle.SubText.fontSize,
                fontWeight = TextStyle.SubText.fontWeight
            )
            Spacer(modifier = Modifier.height(24.dp))
            LazyRow(horizontalArrangement = Arrangement.spacedBy(6.dp)) {
                items(places.size) { place ->
                    if (isLoading)
                        PropertyViewHolder()
                    else
                        PropertyView(places[place])
                }
            }
        }
    }
}

@Preview
@Composable
fun PreviewSectionView() {
    SectionView(
        modifier = Modifier.height(200.dp),
        sectionName = "Recently viewed",
        places = mockPlaces,
        isLoading = false
    )
}

@Preview
@Composable
fun PreviewSectionViewLoading() {

    SectionView(
        modifier = Modifier.height(200.dp),
        sectionName = "Recently viewed",
        places = mockPlaces,
        isLoading = true
    )
}