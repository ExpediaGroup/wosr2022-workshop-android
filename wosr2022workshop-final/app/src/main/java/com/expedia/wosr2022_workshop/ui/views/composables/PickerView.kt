package com.expedia.wosr2022_workshop.ui.views.composables

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun PickerView(modifier: Modifier = Modifier, options: List<String>, onSelect: (String) -> Unit) {

    val selectedRow = remember { mutableStateOf(0) }
    val itemSize = LocalConfiguration.current.screenWidthDp.dp / options.size

    Row {
        options.forEach {
            PickerViewItem(
                modifier = modifier.width(itemSize),
                title = it,
                selected = selectedRow.value == options.indexOf(it),
                onSelect = {
                    selectedRow.value = options.indexOf(it)
                    onSelect.invoke(it)
                }
            )
        }
    }
}

@Composable
fun PickerViewItem(
    modifier: Modifier = Modifier,
    title: String,
    selected: Boolean,
    onSelect: () -> Unit
) {
    val color = if (selected) Color.LightGray else Color.White

    Button(
        modifier = modifier,
        colors = ButtonDefaults.outlinedButtonColors(
            backgroundColor = color
        ),
        elevation = ButtonDefaults.elevation(),
        onClick = { onSelect.invoke() }) {
        Text(
            textAlign = TextAlign.Center,
            text = title,
            color = Color.Black,
            fontSize = 14.sp
        )
    }
}

@Preview
@Composable
fun PreviewPickerView() {
    val options = arrayListOf("Expedia", "Vrbo")

    PickerView(options = options, onSelect = { print("New option selected: $it") })
}
