package com.saeyeon.portfolio.ui.screens.education

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
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
import com.saeyeon.portfolio.ui.components.card.EducationCard


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EducationScreen(navController: NavController) {
    // Material Design layout
    Scaffold(
        topBar = {
            TopAppBar(
                // title styling
                title = {
                    Text(
                        "Education",
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

            // EducationCard for each school
            item {
                EducationCard(
                    schoolName = "NORTHUMBRIA UNIVERSITY",
                    degree = "Bachelor of ITMB",
                    year = "2023 - 2026"
                )
            }

            item {
                EducationCard(
                    schoolName = "SEOUL NATIONAL UNIVERSITY OF SCIENCE AND TECHNOLOGY",
                    degree = "Bachelor of ITM",
                    year = "2021 - 2026"
                )
            }

            item {
                EducationCard(
                    schoolName = "EWHA GIRLS' HIGH SCHOOL",
                    year = "2017 - 2020"
                )
            }

            item {
                EducationCard(
                    schoolName = "YEOMCHANG MIDDLE SCHOOL",
                    year = "2014 - 2017"
                )
            }

            item {
                EducationCard(
                    schoolName = "YEOMDONG ELEMENTARY SCHOOL",
                    year = "2008 - 2014"
                )
            }

            item {
                Spacer(modifier = Modifier.height(16.dp))
            }
        }
    }
}