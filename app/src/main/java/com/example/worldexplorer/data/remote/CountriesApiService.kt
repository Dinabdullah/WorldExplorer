package com.example.worldexplorer.data.remote

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object CountriesApiService {
    val api: CountriesApi by lazy {
        Retrofit.Builder()
            .baseUrl("https://restcountries.com/v3.1/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(CountriesApi::class.java)
    }
}