package com.example.worldexplorer.domain.usecase

import com.example.worldexplorer.domain.entites.Country
import com.example.worldexplorer.domain.repository.CountryRepository

class GetCountryByNameUseCase(private val repository: CountryRepository) {
    suspend operator fun invoke(name: String): Country? {
        return repository.getCountryByName(name)
    }
}