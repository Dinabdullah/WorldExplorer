package com.example.worldexplorer.domain.repository

import com.example.worldexplorer.domain.entites.Country

interface CountryRepository {
    suspend fun getAllCountries():List<Country>
    suspend fun getCountryByName(name: String): Country?

}