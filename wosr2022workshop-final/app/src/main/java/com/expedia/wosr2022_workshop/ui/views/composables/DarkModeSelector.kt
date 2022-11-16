package com.expedia.wosr2022_workshop.ui.views.composables

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material.Switch
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.expedia.wosr2022_workshop.ui.modifiers.TextStyle
import com.expedia.wosr2022_workshop.ui.modifiers.color

@Composable
fun DarkModeSelector(
    modifier: Modifier = Modifier,
    darkMode: Boolean,
    onCheckedChanged: (Boolean) -> Unit
) {
    val selected = remember { mutableStateOf(darkMode) }
    Row(
        modifier
            .fillMaxWidth()
            .wrapContentHeight(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = "Dark mode switcher",
            color = TextStyle.Medium.color(),
            fontSize = 18.sp
        )
        Switch(
            checked = selected.value, onCheckedChange = {
                selected.value = it
                onCheckedChanged(it)
            }
        )
    }
}

@Preview
@Composable
fun PreviewDarkModeSelector() {
    DarkModeSelector(darkMode = false) {}
}
