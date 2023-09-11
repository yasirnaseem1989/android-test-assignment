package com.example.shacklehotelbuddy.ui.detail

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.shacklehotelbuddy.ui.components.Icon
import com.example.shacklehotelbuddy.ui.theme.ShackleHotelBuddyTheme
import org.koin.androidx.compose.koinViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailScreen(
    onBackClick: () -> Unit,
    viewModel: SearchHotelsViewModel = koinViewModel()
) {
    val data = viewModel.homeState.collectAsState()

    val lazyListState = rememberLazyListState()

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = "Search Result") },
                navigationIcon = {
                    IconButton(onClick = onBackClick) {
                        Icon(Icons.Rounded.ArrowBack)
                    }
                }
            )
        }
    ) { innerPadding ->
    Box {
            Column(
                modifier = Modifier
                    .padding(innerPadding)
            ) {
                LazyColumn(
                    state = lazyListState
                ) {
                    for (hotels in data.value.hotels) {
                        item {
                            HotelItem(
                                item = hotels
                            )
                        }
                    }
                    item {
                        Spacer(modifier = Modifier.height(40.dp))
                    }
                }
            }
        }

    }
}


@Preview("HomeScreen")
@Composable
private fun DetailScreenPreview() {
    ShackleHotelBuddyTheme {
        DetailScreen(
            onBackClick = {},
        )
    }
}
