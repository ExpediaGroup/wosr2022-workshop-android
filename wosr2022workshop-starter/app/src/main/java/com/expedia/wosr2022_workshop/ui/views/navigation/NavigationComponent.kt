package com.expedia.wosr2022_workshop.ui.views.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.expedia.wosr2022_workshop.repositories.PlacesLocalRepository
import com.expedia.wosr2022_workshop.ui.views.composables.BrandView
import com.expedia.wosr2022_workshop.ui.views.composables.TripView

@Composable
fun NavigationComponent(
    modifier: Modifier = Modifier,
    placesLocalRepository: PlacesLocalRepository,
    startDestination: String = RouteBrandView.toString()
) {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = startDestination) {
        composable(RouteBrandView.toString()) {
            navController.popBackStack()
            BrandView(modifier, navController)
        }
        composable(RouteTripView.toString()) {
            TripView(modifier, placesLocalRepository)
        }
    }
}