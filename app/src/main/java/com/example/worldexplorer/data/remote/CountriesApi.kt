package com.example.worldexplorer.data.remote

import com.example.worldexplorer.data.remote.dto.CountryDto
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface CountriesApi {
    @GET("all")
    suspend fun getAllCountries(
        @Query("fields") fields:String= "name,region,population,capital,flags"
    ):List<CountryDto>

    @GET("name/{name}")
    suspend fun getCountryByName(
        @Path("name") name: String,
        @Query("fields") fields: String = "name,region,population,capital,flags"
    ): List<CountryDto>

}