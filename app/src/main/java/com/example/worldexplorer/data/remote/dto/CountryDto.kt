package com.example.worldexplorer.data.remote.dto

import com.google.gson.annotations.SerializedName

data class CountryDto(
    @SerializedName("capital")
    val capital: List<String?>?,
    @SerializedName("flags")
    val flags: FlagsDto?,
    @SerializedName("name")
    val name: NameDto?,
    @SerializedName("population")
    val population: Int?,
    @SerializedName("region")
    val region: String?
)