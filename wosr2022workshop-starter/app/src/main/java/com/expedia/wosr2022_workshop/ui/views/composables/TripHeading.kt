package com.expedia.wosr2022_workshop.ui.views.composables

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.expedia.wosr2022_workshop.application.DarkTheme
import com.expedia.wosr2022_workshop.ui.modifiers.color
import com.expedia.wosr2022_workshop.ui.modifiers.fontSize
import com.expedia.wosr2022_workshop.ui.modifiers.fontWeight

@Composable
fun TripsHeading(modifier: Modifier = Modifier) {
    Column {
        Text(
            text = "Find A Place To Stay",
            color = com.expedia.wosr2022_workshop.ui.modifiers.TextStyle.Large.color(),
            fontSize = com.expedia.wosr2022_workshop.ui.modifiers.TextStyle.Large.fontSize,
            fontWeight = com.expedia.wosr2022_workshop.ui.modifiers.TextStyle.Large.fontWeight
        )
        Spacer(Modifier.height(8.dp))
        DarkModeSelector(darkMode = DarkTheme.value) {
            DarkTheme.value = it
        }
    }
}