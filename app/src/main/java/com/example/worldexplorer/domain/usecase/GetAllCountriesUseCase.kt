package com.example.worldexplorer.domain.usecase

import com.example.worldexplorer.domain.entites.Country
import com.example.worldexplorer.domain.repository.CountryRepository

class GetAllCountriesUseCase(private val repository:CountryRepository) {
    suspend operator fun invoke():List<Country>{
        return repository.getAllCountries()
    }
}