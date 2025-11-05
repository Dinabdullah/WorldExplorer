package com.example.worldexplorer.presentation

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue

@Composable
fun CountriesScreen(viewModel: CountriesScreenViewModel) {
    val countries by viewModel.countries.collectAsState()

    LazyColumn {
        items(countries) { country ->
            CountryCard(country = country)
        }
    }
}

