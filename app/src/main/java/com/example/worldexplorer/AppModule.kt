package com.example.worldexplorer

import com.example.worldexplorer.data.remote.CountriesApi
import com.example.worldexplorer.data.repository.CountryRepositoryImpl
import com.example.worldexplorer.domain.repository.CountryRepository
import com.example.worldexplorer.domain.usecase.GetAllCountriesUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideRetrofit(): Retrofit = Retrofit.Builder()
        .baseUrl("https://restcountries.com/v3.1/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    @Provides
    @Singleton
    fun provideCountriesApi(retrofit: Retrofit): CountriesApi =
        retrofit.create(CountriesApi::class.java)

    @Provides
    @Singleton
    fun provideCountryRepository(api: CountriesApi): CountryRepository =
        CountryRepositoryImpl(api)

    @Provides
    @Singleton
    fun provideGetAllCountriesUseCase(repository: CountryRepository): GetAllCountriesUseCase =
        GetAllCountriesUseCase(repository)
}
