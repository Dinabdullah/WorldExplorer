package com.example.worldexplorer.data.remote

import com.example.worldexplorer.data.remote.dto.Countries
import retrofit2.http.GET
import retrofit2.http.Query

interface CountriesApi {
    @GET("all")
    suspend fun getAllCountries(
        @Query("fields") fields:String= "name,region,population,capital,flags"
    ):List<Countries>
}