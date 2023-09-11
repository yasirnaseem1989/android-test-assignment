package com.example.shacklehotelbuddy.ui.home

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons.Outlined
import androidx.compose.material.icons.outlined.DateRange
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun DateSelectionView(
    modifier: Modifier = Modifier,
    title: String =  "",
    selectedDate: String = "",
    onDateClicked: () -> Unit
) {
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically,
    ) {
        BookingFieldInfo(modifier = Modifier.weight(1f), title = title, icon = Outlined.DateRange)
        Divider(
            color = Color.LightGray,
            modifier = Modifier
                .width(1.dp)
                .fillMaxHeight()
        )
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .weight(1f)
                .fillMaxSize()
                .padding(horizontal = 16.dp)
                .clickable { onDateClicked() }
        ) {
            Text(
                text = selectedDate,
                style = MaterialTheme.typography.bodyMedium,
            )
        }
    }
}