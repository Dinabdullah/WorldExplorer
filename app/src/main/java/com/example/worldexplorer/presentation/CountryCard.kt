package com.example.worldexplorer.presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.example.worldexplorer.domain.entites.Country

@Composable
fun CountryCard(country: Country) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        shape = RoundedCornerShape(12.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Row(modifier = Modifier.padding(16.dp)) {

            Image(
                painter = rememberAsyncImagePainter(country.flags?.png),
                contentDescription = country.flags?.alt ?: "Flag",
                modifier = Modifier.size(64.dp),
                contentScale = ContentScale.Crop
            )

            Spacer(modifier = Modifier.width(16.dp))

            Column {
                Text(text = country.name?.common ?: "Unknown", fontWeight = FontWeight.Bold)
                Text(text = "Population: ${country.population ?: "N/A"}")
                Text(text = "Region: ${country.region ?: "N/A"}")
                Text(text = "Capital: ${country.capital?.joinToString() ?: "N/A"}")
            }
        }
    }
}
