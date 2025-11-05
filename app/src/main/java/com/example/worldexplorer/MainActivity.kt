package com.example.worldexplorer

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.worldexplorer.data.remote.CountriesApi
import com.example.worldexplorer.data.repository.CountryRepositoryImpl
import com.example.worldexplorer.domain.usecase.GetAllCountriesUseCase
import com.example.worldexplorer.presentation.CountriesScreen
import com.example.worldexplorer.presentation.CountriesScreenViewModel
import com.example.worldexplorer.ui.theme.WorldExplorerTheme
import dagger.hilt.android.AndroidEntryPoint
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    private val viewModel: CountriesScreenViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            WorldExplorerTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { _ ->
                    CountriesScreen(viewModel = viewModel)
                }
            }
        }
    }
}

