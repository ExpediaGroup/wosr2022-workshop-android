package com.expedia.wosr2022_workshop.ui.views.composables

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.expedia.design_tokens.brandATokens.BrandATokenActivator
import com.expedia.wosr2022_workshop.model.PlacesToStayViewModel
import com.expedia.wosr2022_workshop.repositories.PlacesLocalRepository

@Composable
fun TripView(
    modifier: Modifier,
    repository: PlacesLocalRepository = PlacesLocalRepository(LocalContext.current),
    viewModel: PlacesToStayViewModel = remember { PlacesToStayViewModel(repository) }
) {
    Column(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        // Heading
        TripsHeading()

        Spacer(modifier = Modifier.height(4.dp))

        Column {
            SectionView(
                sectionName = "Recently Viewed",
                places = viewModel.recentlyViewed.value,
                isLoading = viewModel.isLoading.value
            )
            Spacer(modifier = Modifier.height(32.dp))
            SectionView(
                sectionName = "Recommended stays",
                places = viewModel.recommendedStays.value,
                isLoading = viewModel.isLoading.value
            )
        }
    }
}

@Preview
@Composable
fun TripView_Preview() {
    BrandATokenActivator.activate()
    TripView(
        modifier = Modifier
            .fillMaxSize()
            .padding(10.dp)
    )
}

