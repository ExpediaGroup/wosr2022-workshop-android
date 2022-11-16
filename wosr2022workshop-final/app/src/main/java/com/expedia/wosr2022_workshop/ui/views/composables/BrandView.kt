package com.expedia.wosr2022_workshop.ui.views.composables

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.expedia.design_tokens.BrandTokens
import com.expedia.design_tokens.TokensProvider
import com.expedia.design_tokens.brandATokens.BrandATokenActivator
import com.expedia.wosr2022_workshop.ui.modifiers.TextStyle
import com.expedia.wosr2022_workshop.ui.modifiers.fontSize
import com.expedia.wosr2022_workshop.ui.modifiers.fontWeight
import com.expedia.wosr2022_workshop.ui.views.navigation.RouteTripView
import com.expedia.wosr2022_workshop.utils.Brand
import com.expedia.wosr2022_workshop.utils.Brands
import com.expedia.wosr2022_workshop.utils.toStringList

@Composable
fun BrandView(modifier: Modifier = Modifier, navController: NavHostController) {
    val brand: Brand = remember { Brand(brand = Brands.BrandA) }
    brand.setUp()
    Column(modifier = modifier) {
        Text(
            text = "Brands",
            color = Color.Black,
            fontSize = TextStyle.Large.fontSize,
            fontWeight = TextStyle.Large.fontWeight
        )

        Spacer(modifier = Modifier.height(4.dp))

        PickerView(options = Brands.values().toStringList(), onSelect = {
            Brand(it).setUp()
            BrandTokens.value = TokensProvider.tokensSource
        })

        Spacer(modifier = Modifier.height(8.dp))

        Button(
            modifier = Modifier.fillMaxWidth(),
            colors = ButtonDefaults.buttonColors(
                backgroundColor = Color.White,
                contentColor = Color.Black
            ),
            onClick = {
                navController.navigate(RouteTripView.toString())
            }) {
            Text(
                text = "See your trips with ${brand.javaClass.name.split(".").last()} styling",
                color = Color.Black,
                fontSize = 14.sp
            )
        }

    }
}

@Preview
@Composable
fun PreviewBrandView() {
    BrandATokenActivator.activate()
    BrandView(modifier = Modifier, navController = rememberNavController())
}
