package com.example.worldexplorer.data.repository

import com.example.worldexplorer.data.mapper.toDomain
import com.example.worldexplorer.data.remote.CountriesApi
import com.example.worldexplorer.domain.entites.Country
import com.example.worldexplorer.domain.repository.CountryRepository

class CountryRepositoryImpl(private val api: CountriesApi) :CountryRepository {
    override suspend fun getAllCountries(): List<Country> {
        val response =api.getAllCountries()
        return response.map { it.toDomain() }
    }

    override suspend fun getCountryByName(name: String): Country? {
        val response = api.getCountryByName(name)
        return response.firstOrNull()?.toDomain() // ناخد أول دولة لو موجودة
    }
}