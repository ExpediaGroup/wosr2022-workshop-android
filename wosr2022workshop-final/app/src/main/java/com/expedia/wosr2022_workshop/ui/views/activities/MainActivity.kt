package com.expedia.wosr2022_workshop.ui.views.activities

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.expedia.design_tokens.BrandTokens
import com.expedia.wosr2022_workshop.application.DarkTheme
import com.expedia.wosr2022_workshop.ui.theme.LocalColorTokensProvider
import com.expedia.wosr2022_workshop.ui.theme.WOSRWorkshopTheme
import com.expedia.wosr2022_workshop.ui.views.composables.BrandView
import com.expedia.wosr2022_workshop.ui.views.composables.TripView
import com.expedia.wosr2022_workshop.ui.views.navigation.NavigationComponent
import com.expedia.wosr2022_workshop.ui.views.navigation.RouteBrandView
import com.expedia.wosr2022_workshop.ui.views.navigation.RouteTripView

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            // A surface container using the 'background' color from the theme
            WOSRWorkshopTheme(
                darkTheme = DarkTheme.value,
                brandTokens = BrandTokens.value
            ) {
                val modifier = Modifier

                Surface(
                    modifier = modifier
                        .fillMaxSize()
                ) {
                    WorkShop(modifier)
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    NavigationComponent()
}

@Composable
fun WorkShop(modifier: Modifier = Modifier) {
    val navController = rememberNavController()
    val startDestination: String = RouteBrandView.toString()


    NavHost(
        modifier = modifier
            .fillMaxSize(),
        navController = navController, startDestination = startDestination
    ) {
        composable(RouteBrandView.toString()) {
            BrandView(
                modifier
                    .padding(10.dp), navController
            )
        }
        composable(RouteTripView.toString()) {
            TripView(
                modifier
                    .background(color = colorResource(id = LocalColorTokensProvider.current.primaryBackground))
                    .padding(10.dp)
            )
        }
    }
}