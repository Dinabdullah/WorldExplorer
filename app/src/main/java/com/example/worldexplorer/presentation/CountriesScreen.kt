package com.example.worldexplorer.presentation

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun CountriesScreen(viewModel: CountriesScreenViewModel = hiltViewModel()) {
    val countries by viewModel.countries.collectAsState()

    LazyColumn {
        items(countries) { country ->
            CountryCard(country = country)
        }
    }
}

