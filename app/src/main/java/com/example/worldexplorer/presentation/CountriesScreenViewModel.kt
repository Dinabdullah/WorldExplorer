package com.example.worldexplorer.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.worldexplorer.domain.entites.Country
import com.example.worldexplorer.domain.usecase.GetAllCountriesUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class CountriesScreenViewModel(
    private val getAllCountriesUseCase: GetAllCountriesUseCase
) : ViewModel() {

    private val _countries = MutableStateFlow<List<Country>>(emptyList())
    val countries = _countries.asStateFlow()

    init {
        fetchCountries()
    }

    private fun fetchCountries() {
        viewModelScope.launch {
            _countries.value = getAllCountriesUseCase()
        }
    }
}
