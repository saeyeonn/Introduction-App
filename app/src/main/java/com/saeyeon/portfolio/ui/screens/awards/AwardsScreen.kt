package com.saeyeon.portfolio.ui.screens.awards

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.saeyeon.portfolio.data.model.Award
import com.saeyeon.portfolio.ui.components.card.AwardCard

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AwardsScreen(navController: NavController) {
    // Material Design layout
    Scaffold(
        // title styling
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        "Awards",
                        style = MaterialTheme.typography.titleLarge,
                        color = Color(0xFF55808B)
                    )
                },
                // back button
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = "Back",
                            tint = Color(0xFF55808B)
                        )
                    }
                },
                // app bar color
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color.White,
                    navigationIconContentColor = Color(0xFF55808B)
                )
            )
        }
    ) { padding ->
        // LazyColumn for scrollable content
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .padding(horizontal = 16.dp),
            verticalArrangement = Arrangement.spacedBy(24.dp)
        ) {
            // Spacer for top padding
            item {
                Spacer(modifier = Modifier.height(8.dp))
            }

            // AwardCard for each award
            item {
                AwardCard(
                    Award(
                        "IT SERVICE PLANNING CONTEST",
                        "ITM",
                        "2023",
                        "Received 2nd award for mobile application planning"
                    )
                )
            }

            // AwardCard for each award
            items(
                awards.filter { it.date == "2022" }
                    .sortedByDescending { it.title }
            ) { award ->
                AwardCard(award)
            }

            // Spacer for bottom padding
            item {
                Spacer(modifier = Modifier.height(16.dp))
            }
        }
    }
}

// Sample data
val awards = listOf(
    Award(
        "IT SERVICE PLANNING CONTEST",
        "ITM",
        "2023",
        "Received 2nd award for mobile application planning"
    ),
    Award(
        "IT SERVICE PLANNING CONTEST",
        "ITM",
        "2022",
        "Received 3nd award for mobile application planning"
    ),
    Award(
        "IT SERVICE DEVELOPMENT CONTEST",
        "ITM",
        "2022",
        "Received 3nd award for mobile application development"
    )
)