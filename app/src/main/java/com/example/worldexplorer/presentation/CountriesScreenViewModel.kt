package com.example.worldexplorer.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.worldexplorer.domain.entites.Country
import com.example.worldexplorer.domain.usecase.GetAllCountriesUseCase
import com.example.worldexplorer.domain.usecase.GetCountryByNameUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CountriesScreenViewModel @Inject constructor(
    private val getAllCountriesUseCase: GetAllCountriesUseCase,
    private val getCountryByNameUseCase: GetCountryByNameUseCase
) : ViewModel() {

    private val _countries = MutableStateFlow<List<Country>>(emptyList())
    val countries = _countries.asStateFlow()

    private val _isLoading = MutableStateFlow(false)
    val isLoading = _isLoading.asStateFlow()

    private val _error = MutableStateFlow<String?>(null)
    val error = _error.asStateFlow()

    private val _searchQuery = MutableStateFlow("")
    val searchQuery = _searchQuery.asStateFlow()

    init {
        fetchCountries()
    }
    private var allCountries: List<Country> = emptyList()

    fun fetchCountries() {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                _isLoading.value = true
                val result = getAllCountriesUseCase()
                _countries.value = result
                allCountries = result
            } catch (e: Exception) {
                _error.value = e.message
            } finally {
                _isLoading.value = false
            }

        }
    }

    fun onSearchQueryChange(query: String) {
        _searchQuery.value = query

        viewModelScope.launch {
            if (query.isBlank()) {
                _countries.value = allCountries
            } else {
                val filtered = allCountries.filter {
                    it.name?.common?.contains(query, ignoreCase = true) == true ||
                            it.name?.official?.contains(query, ignoreCase = true) == true
                }
                _countries.value = filtered
            }
        }
    }



    private fun searchCountryByName(name: String) {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                _isLoading.value = true
                val result = getCountryByNameUseCase(name)
                _countries.value = listOfNotNull(result)
            } catch (e: Exception) {
                _error.value = e.message
            } finally {
                _isLoading.value = false
            }
        }
    }
}

