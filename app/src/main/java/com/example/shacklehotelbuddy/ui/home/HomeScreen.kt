package com.example.shacklehotelbuddy.ui.home

import android.os.Build.VERSION_CODES
import android.util.Log
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.shacklehotelbuddy.R.drawable
import com.example.shacklehotelbuddy.ui.theme.ShackleHotelBuddyTheme
import com.maxkeppeker.sheets.core.models.base.rememberSheetState
import com.maxkeppeler.sheets.calendar.CalendarDialog
import com.maxkeppeler.sheets.calendar.models.CalendarConfig
import com.maxkeppeler.sheets.calendar.models.CalendarSelection.Date
import com.maxkeppeler.sheets.calendar.models.CalendarStyle.MONTH

@OptIn(ExperimentalMaterial3Api::class)
@RequiresApi(VERSION_CODES.O)
@Composable
fun HomeScreen(
    onSearchClicked: () -> Unit,
) {
    val calendarState = rememberSheetState()

    CalendarDialog(
        state = calendarState,
        config = CalendarConfig(
            monthSelection = true,
            yearSelection = true,
            style = MONTH,
        ),
        selection = Date { date ->
            Log.d("Selected Date", "$date")
        })

    Box(
        modifier = Modifier
            .fillMaxSize()
            .paint(
                painterResource(id = drawable.background),
                contentScale = ContentScale.FillWidth
            ),
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(bottom = 16.dp),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Column {
                Text(
                    fontSize = 48.sp,
                    text = "Select guests, data and time",
                    style = MaterialTheme.typography.displayLarge,
                    color = ShackleHotelBuddyTheme.colors.white,
                    modifier = Modifier
                        .padding(vertical = 40.dp)
                        .padding(horizontal = 24.dp)
                )
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .wrapContentHeight()
                        .padding(16.dp)
                        .background(
                            ShackleHotelBuddyTheme.colors.white,
                            RoundedCornerShape(16.dp)
                        )
                ) {
                    Column {
                        DateSelectionView(
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(60.dp),
                            title = "Check-in date",
                            selectedDate = "10 / 10/ 2023"
                        ) {
                            calendarState.show()
                        }
                        Divider(
                            color = Color.LightGray, modifier = Modifier
                                .fillMaxWidth()
                                .height(1.dp)
                        )
                        DateSelectionView(
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(60.dp),
                            title = "Check-out date",
                            selectedDate = "15 / 10/ 2023"
                        ) {
                            calendarState.show()
                        }
                        Divider(
                            color = Color.LightGray, modifier = Modifier
                                .fillMaxWidth()
                                .height(1.dp)
                        )
                        PersonInputView(
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(60.dp),
                            title = "Adults",
                            inputText = "1"
                        ) {}
                        Divider(
                            color = Color.LightGray, modifier = Modifier
                                .fillMaxWidth()
                                .height(1.dp)
                        )
                        PersonInputView(
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(60.dp),
                            title = "Children",
                            inputText = "2"
                        ) {}
                    }
                }
                RecentSearchView()
            }
            Button(modifier = Modifier
                .fillMaxWidth()
                .height(48.dp)
                .padding(horizontal = 16.dp)
                .background(Color.Cyan, RoundedCornerShape(8.dp)),
                colors = ButtonDefaults.outlinedButtonColors(containerColor = Color.Cyan),
                onClick = {
                    onSearchClicked()
                }) {
                Text("Search")
            }
        }
    }
}

@RequiresApi(VERSION_CODES.O)
@Preview("HomeScreen")
@Composable
private fun HomeScreenPreview() {
    ShackleHotelBuddyTheme {
        HomeScreen(
            onSearchClicked = {},
        )
    }
}
