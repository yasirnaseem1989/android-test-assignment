package com.example.shacklehotelbuddy.ui.activity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.shacklehotelbuddy.R.drawable
import com.example.shacklehotelbuddy.ui.detail.DetailScreen
import com.example.shacklehotelbuddy.ui.home.HomeScreen
import com.example.shacklehotelbuddy.ui.theme.ShackleHotelBuddyTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ShackleHotelBuddyTheme {

                val navController = rememberNavController()

                NavHost(navController, startDestination = "home") {

                    composable("home") {
                        HomeScreen(
                            onSearchClicked = { navController.navigate("detail") },
                        )
                    }

                    composable("detail") {
                        DetailScreen(
                            onBackClick = { navController.navigateUp() }
                        )
                    }
                }
            }
        }
    }
}